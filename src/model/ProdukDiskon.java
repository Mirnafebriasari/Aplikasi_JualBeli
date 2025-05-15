package model;

public class ProdukDiskon extends Produk {
    public ProdukDiskon(String nama, double harga, int stok, double diskon, double hargaBeli) {
        super(nama, harga, stok, diskon, hargaBeli);
    }

    @Override
    public double getHargaSetelahDiskon() {
        return super.getHargaSetelahDiskon();
    }
}
