import java.util.Scanner;

public class BankSampah15 {
    static Scanner input = new Scanner(System.in);
    
    static double[] inputSetoran(int n) {
        double[] setoran = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Masukkan berat setoran nasabah ke-" + (i + 1) + " (kg): ");
            setoran[i] = input.nextDouble();
        }

        return setoran;
    }

    static void tampilSetoran(double[] setoran) {
        System.out.println("\n=== DATA SETORAN NASABAH ===");

        for (int i = 0; i < setoran.length; i++) {
            System.out.println("Nasabah ke-" + (i + 1) + " : " + setoran[i] + " kg");
        }
    }

    static double totalSetoran(double[] setoran) {
        double total = 0;

        for (int i = 0; i < setoran.length; i++) {
            total = total + setoran[i];
        }

        return total;
    }

    static double hitungSaldo(double berat, double harga) {
        return berat * harga;
    }

    static int nasabahTerbanyak(double[] setoran) {
        int indeks = 0;

        for (int i = 1; i < setoran.length; i++) {
            if (setoran[i] > setoran[indeks]) {
                indeks = i;
            }
        }

        return indeks;
    }

    public static void main(String[] args) {
        System.out.print("Masukkan jumlah nasabah: ");
        int n = input.nextInt();
        double[] setoran = inputSetoran(n);
        tampilSetoran(setoran);
        double harga = 3000;

        System.out.println("\n=== SALDO NASABAH ===");

        for (int i = 0; i < setoran.length; i++) {
            double saldo = hitungSaldo(setoran[i], harga);

            System.out.println("Nasabah ke-" + (i + 1) +
                    " : Rp" + saldo);
        }

        double total = totalSetoran(setoran);
        System.out.println("\nTotal seluruh setoran: " + total + " kg");
        int terbesar = nasabahTerbanyak(setoran);
        System.out.println("Setoran terbesar dimiliki nasabah ke-" + (terbesar + 1));
        System.out.println("Berat setoran terbesar: " +setoran[terbesar] + " kg");
    }
}
