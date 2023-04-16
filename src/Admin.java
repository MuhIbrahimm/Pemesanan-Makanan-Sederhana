import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    ArrayList<Restaurant> restaurants = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void menuAdmin() {

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
                System.out.println("====================================");
            }
        } while (pilihan < 1 || pilihan > 4);
        System.out.println("====================================");

        switch (pilihan) {
            case 1:
                viewRestaurant();
                break;
            case 2:
                addRestaurant();
                break;
            case 3:
                deleteRestaurant();
                break;
            case 4:
                Login.login();
                break;
        }
    }

    public void viewRestaurant() {
        System.out.println("          List Restaurant           ");
        System.out.println("====================================");
        if (restaurants.isEmpty()) {
            System.out.println("    List Restaurant Masih Kosong    ");
            System.out.println("Tambahkan Restaurant Terlebih Dahulu");
            System.out.println("====================================");
            System.out.println("Berikan input Untuk Kembali...");
            scanner.next();
            menuAdmin();
        } else{
            for (Restaurant restaurant : restaurants) {
                System.out.println("ID: " + restaurant.getIdRestaurant());
                System.out.println("Nama: " + restaurant.getNamaRestaurant());
                System.out.println("Alamat: " + restaurant.getAlamatRestaurant());
                System.out.println("Menu: ");
                for (Menu menu : restaurant.getMenus()) {
                    System.out.println("- " + menu.getNamaMenu() + " (Rp " + menu.getHargaMenu() + ")");
                }
                System.out.println("====================================");
            }
        }
        System.out.println("Berikan input Untuk Kembali...");
        scanner.next();
        menuAdmin();
    }

    public void addRestaurant() {
        ArrayList<Menu> menus = new ArrayList<>();
        String idRestaurant, namaRestaurant, alamatRestaurant, idMenu, namaMenu, hargaMenu;
        int loopRestaurant = 1, loopMenu = 1;

        while (loopRestaurant == 1) {
            System.out.println("       Menambahkan Restaurant       ");
            System.out.println("====================================");
            System.out.print("Masukkan ID Restaurant: ");
            idRestaurant = scanner.next();
            System.out.print("Masukkan Nama Restaurant: ");
            namaRestaurant = scanner.next();
            System.out.print("Masukkan Alamat Restaurant: ");
            alamatRestaurant = scanner.next();

            System.out.println("\n====================================");
            System.out.println("   Menambahkan Menu ke Restaurant   ");
            System.out.println("====================================");
            while (loopMenu == 1) {
                System.out.print("Masukkan ID Menu: ");
                idMenu = scanner.next();
                System.out.print("Masukkan Nama Menu: ");
                namaMenu = scanner.next();
                System.out.print("Masukkan Harga Menu: ");
                hargaMenu = scanner.next();

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
        menuAdmin();
    }

    public void deleteRestaurant() {
        System.out.print("Masukkan ID Restoran yang akan dihapus: ");
        String id = scanner.next();

        boolean found = false;
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getIdRestaurant().equalsIgnoreCase(id)) {
                restaurants.remove(restaurant);
                System.out.println("Restoran berhasil dihapus!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Restoran tidak ditemukan.");
        }
    }


}