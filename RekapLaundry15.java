import java.util.Scanner;

public class RekapLaundry15 {
    static Scanner input = new Scanner(System.in);

    static int[][] inputData(String[] namaLayanan, int jumlahLayanan,int jumlahHari) {
        int[][] data = new int[jumlahLayanan][jumlahHari];
        for (int i = 0; i < jumlahLayanan; i++) {
            System.out.println("\nLayanan: " + namaLayanan[i]);
            for (int j = 0; j < jumlahHari; j++) {
                System.out.print("Masukkan berat cucian Hari ke-" +(j + 1) + ": ");
                data[i][j] = input.nextInt();
            }
        }
        return data;
    }

    static void tampilData(int[][] data, String[] namaLayanan, int jumlahLayanan, int jumlahHari) {
        System.out.println("\n========== REKAP LAUNDRY ==========");
        System.out.printf("%-18s", "Layanan");
        for (int j = 0; j < jumlahHari; j++) {
            System.out.printf("%-12s", "Hari ke-" + (j + 1));
        }
        System.out.println();
        for (int i = 0; i < jumlahLayanan; i++) {
            System.out.printf("%-18s", namaLayanan[i]);
            for (int j = 0; j < jumlahHari; j++) {
                System.out.printf("%-12d", data[i][j]);
            }
            System.out.println();
        }
    }

    static int totalPerLayanan(int[][] data, int idxLayanan,int jumlahHari) {
        int total = 0;
        for (int j = 0; j < jumlahHari; j++) {
            total = total + data[idxLayanan][j];
        }
        return total;
    }

    static void layananTerbanyak(int[][] data, String[] namaLayanan,int jumlahLayanan, int jumlahHari) {
        int indeks = 0;
        for (int i = 1; i < jumlahLayanan; i++) {
            if (totalPerLayanan(data, i, jumlahHari) >
                    totalPerLayanan(data, indeks, jumlahHari)) {
                indeks = i;
            }
        }
        System.out.println("\n=== LAYANAN TERBANYAK ===");
        System.out.println("Nama layanan: " + namaLayanan[indeks]);
        System.out.println("Total berat: " + totalPerLayanan(data, indeks, jumlahHari) + " kg");
    }

    static int hariTersibuk(int[][] data, int jumlahLayanan, int jumlahHari) {
        int indeks = 0;
        for (int j = 1; j < jumlahHari; j++) {
            int totalHari = 0;
            int totalTerbesar = 0;
            for (int i = 0; i < jumlahLayanan; i++) {
                totalHari = totalHari + data[i][j];
                totalTerbesar = totalTerbesar + data[i][indeks];
            }
            if (totalHari > totalTerbesar) {
                indeks = j;
            }
        }
        return indeks;
    }

    static void hitungPendapatan(int[][] data, String[] namaLayanan,int[] harga, int jumlahLayanan,int jumlahHari) {
        double totalPendapatan = 0;
        System.out.println("\n=== PENDAPATAN LAUNDRY ===");
        for (int i = 0; i < jumlahLayanan; i++) {
            int totalBerat = totalPerLayanan(data, i, jumlahHari);
            double pendapatan = totalBerat * harga[i];
            totalPendapatan = totalPendapatan + pendapatan;
            System.out.println(namaLayanan[i] +" : Rp" + pendapatan);
        }
        System.out.println("--------------------------------");
        System.out.println("Total pendapatan: Rp" + totalPendapatan);
    }
    public static void main(String[] args) {
        System.out.print("Masukkan jumlah layanan: ");
        int jumlahLayanan = input.nextInt();
        System.out.print("Masukkan jumlah hari: ");
        int jumlahHari = input.nextInt();
        String[] namaLayanan = new String[jumlahLayanan];
        int[] harga = new int[jumlahLayanan];

        for (int i = 0; i < jumlahLayanan; i++) {
            System.out.println("\nData layanan ke-" + (i + 1));
            System.out.print("Nama layanan: ");
            namaLayanan[i] = input.next();
            System.out.print("Harga per kg: Rp");
            harga[i] = input.nextInt();
        }
        
        int[][] data = inputData(namaLayanan,jumlahLayanan, jumlahHari);
        tampilData(data, namaLayanan, jumlahLayanan, jumlahHari);
        System.out.println("\n=== TOTAL PER LAYANAN ===");
        for (int i = 0; i < jumlahLayanan; i++) {
            System.out.println(namaLayanan[i] + " : " + totalPerLayanan(data, i, jumlahHari) + " kg");
        }
        layananTerbanyak(data, namaLayanan,jumlahLayanan, jumlahHari);
        int indeksHari = hariTersibuk(data,jumlahLayanan, jumlahHari);
        System.out.println("\n=== HARI TERSIBUK ===");
        System.out.println("Hari ke-" + (indeksHari + 1));
        hitungPendapatan(data, namaLayanan, harga, jumlahLayanan, jumlahHari);
    }
}
