import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    static ArrayList<Restaurant> restaurants = new ArrayList<>();
    static ArrayList<Menu> menus = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void menuAdmin() {

        System.out.println("\n\n====================================");
        System.out.println("          Menu Utama Admin          ");
        System.out.println("====================================");
        System.out.println("   1. Lihat Restaurant              ");
        System.out.println("   2. Tambah Restaurant             ");
        System.out.println("   3. Hapus Restaurant              ");
        System.out.println("   4. Kembali ke Login              ");
        System.out.println("====================================");
        int pilihan;
        do {
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            if (pilihan < 1 || pilihan > 4){
                System.out.println("Pilihan tersebut tidak ada di menu");
                System.out.println("Silakan pilih menu kembali");
                //output apabila input yang diberikan tidak sesuai
                System.out.println("====================================");
            }
        } while (pilihan < 1 || pilihan > 4);
        //perulangan apabila input yang diberikan tidak sesuai
        System.out.println("====================================");

        switch (pilihan) {
            case 1:
                viewRestaurant(restaurants, menus);
                //untuk melihat list restaurant
                menuAdmin();
                break;
            case 2:
                addRestaurant(restaurants, menus);
                //untuk menambahkan restaurant beserta menu di dalamnya
                menuAdmin();
                break;
            case 3:
                deleteRestaurant(restaurants, menus);
                //untuk menghapus restaurant beserta menu di dalamnya
                menuAdmin();
                break;
            case 4:
                Login.login();
                //kembali ke menu login
                break;
        }
    }

    private static void viewRestaurant(ArrayList<Restaurant> restaurants, ArrayList<Menu> menus) {
        //method untuk melihat restaurant yang ada
        System.out.println("          List Restaurant           ");
        System.out.println("====================================");
        if (restaurants.isEmpty()) {
            System.out.println("    List Restaurant Masih Kosong    ");
            System.out.println("Tambahkan Restaurant Terlebih Dahulu");
            System.out.println("====================================");
            System.out.println("Berikan input Untuk Kembali...");
            scanner.next();
            menuAdmin();
            return; //menambahkan perintah return
        } else{
            for (Restaurant restaurant : restaurants) {
                //perulangan menampilkan restaurant
                System.out.println("ID: " + restaurant.getIdRestaurant());
                System.out.println("Nama: " + restaurant.getNamaRestaurant());
                System.out.println("Alamat: " + restaurant.getAlamatRestaurant());
                System.out.println("Menu: ");
                for (Menu menu : restaurant.getMenus()) {
                    //perulangan menampilkan menu dalam restaurant
                    System.out.println("- " + menu.getNamaMenu() + " (Rp " + menu.getHargaMenu() + ")");
                }
                System.out.println("====================================");
            }
        }
        System.out.println("Berikan input Untuk Kembali...");
        scanner.next();
        //pause
    }


    private static void addRestaurant(ArrayList<Restaurant> restaurants, ArrayList<Menu> menus) {
        //method untuk menambahkan restaurant
        String idRestaurant, namaRestaurant, alamatRestaurant, idMenu, namaMenu;
        int hargaMenu;
        int loopRestaurant = 1;

        while (loopRestaurant == 1) {
            //perulangan untuk mengisi restaurant
            System.out.println("       Menambahkan Restaurant       ");
            System.out.println("====================================");
            menus = new ArrayList<>();
            System.out.print("Masukkan ID Restaurant: ");
            idRestaurant = scanner.next();
            System.out.print("Masukkan Nama Restaurant: ");
            namaRestaurant = scanner.next();
            System.out.print("Masukkan Alamat Restaurant: ");
            alamatRestaurant = scanner.next();

            System.out.println("\n====================================");
            System.out.println("   Menambahkan Menu ke Restaurant   ");
            System.out.println("====================================");

            int loopMenu = 1;
            while (loopMenu == 1) {
                //perulangan untuk mengisi menu
                System.out.print("Masukkan ID Menu: ");
                idMenu = scanner.next();
                System.out.print("Masukkan Nama Menu: ");
                namaMenu = scanner.next();
                System.out.print("Masukkan Harga Menu: ");
                hargaMenu = scanner.nextInt();

                menus.add(new Menu(idMenu, namaMenu, hargaMenu));

                System.out.println("====================================");
                System.out.println("Tambah data menu kembali?");
                System.out.println("(1: Ya, 0: Tidak)");
                loopMenu = scanner.nextInt();
                System.out.println("====================================");
            }
            restaurants.add(new Restaurant(idRestaurant, namaRestaurant, alamatRestaurant, menus));

            System.out.println("Tambah data restaurant kembali?");
            System.out.println("(1: Ya, 0: Tidak)");
            loopRestaurant = scanner.nextInt();
            System.out.println("====================================");

            if (loopRestaurant == 1) {
                menus = new ArrayList<>();
                loopMenu = 1;
            }
        }
    }

    private static void deleteRestaurant(ArrayList<Restaurant> restaurants, ArrayList<Menu> menus) {
        //method untuk menghapus restaurant
        int loopDelete = 1;

        while (loopDelete == 1) {
            System.out.print("Masukkan ID restaurant yang akan dihapus: ");
            String id = scanner.next();
            boolean deleted = false;
            for (Restaurant restaurant : restaurants) {
                if (restaurant.getIdRestaurant().equalsIgnoreCase(id)) {
                    restaurants.remove(restaurant);
                    System.out.println("====================================");
                    System.out.println("restaurant berhasil dihapus!");
                    deleted = true;
                    break;
                }
            }
            if (!deleted) {
                System.out.println("restaurant tidak ditemukan.");
            }
            System.out.println("====================================");
            System.out.println("Hapus restaurant kembali?");
            System.out.println("(1: Ya, 0: Tidak)");
            loopDelete = scanner.nextInt();
            System.out.println("====================================");
        }
    }
}