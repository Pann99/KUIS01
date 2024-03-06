import java.util.ArrayList;

class Barang {
    String kode;
    String nama;
    double harga;
    int stok;

    public Barang(String kode, String nama, double harga, int stok) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }
}

class TransaksiBarang {
    ArrayList<Barang> barangs = new ArrayList<>();
    double totalHarga = 0;

    public void tambahBarang(Barang barang) {
        barangs.add(barang);
    }

    public void tampilkanBarang() {
        System.out.println("\n============================");
        System.out.println("Daftar Barang:");
        System.out.println("============================");
        for (Barang barang : barangs) {
            System.out.println("Kode     Nama        Harga");
            System.out.println(barang.kode + "      " + barang.nama +  "  Rp." + barang.harga);
        }
    }

    public void tampilkanBarangPembelian(ArrayList<String> kodeBarangPembelian) {
        System.out.println("\n============================");
        System.out.println("Daftar Pembelian:");
        System.out.println("============================");
        for (String kode : kodeBarangPembelian) {
            for (Barang barang : barangs) {
                if (barang.kode.equals(kode)) {
                    System.out.println("Kode     Nama      Harga");
                    System.out.println(barang.kode + "      " + barang.nama +  "  Rp." + barang.harga);
                    totalHarga += barang.harga;
                    break;
                }
            }
        }
        System.out.println("Total Harga: Rp." + totalHarga);
    }

    public void melakukanPembelian(ArrayList<String> kodeBarangPembelian) {
        for (String kode : kodeBarangPembelian) {
            for (Barang barang : barangs) {
                if (barang.kode.equals(kode)) {
                    barang.stok--;
                    break;
                }
            }
        }
    }
}

