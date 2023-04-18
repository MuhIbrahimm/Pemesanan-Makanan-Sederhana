import java.util.ArrayList;
import java.util.Scanner;

public class Customer {
    private static ArrayList<Order> orders = new ArrayList<>();
    private static ArrayList<Restaurant> restaurants = Admin.restaurants;
    private static Scanner scanner = new Scanner(System.in);

    public static void menuCustomer() {
        System.out.println("\n\n====================================");
        System.out.println("        Menu Utama Customer         ");
        System.out.println("====================================");
        System.out.println("   1. Buat Pesanan                  ");
        System.out.println("   2. Lihat Pesanan                 ");
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
                addOrder();
                menuCustomer();
                break;
            case 2:
                viewOrder();
                menuCustomer();
                break;
            case 3:
                Login.login();
        }
    }

    private static void addOrder() {
        viewRestaurant(restaurants);

        System.out.print("Pilih restaurant berdasarkan ID: ");
        String idRestaurant = scanner.next();

        // Cari restaurant berdasarkan id
        Restaurant restaurantPilihan = null;
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getIdRestaurant().equals(idRestaurant)) {
                restaurantPilihan = restaurant;
                break;
            }
        }

        if (restaurantPilihan == null) {
            System.out.println("ID restaurant tidak ditemukan.");
            return;
        }

        int counter = 1;
        for (Menu menu : restaurantPilihan.getMenus()) {
            //perulangan menampilkan menu dalam restaurant
            System.out.println(counter + ". " + menu.getNamaMenu() + " (Rp " + menu.getHargaMenu() + ")");
            counter++;
        }

        System.out.println("====================================");

        // Meminta input user untuk memesan makanan
        ArrayList<Menu> menuOrder = new ArrayList<>();
        ArrayList<Integer> quantityList = new ArrayList<>();
        int loopOrder = 1;
        while (loopOrder == 1) {
            System.out.print("Pilih makanan dengan urutan: ");
            int idMenu = scanner.nextInt();
            // Cek apakah idMenu valid
            if (idMenu <= 0 || idMenu > restaurantPilihan.getMenus().size()) {
                System.out.println("ID makanan tidak valid.");
                continue;
            }

            System.out.print("Jumlah: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Jumlah harus berupa angka.");
                scanner.next();
                continue;
            }
            int jumlah = scanner.nextInt();

            // Cari menu makanan berdasarkan id
            ArrayList<Menu> menus = restaurantPilihan.getMenus();
            Menu menuPilihan = menus.get(idMenu - 1);
            // mengambil menu pada indeks idMenu - 1 dari ArrayList menus
            if (menuPilihan == null) {
                System.out.println("Makanan dengan ID tersebut tidak tersedia.");
            } else {
                menuOrder.add(menuPilihan);
                quantityList.add(jumlah);
            }

            System.out.print("Pesan lagi (y/n)? ");
            loopOrder = scanner.next().equalsIgnoreCase("y") ? 1 : 0;
        }

        // Meminta input user untuk jarak antar
        System.out.print("Jarak antar (km): ");
        double jarakAntar = scanner.nextDouble();

        // Menambahkan order ke list order
        Order order = new Order(restaurantPilihan.getIdRestaurant(), menuOrder, quantityList, jarakAntar);
        orders.add(order);

        double totalBiaya = order.hitungTotalHarga();
        System.out.println("Total Biaya: Rp " + totalBiaya);

        System.out.println("Pesanan berhasil ditambahkan.");
        System.out.println("Berikan input Untuk Kembali...");
        scanner.next();
    }


    private static void viewOrder() {
        System.out.println("\n\n====================================");
        System.out.println("           Daftar Pesanan           ");
        System.out.println("====================================");
        if (orders.size() == 0) {
            System.out.println("Belum ada pesanan yang dibuat");
        } else {
            System.out.println("Daftar Pesanan:");
            for (int i = 0; i < orders.size(); i++) {
                System.out.println("Pesanan " + (i + 1));
                if (orders.get(i).getIdRestaurant() != null) {
                    System.out.println("restaurant: " + orders.get(i).getIdRestaurant());
                } else {
                    System.out.println("restaurant: (Restoran belum dipilih)");
                }
                System.out.println("Menu:");
                ArrayList<Menu> menuOrder = orders.get(i).getMenus();
                ArrayList<Integer> quantityList = orders.get(i).getJumlahMenu();
                for (int j = 0; j < menuOrder.size(); j++) {
                    System.out.println((j + 1) + ". ID: " + menuOrder.get(j).getIdMenu() + ", Nama Menu: " + menuOrder.get(j).getNamaMenu() + ", Harga: " + menuOrder.get(j).getHargaMenu());
                }
                System.out.println("Jarak Antar: " + orders.get(i).getJarakAntar() + " km");
                System.out.println("Total Harga: " + orders.get(i).hitungTotalHarga());
                System.out.println("====================================");
            }
        }
    }


    private static void viewRestaurant(ArrayList<Restaurant> restaurants) {
        System.out.println("          List Restaurant           ");
        System.out.println("====================================");
        if (restaurants.isEmpty()) {
            System.out.println("    List Restaurant Masih Kosong    ");
            System.out.println("====================================");
            System.out.println("Berikan input Untuk Kembali...");
            scanner.next();
            menuCustomer();
        } else {
            for (Restaurant restaurant : restaurants) {
                System.out.println("====================================");
                System.out.println("ID Restaurant     : " + restaurant.getIdRestaurant());
                System.out.println("Nama Restaurant   : " + restaurant.getNamaRestaurant());
                System.out.println("Alamat Restaurant : " + restaurant.getAlamatRestaurant());
                System.out.println("====================================");
            }
        }
    }

}
