// 09_Kartiko Widyotomo
// SIB1G

public class SistemToko09{
Barang09[] daftarBarang = new Barang09[100];
    int jumlahBarang = 0;

    void tambahBarang(Barang09 b) {
        daftarBarang[jumlahBarang++] = b;
    }

    void tampilData() {
        System.out.println("kode | Nama           | Stok | Harga");
        System.out.println("==========================================");
        for (int i = 0; i < jumlahBarang; i++) {
            Barang09 b = daftarBarang[i];
            System.out.printf("%-4s | %-14s | %-4d | %d\n", b.kode, b.nama, b.stok, b.harga);
            System.out.println("------------------------------------------");
        }
    }

    Barang09 cariBarang(String kode) {
        for (int i = 0; i < jumlahBarang; i++) {
            if (daftarBarang[i].kode.equalsIgnoreCase(kode)) {
                return daftarBarang[i];
            }
        }
        return null;
    }

    void prosesPenjualan(String[] kodeBeli, int[] jumlahBeli, int banyak) {
        System.out.println("\nkode | Nama           | Jumlah | Harga  | Total Harga");
        System.out.println("=========================================================");
        int total = 0;
        for (int i = 0; i < banyak; i++) {
            Barang09 b = cariBarang(kodeBeli[i]);
            if (b != null) {
                int totalHarga = b.jual(jumlahBeli[i]);
                total += totalHarga;
                System.out.printf("%-4s | %-14s | %-6d | %-6d | %d\n",
                        b.kode, b.nama, jumlahBeli[i], b.harga, totalHarga);
            } else {
                System.out.println("Barang dengan kode " + kodeBeli[i] + " tidak ditemukan.");
            }
        }
        System.out.println("=========================================================");
        System.out.println("Total bayar adalah = " + total);
    }

    void urutkanStokTerbanyak() {
        for (int i = 0; i < jumlahBarang - 1; i++) {
            for (int j = i + 1; j < jumlahBarang; j++) {
                if (daftarBarang[i].stok < daftarBarang[j].stok) {
                    Barang09 tmp = daftarBarang[i];
                    daftarBarang[i] = daftarBarang[j];
                    daftarBarang[j] = tmp;
                }
            }
        }

        System.out.println("Berikut ini adalah List Daftar Barang dengan stok terbanyak ke sedikit:");
        tampilData();
    }

    void tampilkanTerlaris() {
        if (jumlahBarang == 0) return;
        Barang09 terlaris = daftarBarang[0];
        for (int i = 1; i < jumlahBarang; i++) {
            if (daftarBarang[i].terjual > terlaris.terjual) {
                terlaris = daftarBarang[i];
            }
        }
        System.out.println("Barang terlaris adalah " + terlaris.nama + " dengan jumlah penjualan adalah " + terlaris.terjual);
    }
}