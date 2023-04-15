import java.util.Scanner;

public class Admin {
    public static void admin() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\n====================================");
        System.out.println("          Menu Utama Admin          ");
        System.out.println("====================================");
        System.out.println("   1. Lihat Restaurant              ");
        System.out.println("   2. Tambah Restaurat              ");
        System.out.println("   3. Hapus Restaurant              ");
        System.out.println("   4. Kembali ke Login              ");
        System.out.println("====================================");
        int pilihan;
        do {
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            if (pilihan < 1 || pilihan > 4){
                System.out.println("Pilihan tersebut tidak ada di menu");
                System.out.println("Silakkan pilih menu kembali");
                System.out.println("====================================");
            }
        } while (pilihan < 1 || pilihan > 4);
        System.out.println("====================================");

        switch (pilihan) {
            case 1:
                //lihat restaurant
                break;
            case 2:
                //tambah restaurant
                break;
            case 3:
                //hapus restaurant
                break;
            case 4:
                Login.login();
                break;
        }

    }
}