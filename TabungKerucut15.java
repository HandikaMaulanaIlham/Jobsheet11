import java.util.Scanner;

public class TabungKerucut15 {
    static double luasLingkaran(double r) {
        return Math.PI * r * r;
    }

    static double volumeTabung(double r, double t) {
        return luasLingkaran(r) * t;
    }
    static double luasPermukaanTabung(double r, double t) {
        return 2 * luasLingkaran(r) + 2 * Math.PI * r * t;
    }
    static double volumeKerucut(double r, double t) {
        return volumeTabung(r, t) / 3;
    }
    static void tampilMenu() {
        System.out.println("\n===== MENU PERHITUNGAN =====");
        System.out.println("1. Luas Lingkaran");
        System.out.println("2. Volume Tabung");
        System.out.println("3. Luas Permukaan Tabung");
        System.out.println("4. Volume Kerucut");
        System.out.println("0. Keluar");
        System.out.println("============================");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pilihan;
        do {
            tampilMenu();
            System.out.print("Pilih Menu : ");
            pilihan = sc.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan jari-jari (r) : ");
                    double r = sc.nextDouble();
                    System.out.println("Luas Lingkaran : "+ luasLingkaran(r));
                    break;
                case 2:
                    System.out.print("Masukkan jari-jari (r) : ");
                    double a = sc.nextDouble();
                    System.out.print("Masukkan tinggi (r) : ");
                    double t = sc.nextDouble();
                    System.out.println("Volume Tabung : "+ volumeTabung(a,t));
                    break;
                case 3:
                    System.out.print("Masukkan jari-jari (r) : ");
                    double b = sc.nextDouble();
                    System.out.print("Masukkan tinggi (r) : ");
                    double c = sc.nextDouble();
                    System.out.println("Volume Tabung : "+ luasPermukaanTabung(b,c));
                    break;
                case 4:
                    System.out.print("Masukkan jari-jari (r) : ");
                    double d = sc.nextDouble();
                    System.out.print("Masukkan tinggi (r) : ");
                    double e = sc.nextDouble();
                    System.out.println("Volume Tabung : "+ volumeKerucut(d,e));
                    break;
                case 0:
                    System.out.println("Terimakasih, Program selesai");      
                    break;      
                default:
                    System.out.println("Menu tidak tersedia");
            }
        }while(pilihan != 0);
        sc.close();
    
    }
}
