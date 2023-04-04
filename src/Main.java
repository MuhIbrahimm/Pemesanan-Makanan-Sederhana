import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n\n========= Selamat Datang =========");
        System.out.println("=== Aplikasi Pemesanan Makanan ===");
        login();
    }

    public static void login() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nUsername    : ");
        String username = scanner.nextLine();
        System.out.print("Password    : ");
        String password = scanner.nextLine();

        if (username.equals("admin") && password.equals("admin")) {
            //perintah masuk ke sisi admin
            System.out.println("anda admin");
        } else if (username.equals("customer") && password.equals("customer")) {
            System.out.println("anda customer");
            //perintah masuk ke sisi admin
        } else {
            System.out.println("\nUsername dan Password tidak sesuai");
            System.out.println("Tolong masukkan Username dan Password kembali");
            login();
            //perulangan login apabila username dan password tidak sesuai
        }
    }
}