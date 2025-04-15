// 09_Kartiko Widyotomo
// SIB1G

import java.util.Scanner;

public class SistemMain09{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        SistemToko09 toko = new SistemToko09();

        boolean jalan = true;
        while (jalan) {
            System.out.println("\n1. Input Barang");
            System.out.println("2. Penjualan Barang");
            System.out.println("3. Cek Stok Barang Terbanyak");
            System.out.println("4. Cek Stok Barang Terlaris");
            System.out.println("5. Tampil Barang");
            System.out.print("Masukkan angka menu yang ingin dipilih: ");
            int menu = sc.nextInt();

            if (menu == 1) {
                System.out.print("Apakah ingin input barang? (Y/T): ");
                String next = sc.next();
                while (next.equalsIgnoreCase("Y")) {
                    System.out.print("Kode = ");
                    String kode = sc.next();
                    sc.nextLine();
                    System.out.print("Nama = ");
                    String nama = sc.nextLine();
                    System.out.print("Stok = ");
                    int stok = sc.nextInt();
                    System.out.print("Harga = ");
                    int harga = sc.nextInt();
                    Barang09 b = new Barang09(kode, nama, stok, harga);
                    toko.tambahBarang(b);
                    System.out.print("Apakah ingin menambah barang lagi? (Y/T): ");
                    next = sc.next();
                }

            } else if (menu == 2) {
                System.out.println("Data Barang Yang Tersedia");
                toko.tampilData();
                String[] kodeBeli = new String[50];
                int[] jumlahBeli = new int[50];
                int index = 0;
                System.out.print("Apakah ingin beli barang? (Y/T): ");
                String beliLagi = sc.next();
                while (beliLagi.equalsIgnoreCase("Y")) {
                    System.out.print("Masukkan kode barang yang akan dibeli = ");
                    kodeBeli[index] = sc.next();
                    System.out.print("Masukkan jumlah barang yg dibeli = ");
                    jumlahBeli[index] = sc.nextInt();
                    index++;
                    System.out.print("Apakah anda ingin menambahkan Barang yang dibeli? (Y/T): ");
                    beliLagi = sc.next();
                }
                toko.prosesPenjualan(kodeBeli, jumlahBeli, index);

            } else if (menu == 3) {
                toko.urutkanStokTerbanyak();

            } else if (menu == 4) {
                toko.tampilkanTerlaris();

            } else if (menu == 5) {
                toko.tampilData();

            } else {
                System.out.println("Menu tidak valid.");
            }

            System.out.print("\nApakah anda ingin mengulang? Y / T: ");
            String ulang = sc.next();
            if (!ulang.equalsIgnoreCase("Y")) {
                jalan = false;
                System.out.println("===== selesai =====");
            }
        }
    }
}