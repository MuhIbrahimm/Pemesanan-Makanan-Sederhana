import java.util.Scanner;

public class Customer {
    public static void customer() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\n====================================");
        System.out.println("        Menu Utama Customer         ");
        System.out.println("====================================");
        System.out.println("   1. Buat Pesanan                  ");
        System.out.println("   2. Lihat Restaurat               ");
        System.out.println("   3. Kembali ke Login              ");
        System.out.println("====================================");
        int pilihan;
        do {
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            if (pilihan < 1 || pilihan > 3){
                System.out.println("Pilihan tersebut tidak ada di menu");
                System.out.println("Silakan pilih menu kembali");
                System.out.println("====================================");
            }
        } while (pilihan < 1 || pilihan > 3);
        System.out.println("====================================");

        switch (pilihan){
            case 1:
                //buat pesanan
                break;
            case 2:
                //lihat restaurant
                break;
            case 3:
                Login.login();
                //kembali ke login
        }
    }
}

