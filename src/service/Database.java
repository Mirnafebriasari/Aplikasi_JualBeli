/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Asus
 */






package service;

import model.Produk;
import model.ProdukDiskon;
import model.Transaksi;
import java.sql.*;
import java.util.ArrayList;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;
import java.util.Iterator;





public class Database {
    private static final ArrayList<Produk> daftarProduk = new ArrayList<>();
    private static final ArrayList<Transaksi> daftarTransaksi = new ArrayList<>();
    private static List<Transaksi> listTransaksi = new ArrayList<>();
    private static List<Produk> listProduk = new ArrayList<>();
    private static Connection connection;
    private static final String DB_URL = "jdbc:sqlite:resources/database.db";
    private static final ZoneId TIMEZONE = ZoneId.of("Asia/Makassar");
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // Mendapatkan koneksi SQLite
    public static Connection getConnection() throws SQLException {
        File folder = new File("resources");
        if (!folder.exists()) folder.mkdirs();

        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(DB_URL);
            createTablesIfNotExist();
        }
        return connection;
    }

    // Buat tabel jika belum ada
    private static void createTablesIfNotExist() {
        String createProduk = """
        CREATE TABLE IF NOT EXISTS produk (
            nama TEXT PRIMARY KEY,
            harga REAL NOT NULL,
            stok INTEGER NOT NULL,
            diskon REAL DEFAULT 0,
            tanggal TEXT,
            hargaBeli REAL
        );
    """;

        String createTransaksi = """
           CREATE TABLE IF NOT EXISTS transaksi (
                id_produk TEXT NOT NULL,
                jumlah INTEGER NOT NULL,
                total_harga REAL NOT NULL,
                tanggal TEXT,
                FOREIGN KEY(id_produk) REFERENCES produk(nama)
            );
    """;

        try (Statement stmt = getConnection().createStatement()) {
            stmt.execute(createProduk);
            stmt.execute(createTransaksi);
        } catch (SQLException e) {
            System.err.println("Gagal membuat tabel: " + e.getMessage());
        }
    }

    public static void simpanProdukKeDatabase(Produk produk) throws SQLException {
        String timestamp = LocalDateTime.now(TIMEZONE).format(FORMATTER);
        String sql = "INSERT INTO produk (nama, harga, stok, diskon, tanggal, hargaBeli) VALUES (?, ?, ?, ?, ?, ?) " +
                     "ON CONFLICT(nama) DO UPDATE SET stok = produk.stok + excluded.stok, tanggal = excluded.tanggal, harga = excluded.harga, diskon = excluded.diskon, hargaBeli = excluded.hargaBeli;";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, produk.getNama());
            ps.setDouble(2, produk.getHarga());
            ps.setInt(3, produk.getStok());
            ps.setDouble(4, produk.getDiskon());
            ps.setString(5, timestamp);
            ps.setDouble(6, produk.getHargaBeli()); 
            ps.executeUpdate();

        }
        
    }

    public static void simpanTransaksiKeDatabase(Transaksi transaksi) throws SQLException {
        String timestamp = LocalDateTime.now(TIMEZONE).format(FORMATTER);
        String insert = "INSERT INTO transaksi (id_produk, jumlah, total_harga, tanggal) VALUES (?, ?, ?, ?)";
        Produk produk = transaksi.getProduk();
        int newStok = produk.getStok() - transaksi.getJumlah();
        produk.setStok(newStok);

        try (PreparedStatement ps = getConnection().prepareStatement(insert)) {
            ps.setString(1, produk.getNama());
            ps.setInt(2, transaksi.getJumlah());
            ps.setDouble(3, transaksi.getTotalHarga());
            ps.setString(4, timestamp);
            ps.executeUpdate();
        }

        String update = "UPDATE produk SET stok = ?, tanggal = ? WHERE nama = ?";
        try (PreparedStatement ps2 = getConnection().prepareStatement(update)) {
            ps2.setInt(1, newStok);
            ps2.setString(2, timestamp);
            ps2.setString(3, produk.getNama());
            ps2.executeUpdate();
        }
        
        
    }
    
    public static void loadProdukFromDatabase() throws SQLException {
        daftarProduk.clear();
        listProduk.clear();
        String sql =  "SELECT nama, harga, stok, diskon, tanggal, hargaBeli FROM produk";
        try (Statement stmt = getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Produk p = new ProdukDiskon(
                    rs.getString("nama"),
                    rs.getDouble("harga"),
                    rs.getInt("stok"),
                    rs.getDouble("diskon"),
                    rs.getDouble("hargaBeli")
                );
                p.setTanggal(rs.getString("tanggal"));
                daftarProduk.add(p);
                listProduk.add(p);
                
            }
            
        }
    }

    public static void loadTransaksiFromDatabase() throws SQLException {
        daftarTransaksi.clear();
        listTransaksi.clear();
        String sql = "SELECT id_produk, jumlah, total_harga, tanggal FROM transaksi";
        try (Statement stmt = getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String namaProduk = rs.getString("id_produk");
                int jumlah = rs.getInt("jumlah");
                String tanggal = rs.getString("tanggal");

                Produk produkAsli = null;
                for (Produk p : getDaftarProduk()) {
                    if (p.getNama().equalsIgnoreCase(namaProduk)) {
                        produkAsli = p;
                        break;
                    }
                }

                if (produkAsli != null) {
                    Transaksi t = new Transaksi(produkAsli, jumlah, tanggal);
                    daftarTransaksi.add(t);
                    listTransaksi.add(t);
                } 
            }
        }

        }

    public static ArrayList<Produk> getDaftarProduk() { return new ArrayList<>(daftarProduk); }
    public static ArrayList<Transaksi> getDaftarTransaksi() { return new ArrayList<>(daftarTransaksi); }

    public static boolean hapusProduk(String nama) throws SQLException {
        String sql = "DELETE FROM produk WHERE nama = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, nama);
            return ps.executeUpdate() > 0;
        }
    }

    // Menghapus transaksi, mengembalikan stok, dan memuat ulang data
    public static boolean hapusTransaksi(Transaksi transaksi) throws SQLException {
        String namaProduk = transaksi.getProduk().getNama();
        int jumlah = transaksi.getJumlah();

        String updateStok = "UPDATE produk SET stok = stok + ? WHERE nama = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(updateStok)) {
            ps.setInt(1, jumlah);
            ps.setString(2, namaProduk);
            ps.executeUpdate();
            
        }

        String deleteSql = "DELETE FROM transaksi WHERE id_produk = ? AND tanggal = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(deleteSql)) {
            ps.setString(1, namaProduk);
            ps.setString(2, transaksi.getTanggal());
            int affected = ps.executeUpdate();
            if (affected > 0) {
                loadProdukFromDatabase();
                loadTransaksiFromDatabase();
                return true;
            }
        }
        return false;
    }

    
    
    public static boolean hapusTransaksiByNamaProduk(String namaProduk) {
        boolean adaYangDihapus = false;

        try {
            loadTransaksiFromDatabase();

            Iterator<Transaksi> iterator = listTransaksi.iterator();
            while (iterator.hasNext()) {
                Transaksi t = iterator.next();
                if (t.getProduk().getNama().equalsIgnoreCase(namaProduk)) {
                    iterator.remove();
                    adaYangDihapus = true;
                }
            }

            if (adaYangDihapus) {
                simpanSemuaTransaksiKeDatabase();
            }

        } catch (Exception e) {
            System.err.println("Gagal menghapus transaksi berdasarkan nama: " + e.getMessage());
            return false;
        }

        return adaYangDihapus;
    }


    public static String getLaporanTransaksiByMonth(int month, int year) {
            double totalPemasukan = 0;
            StringBuilder sb = new StringBuilder();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            for (Transaksi t : daftarTransaksi) {
                try {
                    Date date = dateFormat.parse(t.getTanggal());
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(date);
                    int transaksiMonth = calendar.get(Calendar.MONTH) + 1;
                    int transaksiYear = calendar.get(Calendar.YEAR);

                    if (transaksiMonth == month && transaksiYear == year) {
                        sb.append(t).append("\n");
                        totalPemasukan += t.getTotalHarga();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            sb.append(String.format("\nTotal %d/%d: Rp%.2f", month, year, totalPemasukan));
            return sb.toString();
        }




    public static String getLaporanPengeluaranByMonth(int month, int year) {
        double totalPengeluaran = 0;
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // ✅ Perbaikan di sini

        for (Produk p : listProduk) { 
            try {
                Date date = dateFormat.parse(p.getTanggal());
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                int produkMonth = calendar.get(Calendar.MONTH) + 1;
                int produkYear = calendar.get(Calendar.YEAR);

                if (produkMonth == month && produkYear == year) {
                    double pengeluaranProduk = p.getHargaBeli() * p.getStok();
                    sb.append(String.format("%s - Stok: %d, Modal: Rp%.2f\n", p.getNama(), p.getStok(), pengeluaranProduk));
                    totalPengeluaran += pengeluaranProduk;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        sb.append(String.format("\nTotal Pengeluaran bulan %d/%d: Rp%.2f", month, year, totalPengeluaran));
        return sb.toString();
    }
    public static double getTotalPendapatanByMonth(int bulan, int tahun) {
        double total = 0;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        for (Transaksi t : listTransaksi) {
            LocalDate tanggal = LocalDate.parse(t.getTanggal(), formatter); // Konversi String ke LocalDate

            if (tanggal.getMonthValue() == bulan && tanggal.getYear() == tahun) {
                total += t.getTotalHarga();
            }
        }

        return total;
    }


    public static double getTotalPengeluaranByMonth(int bulan, int tahun) {
        double total = 0;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        for (Produk p : listProduk) {
            LocalDate tanggal = LocalDate.parse(p.getTanggal(), formatter);

            if (tanggal.getMonthValue() == bulan && tanggal.getYear() == tahun) {
                total += p.getHargaBeli();
            }
        }
        return total;
    }


    public static List<Produk> getListProduk() {
        return listProduk;
    }


    public static List<Transaksi> getListTransaksi() {
        return listTransaksi;
    }


    public static void simpanSemuaTransaksiKeDatabase() throws SQLException {
        String deleteAll = "DELETE FROM transaksi";
        try (Statement stmt = getConnection().createStatement()) {
            stmt.executeUpdate(deleteAll);
        }
        for (Transaksi t : listTransaksi) {
            simpanTransaksiKeDatabase(t);
        }
    }

    
        public static List<Transaksi> cariTransaksiByNamaProduk(String namaProduk) {
        List<Transaksi> hasil = new ArrayList<>();
        for (Transaksi t : daftarTransaksi) {
            if (t.getProduk().getNama().equalsIgnoreCase(namaProduk)) {
                hasil.add(t);
            }
        }
        return hasil;
    }

    public static Produk cariProduk(String namaProduk) {
        for (Produk p : daftarProduk) {
            if (p.getNama().equalsIgnoreCase(namaProduk)) {
                return p;
            }
        }
        return null;
    }

    public static Transaksi cariTransaksi(String namaProduk, String tanggal) {
        for (Transaksi t : daftarTransaksi) {
            if (t.getProduk().getNama().equalsIgnoreCase(namaProduk) && t.getTanggal().equals(tanggal)) {
                return t;
            }
        }
        return null;
      }
    }



