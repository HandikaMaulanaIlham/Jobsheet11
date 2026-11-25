import java.util.Scanner;

public class RekapLaundry15 {
    static Scanner input = new Scanner(System.in);

    static String[] namaLayanan = {
        "Cuci Kering",
        "Cuci Setrika",
        "Setrika Saja",
        "Express"
    };

    static int[] harga = {
        6000, 8000, 5000, 12000
    };

    static String[] namaHari = {
        "Senin", "Selasa", "Rabu",
        "Kamis", "Jumat", "Sabtu"
    };

    static int[][] inputData() {
        int[][] data = new int[4][6];
        for (int i = 0; i < 4; i++) {
            System.out.println("\nLayanan: " + namaLayanan[i]);
            for (int j = 0; j < 6; j++) {
                System.out.print("Masukkan berat hari " + namaHari[j] + ": ");
                data[i][j] = input.nextInt();
            }
        }
        return data;
    }

    static void tampilData(int[][] data) {
        System.out.println("\n========== REKAP LAUNDRY ==========");
        System.out.printf("%-18s", "Layanan");
        for (int j = 0; j < 6; j++) {
            System.out.printf("%-10s", namaHari[j]);
        }
        System.out.println();

        for (int i = 0; i < 4; i++) {
            System.out.printf("%-18s", namaLayanan[i]);
            for (int j = 0; j < 6; j++) {
                System.out.printf("%-10d", data[i][j]);
            }
            System.out.println();
        }
    }

    static int totalPerLayanan(int[][] data, int idxLayanan) {
        int total = 0;
        for (int j = 0; j < 6; j++) {
            total = total + data[idxLayanan][j];
        }
        return total;
    }

    static void layananTerbanyak(int[][] data) {
        int indeks = 0;
        for (int i = 1; i < 4; i++) {
            if (totalPerLayanan(data, i) >
                    totalPerLayanan(data, indeks)) {
                indeks = i;
            }
        }
        System.out.println("\n=== LAYANAN TERBANYAK ===");
        System.out.println("Nama layanan: " + namaLayanan[indeks]);
        System.out.println("Total berat: " + totalPerLayanan(data, indeks) + " kg");
    }

    static int hariTersibuk(int[][] data) {
        int indeks = 0;
        for (int j = 1; j < 6; j++) {
            int totalHari = 0;
            int totalTerbesar = 0;
            for (int i = 0; i < 4; i++) {
                totalHari = totalHari + data[i][j];
                totalTerbesar = totalTerbesar + data[i][indeks];
            }
            if (totalHari > totalTerbesar) {
                indeks = j;
            }
        }
        return indeks;
    }

    static void hitungPendapatan(int[][] data) {
        double totalPendapatan = 0;
        System.out.println("\n=== PENDAPATAN LAUNDRY ===");
        for (int i = 0; i < 4; i++) {

            int totalBerat = totalPerLayanan(data, i);

            double pendapatan = totalBerat * harga[i];

            totalPendapatan = totalPendapatan + pendapatan;

            System.out.println(namaLayanan[i] +
                    " : Rp" + pendapatan);
        }
        System.out.println("--------------------------------");
        System.out.println("Total pendapatan: Rp" + totalPendapatan);
    }
    public static void main(String[] args) {
        int[][] data = inputData();
        tampilData(data);
        System.out.println("\n=== TOTAL PER LAYANAN ===");
        for (int i = 0; i < 4; i++) {

            System.out.println(namaLayanan[i] + " : " +
                    totalPerLayanan(data, i) + " kg");
        }
        layananTerbanyak(data);
        int indeksHari = hariTersibuk(data);
        System.out.println("\n=== HARI TERSIBUK ===");
        System.out.println("Hari: " + namaHari[indeksHari]);
        hitungPendapatan(data);
    }
}
