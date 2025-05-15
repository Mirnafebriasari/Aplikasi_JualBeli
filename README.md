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
### jenis query SQL yang digunakan:
- DDL (Data Definition Language)
  1. CREATE TABLE
- DML (Data Manipulation Language)
  1. INSERT INTO
  2. UPDATE
  3. DELETE FROM
- DQL (Data Query Language)
  1. SELECT
     
---

### Struktur Folder
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
### Cara Menjalankan
  1. Pastikan Anda sudah menginstal **Java JDK** dan **NetBeans** (atau IDE lain seperti IntelliJ atau Eclipse).
  2. git clone https://github.com/Mirnafebriasari/Aplikasi_JualBeli.git (di Command Prompt)
  3. Download ZIP (alternatif mudah) Klik tombol Code → pilih Download ZIP lalu Ekstrak file ZIP ke folder di komputer kamu
  4. Buka proyek di IDE, pastikan file `sqlite-jdbc.jar` sudah ditambahkan ke library proyek.
  5. Jalankan `Main.java` dari IDE.
  6. Program akan otomatis membuat file `database.db` di folder `resources/` jika belum tersedia.
---


### 📌 Pembagian Tugas Per Anggota
👩‍💻 FEMILIA PADAUNAN (H071241012)
Bertanggung jawab dalam membuat dan mengelola class Produk dan ProdukDiskon, yang merupakan inti dari pengelolaan data produk dalam aplikasi. Tugas ini mencakup perancangan atribut dan method untuk menyimpan data produk serta produk yang memiliki diskon, termasuk logika perhitungan harga akhir setelah diskon. Ia juga memastikan bahwa struktur class telah mengikuti prinsip-prinsip Object-Oriented Programming (OOP) dan dapat terintegrasi dengan lancar ke seluruh fitur aplikasi, khususnya dalam modul Admin dan Kasir.

🗃️ MIRNA FEBRIASARI (H071241078)

Bertanggung jawab penuh dalam pengelolaan penyimpanan data menggunakan SQLite. Ia membuat dan mengatur class Database.java, merancang struktur tabel produk dan transaksi, serta mengatur koneksi antar class dan database agar penyimpanan data bersifat permanen.
Selain itu, Mirna menangani dokumentasi proyek di GitHub, seperti unggah proyek, struktur direktori, file .gitignore, dan README.md. Ia juga berperan dalam melakukan pengujian akhir seluruh fitur, memastikan tidak ada bug sebelum aplikasi dirilis.

🖼️ NAYLA ZAKY FAUZIAH (H071241064)

Bertanggung jawab dalam merancang dan membangun antarmuka grafis (GUI) untuk peran Admin dan Kasir, menggunakan editor GUI berbasis drag-and-drop di NetBeans. Ia membuat file .java dan .form yang memuat elemen seperti tombol, form input, tabel, dan area aktivitas. Nayla memastikan bahwa tampilan antarmuka intuitif, responsif, dan sesuai alur penggunaan aplikasi, termasuk interaksi dengan database serta validasi data input.

🔐 SITI NUR HALISA TAHIR (H071241086)

Mengembangkan fitur untuk role Pimpinan dan Login, mencakup sistem autentikasi login pengguna berdasarkan peran, akses ke laporan transaksi dan pengeluaran bulanan, serta fitur perhitungan total pendapatan bersih. Ia juga menangani logika penambahan transaksi penjualan, penghapusan transaksi, dan pengurangan stok produk secara otomatis setelah transaksi berhasil. Semua fitur ini dikembangkan dengan memperhatikan konsistensi data dan validasi proses bisnis.

🧾 SYAHRANI ZAKIYAH NURFAIZAH (H071241042)

Bertanggung jawab atas pembuatan dan pengelolaan class ProdukInterface dan Transaksi. Ia menyusun kontrak interface untuk mengatur standar perilaku class produk, lalu mengimplementasikannya dalam class-class turunan. Syahrani juga membangun logika transaksi pembelian, termasuk pencatatan pembelian, perhitungan total harga, dan pengelolaan data transaksi yang terhubung dengan stok produk. Ia memastikan setiap proses transaksi berjalan sesuai prosedur aplikasi dan prinsip OOP.




