import java.util.ArrayList;
import java.util.Scanner;

public class Customer {
    ArrayList<Order> orders = new ArrayList<>();
    ArrayList<Restaurant>restaurants = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void menuCustomer() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\n====================================");
        System.out.println("        Menu Utama Customer         ");
        System.out.println("====================================");
        System.out.println("   1. Buat Pesanan                  ");
        System.out.println("   2. Lihat Pesaan                  ");
        System.out.println("   3. Kembali ke Login              ");
        System.out.println("====================================");
        int pilihan;
        do {
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            if (pilihan < 1 || pilihan > 3) {
                System.out.println("Pilihan tersebut tidak ada di menu");
                System.out.println("Silakan pilih menu kembali");
                System.out.println("====================================");
            }
        } while (pilihan < 1 || pilihan > 3);
        System.out.println("====================================");

        switch (pilihan) {
            case 1:
                addPesanan();
                break;
            case 2:
                //lihat pesanan
                break;
            case 3:
                Login.login();
        }
    }

    public void addPesanan() {
        viewRestaurant(restaurants);
    }

    public void viewRestaurant(ArrayList<Restaurant> restaurants) {
        System.out.println("          List Restaurant           ");
        System.out.println("====================================");
        if (restaurants.isEmpty()) {
            System.out.println("    List Restaurant Masih Kosong    ");
            System.out.println("====================================");
            System.out.println("Berikan input Untuk Kembali...");
            scanner.next();
            menuCustomer();
        } else{
            for (Restaurant restaurant : restaurants) {
                System.out.println("ID: " + restaurant.getIdRestaurant());
                System.out.println("Nama: " + restaurant.getNamaRestaurant());
                System.out.println("Alamat: " + restaurant.getAlamatRestaurant() + "\n");
            }
        }
        System.out.print("Pilih restaurant berdasarkan ID: ");
        scanner.next();
    }
}

