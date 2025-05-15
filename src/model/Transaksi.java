/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Asus
 */


    public class Transaksi {
        private Produk produk;
        private int jumlah;
        private String tanggal;

    public Transaksi(Produk produk, int jumlah, String tanggal) {
        this.produk = produk;
        this.jumlah = jumlah;
        this.tanggal = tanggal;
    }
    
    public Transaksi(Produk produk, int jumlah) {
        this(produk, jumlah, null);
    }

    public Produk getProduk() {
        return produk;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
        
    }
    
    
    public void setTotalHarga(double total) {
    }

    public double getTotalHarga() {
        return produk.getHargaSetelahDiskon() * jumlah;
    }
    
   
    public double getTotalHarga(double tambahanDiskon) {
        double hargaDiskon = produk.getHargaSetelahDiskon();
        return hargaDiskon * jumlah - (hargaDiskon * tambahanDiskon / 100);
    }

    


    @Override
    public String toString() {
        return String.format(
            "%s - Jumlah: %d, Total: Rp%.2f, Tanggal: %s",
            produk.getNama(),
            jumlah,
            jumlah * produk.getHargaSetelahDiskon(),
            tanggal != null ? tanggal : "Tidak tersedia"
        );
    }

    }


