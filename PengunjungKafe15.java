public class PengunjungKafe15 {
    static void daftarPengunjung(String... namaPengunjung) {
        System.out.println("Daftar Nama Pengunjung:");
        for (String nama : namaPengunjung) {
            System.out.println("- " + nama);
        }
    }

    public static void main(String[] args) {
        String[] tamu = {"Ali", "Budi", "Cinta"};
        daftarPengunjung(tamu);
        //daftarPengunjung("Andi");
        //daftarPengunjung("Doni", "Eti", "Fahmi", "Galih");
    }
}
