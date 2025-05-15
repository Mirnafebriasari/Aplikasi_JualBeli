/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Asus
 */


public abstract class Produk implements ProdukInterface {
    private String nama;
    private double harga;
    private int stok;
    private double diskon; 
    private String tanggal; 
    private double hargaBeli; 
   


    public Produk(String nama, double harga, int stok, double diskon, double hargaBeli) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
        this.diskon = diskon;
        this.hargaBeli = hargaBeli;
      
    }
    
    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    public double getDiskon() {
        return diskon;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public String getTanggal() {
        return tanggal;
    }
    
    
    public double getHargaBeli() {
        return hargaBeli;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
    

    public void setHargaBeli(double hargaBeli) {
        this.hargaBeli = hargaBeli;
    }

    public void kurangiStok(int jumlah) {
        if (jumlah <= stok) {
            stok -= jumlah;
        } else {
            System.out.println("Stok tidak mencukupi untuk produk: " + nama);
        }
    }

    public void tambahStok(int jumlah) {
        this.stok += jumlah;
    }

    @Override
    public double getHargaSetelahDiskon() {
        return harga - (harga * diskon / 100);
    }

    @Override
    public String toString() {
        return String.format(
            "%s - Rp%.2f (Diskon: %.1f%%, Stok: %d, Tanggal: %s)",
            nama,
            getHarga(),
            diskon,
            stok,
            tanggal != null ? tanggal : "Tidak tersedia"
        );
      }
    }

