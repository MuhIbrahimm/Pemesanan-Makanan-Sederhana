import java.util.Scanner;

public class Login {
    public static void login() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("             Menu Login             ");
        System.out.println("====================================");
        System.out.print("Username : ");
        String username = scanner.nextLine();
        //Memasukkan Username
        System.out.print("Password : ");
        String password = scanner.nextLine();
        //Memasukkan Password
        System.out.println("====================================");

        if (username.equals("admin") && password.equals("admin")) {
            Admin admin = new Admin();
            admin.menuAdmin();
            //perintah masuk ke menu admin

        } else if (username.equals("customer") && password.equals("customer")) {
            Customer customer = new Customer();
            customer.menuCustomer();
            //perintah masuk ke menu customer

        } else {
            System.out.println(" Username dan Password tidak sesuai ");
            System.out.println("Isi ulang Username dan Password Anda");
            System.out.println("====================================");
            login();
            //perulangan login apabila username dan password tidak sesuai
        }
    }
}
