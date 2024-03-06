import java.util.ArrayList;
import java.util.Scanner;

public class MainBarang {
    public static void main(String[] args) {
        // Inisialisasi data barang
        Barang barang1 = new Barang("K01", "Buku", 7000, 20);
        Barang barang2 = new Barang("K02", "Pensil", 2000, 30);
        Barang barang3 = new Barang("K03", "Penghapus", 1000, 25);
        Barang barang4 = new Barang("K04", "Penggaris", 8000, 15);
        Barang barang5 = new Barang("K05", "Pensil Warna", 4000, 10);

        // Inisialisasi transaksi barang
        TransaksiBarang transaksi = new TransaksiBarang();
        transaksi.tambahBarang(barang1);
        transaksi.tambahBarang(barang2);
        transaksi.tambahBarang(barang3);
        transaksi.tambahBarang(barang4);
        transaksi.tambahBarang(barang5);

        Scanner scanner = new Scanner(System.in);

        // Menu utama
        int pilihan = 0;
        ArrayList<String> kodeBarangPembelian = new ArrayList<>(); // Deklarasi di luar loop
        while (pilihan != 4) {
            System.out.println("\n============================");
            System.out.println("Menu:");
            System.out.println("============================");
            System.out.println("1. Tampilkan Barang");
            System.out.println("2. Melakukan Pembelian");
            System.out.println("3. Tampilkan Pembelian");
            System.out.println("4. Keluar");
            System.out.println("============================");
            System.out.print("Pilihan Anda: ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    transaksi.tampilkanBarang();
                    break;
                case 2:
                    System.out.println("============================");
                    System.out.print("Masukkan jumlah barang yang ingin dibeli: ");
                    int jumlahBarang = scanner.nextInt();
                    for (int i = 0; i < jumlahBarang; i++) {
                        System.out.print("Masukkan kode barang ke-" + (i + 1) + ": ");
                        String kode = scanner.next();
                        kodeBarangPembelian.add(kode);
                    }
                    transaksi.melakukanPembelian(kodeBarangPembelian);
                    System.out.println("Pembelian berhasil dilakukan!");
                    break;
                case 3:
                    transaksi.tampilkanBarangPembelian(kodeBarangPembelian);
                    break;
                case 4:
                    System.out.println("Terima kasih telah menggunakan program ini.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        }

        scanner.close();
    }
}
