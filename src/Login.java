import java.util.Scanner;

public class Login {
    public static void login() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nUsername    : ");
        String username = scanner.nextLine();
        System.out.print("Password    : ");
        String password = scanner.nextLine();
        System.out.println("\n\n");

        if (username.equals("admin") && password.equals("admin")) {
            Admin Adm = new Admin();
            Adm.Admin();
            //perintah masuk ke sisi admin

        } else if (username.equals("customer") && password.equals("customer")) {
            Customer Customer = new Customer();
            Customer.Customer();
            //perintah masuk ke sisi customer

        } else {
            System.out.println("Username dan Password tidak sesuai");
            System.out.println("Tolong masukkan Username dan Password kembali");
            login();
            //perulangan login apabila username dan password tidak sesuai
        }
    }
}
