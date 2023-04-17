import java.util.ArrayList;

public class Order {
    private String idRestaurant;
    private ArrayList<Menu> menus;
    private ArrayList<Integer> jumlahMenu;
    private double jarakAntar;
    private double totalHarga;

    public Order(String idRestaurant, ArrayList<Menu> menus, ArrayList<Integer> jumlahMenu, double jarakAntar, double totalHarga) {
        this.idRestaurant = idRestaurant;
        this.menus = menus;
        this.jumlahMenu = jumlahMenu;
        this.jarakAntar = jarakAntar;
        this.totalHarga = totalHarga;
    }

    public String getIdRestaurant() {
        return idRestaurant;
    }

    public ArrayList<Menu> getMenus() {
        return menus;
    }

    public ArrayList<Integer> getJumlahMenu() {
        return jumlahMenu;
    }

    public double getJarakAntar() {
        return jarakAntar;
    }

    public double getTotalHarga() {
        return totalHarga;
    }

    private double hitungTotalHarga(){
        double total = 0;
        for (int i = 0; i < menus.size(); i++){
            total += menus.get(i).getHargaMenu() * jumlahMenu.get(i) + jarakAntar * 5;
        }
        return total;
    }
}
