/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

/**
 *
 * @author Asus
 */

import gui.LoginFrame;
import service.Database;
import model.Produk;
import model.Transaksi;
import javax.swing.*;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) {    
        try {
            Database.loadProdukFromDatabase();
            Database.loadTransaksiFromDatabase();

            System.out.println("\nDaftar Produk:");
            for (Produk produk : Database.getDaftarProduk()) {
                System.out.println(produk);
            }
            
          System.out.println("\nDaftar Transaksi:");
            for (Transaksi transaksi : Database.getDaftarTransaksi()) {
                System.out.println(transaksi); 
            }
     
            javax.swing.SwingUtilities.invokeLater(() -> {
                new LoginFrame().setVisible(true);
            });

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal memuat produk dari database: " + e.getMessage());
        }
        
       
    }
    
}

