/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;
import javax.swing.*;
import java.time.LocalDate;
import java.util.List;
import model.Produk;
import model.Transaksi;
import java.time.format.DateTimeFormatter;

public class PimpinanFrame extends JFrame {

    public PimpinanFrame() {
        initComponents();

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLihatLaporanProduk = new javax.swing.JButton();
        jLihatLaporanPenjualan = new javax.swing.JButton();
        jKembali = new javax.swing.JButton();
        jUntungRugi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));

        jLabel2.setFont(new java.awt.Font("Leelawadee", 1, 24)); // NOI18N
        jLabel2.setText("X");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 0));
        jLabel1.setText("Pimpinan");

        jLihatLaporanProduk.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLihatLaporanProduk.setText("Lihat Laporan Produk");
        jLihatLaporanProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLihatLaporanProdukActionPerformed(evt);
            }
        });

        jLihatLaporanPenjualan.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLihatLaporanPenjualan.setText("Lihat Laporan Penjualan");
        jLihatLaporanPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLihatLaporanPenjualanActionPerformed(evt);
            }
        });

        jKembali.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jKembali.setText("Kembali");
        jKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jKembaliActionPerformed(evt);
            }
        });

        jUntungRugi.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jUntungRugi.setText("Untung/Rugi");
        jUntungRugi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jUntungRugiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(96, 96, 96))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 66, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLihatLaporanPenjualan, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jUntungRugi, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLihatLaporanProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(64, 64, 64)))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addComponent(jLihatLaporanProduk)
                .addGap(43, 43, 43)
                .addComponent(jLihatLaporanPenjualan)
                .addGap(38, 38, 38)
                .addComponent(jUntungRugi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(jKembali)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLihatLaporanPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLihatLaporanPenjualanActionPerformed
 try {
        service.Database.loadTransaksiFromDatabase();

        List<Transaksi> transaksiList = service.Database.getListTransaksi();
        if (transaksiList.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Belum ada transaksi.", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        Transaksi transaksiTerakhir = transaksiList.get(transaksiList.size() - 1);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); // Format dengan waktu
        LocalDate tanggal = LocalDate.parse(transaksiTerakhir.getTanggal(), formatter);
        int bulan = tanggal.getMonthValue();
        int tahun = tanggal.getYear();

        String laporan = service.Database.getLaporanTransaksiByMonth(bulan, tahun);
        JOptionPane.showMessageDialog(this, laporan.isEmpty() ? "Belum ada transaksi di bulan " + bulan + "/" + tahun + "." : laporan);

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Gagal memuat laporan: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_jLihatLaporanPenjualanActionPerformed

    private void jLihatLaporanProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLihatLaporanProdukActionPerformed
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
try {
    service.Database.loadProdukFromDatabase();
    List<Produk> produkList = service.Database.getListProduk();
    if (produkList.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Tidak ada data produk.", "Info", JOptionPane.INFORMATION_MESSAGE);
        return;
    }

    Produk produkTerakhir = produkList.get(produkList.size() - 1);
    LocalDate tanggal = LocalDate.parse(produkTerakhir.getTanggal(), formatter);
    int month = tanggal.getMonthValue();
    int year = tanggal.getYear();

    String laporanProduk = service.Database.getLaporanPengeluaranByMonth(month, year);
    JOptionPane.showMessageDialog(this, laporanProduk != null && !laporanProduk.isEmpty() 
        ? laporanProduk : "Tidak ada produk untuk bulan ini.");
} catch (Exception e) {
    JOptionPane.showMessageDialog(this, "Gagal memuat produk: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
}


try {
    service.Database.loadTransaksiFromDatabase();
    List<Transaksi> transaksiList = service.Database.getListTransaksi();
    if (transaksiList.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Belum ada transaksi.", "Info", JOptionPane.INFORMATION_MESSAGE);
        return;
    }

    Transaksi transaksiTerakhir = transaksiList.get(transaksiList.size() - 1);
    LocalDate tanggal = LocalDate.parse(transaksiTerakhir.getTanggal(), formatter);
    int bulan = tanggal.getMonthValue();
    int tahun = tanggal.getYear();

    String laporan = service.Database.getLaporanTransaksiByMonth(bulan, tahun);
    JOptionPane.showMessageDialog(this, laporan.isEmpty() ? "Belum ada transaksi di bulan " + bulan + "/" + tahun + "." : laporan);
} catch (Exception e) {
    JOptionPane.showMessageDialog(this, "Gagal memuat laporan: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
}


    }//GEN-LAST:event_jLihatLaporanProdukActionPerformed

    private void jKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jKembaliActionPerformed
        this.dispose(); 
        new gui.LoginFrame().setVisible(true); 
    }//GEN-LAST:event_jKembaliActionPerformed

    private void jUntungRugiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUntungRugiActionPerformed
        // TODO add your handling code here:
        try {
        service.Database.loadTransaksiFromDatabase();
        service.Database.loadProdukFromDatabase();

        List<Transaksi> transaksiList = service.Database.getListTransaksi();
        if (transaksiList == null || transaksiList.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tidak ada transaksi.", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        Transaksi transaksiTerakhir = transaksiList.get(transaksiList.size() - 1);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDate tanggal = LocalDate.parse(transaksiTerakhir.getTanggal(), formatter);

        int bulan = tanggal.getMonthValue();
        int tahun = tanggal.getYear();

        double totalPendapatan = service.Database.getTotalPendapatanByMonth(bulan, tahun);
        double totalPengeluaran = service.Database.getTotalPengeluaranByMonth(bulan, tahun);


        double selisih = totalPendapatan - totalPengeluaran;
        String status = (selisih >= 0) ? "UNTUNG" : "RUGI";

        String laporan = "LAPORAN UNTUNG/RUGI\n\n"
                       + "Periode: " + bulan + "/" + tahun + "\n"
                       + "Total Pendapatan : Rp" + totalPendapatan + "\n"
                       + "Total Pengeluaran: Rp" + totalPengeluaran + "\n"
                       + "Selisih          : Rp" + selisih + " (" + status + ")";

        JOptionPane.showMessageDialog(this, laporan, "Laporan Untung/Rugi", JOptionPane.INFORMATION_MESSAGE);
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Gagal menghitung untung/rugi: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jUntungRugiActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PimpinanFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jKembali;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jLihatLaporanPenjualan;
    private javax.swing.JButton jLihatLaporanProduk;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jUntungRugi;
    // End of variables declaration//GEN-END:variables
}
