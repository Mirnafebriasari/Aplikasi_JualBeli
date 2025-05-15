 # Aplikasi Penjualan Produk

## Deskripsi Singkat
Aplikasi Penjualan Produk adalah program berbasis Java yang mengimplementasikan konsep **Object-Oriented Programming (OOP)** dan menggunakan **SQLite** untuk penyimpanan data permanen. Aplikasi ini adalah sistem yang memfasilitasi proses transaksi antara penjual dan pembeli melalui platform digital. Aplikasi ini menyediakan berbagai fitur untuk mengelola barang yang dijual, melakukan transaksi pembelian, serta menyediakan laporan penjualan. Aplikasi ini terdiri dari tiga peran utama: **Admin**, **Kasir**, dan **Pimpinan**, yang masing-masing memiliki akses dan fitur berbeda sesuai fungsinya.

---

## Fitur Utama

### Login
- Pengguna memilih untuk masuk sebagai **Admin**, **Kasir**, atau **Pimpinan**.
- Setiap peran memiliki hak akses dan fitur berbeda.
### A. Admin  (Kelola produk)
1. Menambahkan produk ke database  
   > Jika nama produk yang ditambahkan sudah ada, maka data akan di-*update* (bukan ditambah dua kali).
2. Mengatur nama produk, diskon, harga beli, dan harga jual.
3. Menghapus produk  
   > Jika produk dihapus, maka semua transaksi yang berkaitan dengan produk tersebut juga akan dihapus.
4. Melihat produk lengkap dengan tanggal dan jam aktivitas.
5. Menyimpan data produk ke database permanen (SQLite).

### B. Kasir (Lakukan dan kelola transaksi)
1. Melakukan transaksi penjualan.
2. Mengurangi stok produk secara otomatis setelah transaksi berhasil.
3. Menghapus transaksi  
   > Jika transaksi dihapus, stok produk akan dikembalikan sesuai jumlah yang terjual.
4. Melihat aktivitas transaksi lengkap dengan tanggal dan jam.
5. Menyimpan transaksi ke database permanen (SQLite).

### C. Pimpinan (Akses laporan dan analisis)
1. Melihat laporan transaksi bulanan.
2. Melihat laporan pengeluaran bulanan.
3. Menghitung total pendapatan bersih dari penjualan.

### D. Database
1. Penyimpanan data produk dan transaksi secara permanen menggunakan **SQLite**.
2. Otomatis membuat tabel `produk` dan `transaksi` saat aplikasi pertama kali dijalankan jika belum ada menggunakan file .db.
   
---
### query SQL (Structured Query Language)
Query SQL (Structured Query Language) adalah perintah yang digunakan untuk berinteraksi dengan database, baik untuk membuat struktur database, memasukkan, mengambil, memperbarui, maupun menghapus data. 
# jenis query SQL yang digunakan:
- DDL (Data Definition Language)
  1. CREATE TABLE
- DML (Data Manipulation Language)
  1. INSERT INTO
  2. UPDATE
  3. DELETE FROM
- DQL (Data Query Language)
  1. SELECT
     
---

## Struktur Folder
```
AplikasiJualBeli/
└── Source Packages/  
    ├── app/
    │   └── Main.java
    ├── gui/
    │   ├── AdminFrame.java
    │   ├── KasirFrame.java
    │   ├── LoginFrame.java
    │   └── PimpinanFrame.java
    ├── model/
    │   ├── Produk.java
    │   ├── ProdukDiskon.java
    │   ├── ProdukInterface.java
    │   └── Transaksi.java
    └── service/
        └── Database.java

```
---
## Cara Menjalankan
  1. Pastikan Anda sudah menginstal **Java JDK** dan **NetBeans** (atau IDE lain seperti IntelliJ atau Eclipse).
  2. Clone https://github.com/Mirnafebriasari/Aplikasi_JualBeli.git di cmd
  3. Buka proyek di IDE, pastikan file `sqlite-jdbc.jar` sudah ditambahkan ke library proyek.
  4. Jalankan `Main.java` dari IDE.
  5. Program akan otomatis membuat file `database.db` di folder `resources/` jika belum tersedia.
---


## Pembagian Tugas Per Anggota

- **FEMILIA PADAUNAN (H071241012)**  
  Membuat kode class java yang mencakup
  
  o Object & Class
  
  o Attribute, Behavior & Constructor
  
  o Encapsulation
  
  o Inheritence
  
  o Abstract & Interface
  
  o Polymorphism

- **MIRNA FEBRIASARI (H071241078)**
  Mengembangkan kode kelas Java agar semua prinsip-prinsip OOP dapat terimplementasi dengan baik. Selain itu, bertanggung jawab dalam merancang dan mengimplementasikan struktur kelas utama aplikasi. Ia juga mengatur alur logika penambahan produk serta mengelola seluruh fitur yang berkaitan dengan peran Admin, termasuk penambahan stok, pembaruan data produk, dan penghapusan produk. Di samping itu, ia menangani manajemen penyimpanan data menggunakan SQLite untuk memastikan data produk dan transaksi tersimpan secara permanen den membuat file Database. ia juga mengamati ulang dan memastikan bahwa seluruh fitur dalam aplikasi berjalan lancar.

- **NAYLA ZAKY FAUZIAH (H071241064)**   
  Menyusun dan mengimplementasikan fitur-fitur yang digunakan oleh Pimpinan, seperti pembuatan laporan transaksi bulanan, laporan pengeluaran, dan perhitungan total pendapatan.

- **SITI NUR HALISA TAHIR (H071241086)**  
  Menyusun dan mengimplementasikan fitur-fitur yang digunakan oleh Kasir, seperti penambahan transaksi penjualan, penghapusan aktivitas transaksi yang telah dilakukan, melihat riwayat hasil transaksi, serta pengurangan stok pada produk yang terjual sehingga stok produk diperbarui secara otomatis setelah transaksi selesai.

- **SYAHRANI ZAKIYAH NURFAIZAH (H071241042)**  
  Mengurus dokumentasi proyek, termasuk penyusunan file `README.md`, serta memastikan bahwa semua fitur aplikasi terdokumentasi secara lengkap dan mudah dipahami oleh pengguna maupun pengembang lain.
---

