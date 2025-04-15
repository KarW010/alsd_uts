// 09_Kartiko Widyotomo
// SIB1G

public class Barang09{
    String kode, nama;
    int stok, harga, terjual;

    Barang09 (String kode, String nama, int stok, int harga) {
        this.kode = kode;
        this.nama = nama;
        this.stok = stok;
        this.harga = harga;
        this.terjual = 0;
    }

    int jual(int jumlah) {
        if (jumlah <= stok) {
            stok -= jumlah;
            terjual += jumlah;
            return jumlah * harga;
        } else {
            System.out.println("Stok tidak cukup untuk barang " + nama);
            return 0;
        }
    }
}