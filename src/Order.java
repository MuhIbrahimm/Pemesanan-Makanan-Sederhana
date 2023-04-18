import java.util.ArrayList;

public class Order {
    private String idRestaurant;
    private ArrayList<Menu> menus;
    private ArrayList<Integer> jumlahMenu;
    private double jarakAntar;
    private double totalHarga;

    public Order(String idRestaurant, ArrayList<Menu> menuOrder, ArrayList<Integer> quantityList, double jarakAntar) {
        this.idRestaurant = idRestaurant;
        this.menus = menuOrder;
        this.jumlahMenu = quantityList;
        this.jarakAntar = jarakAntar;
        this.totalHarga = hitungTotalHarga();
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

    public double hitungTotalHarga(){
        //menghitung total order
        double total = 0;
        for (int i = 0; i < menus.size(); i++){
            total += menus.get(i).getHargaMenu() * jumlahMenu.get(i) + jarakAntar * 5000;
        }
        return total;
    }
}
