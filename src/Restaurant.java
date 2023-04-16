import java.util.ArrayList;

public class Restaurant {
    private String idRestaurant;
    private String namaRestaurant;
    private String alamatRestaurant;
    private ArrayList<Menu> menus;

    public Restaurant(String idRestaurant, String namaRestaurant, String alamatRestaurant, ArrayList<Menu> menus) {
        this.idRestaurant = idRestaurant;
        this.namaRestaurant = namaRestaurant;
        this.alamatRestaurant = alamatRestaurant;
        this.menus = menus;
    }

    public String getIdRestaurant() {
        return idRestaurant;
    }

    public String getNamaRestaurant() {
        return namaRestaurant;
    }

    public String getAlamatRestaurant() {
        return alamatRestaurant;
    }

    public ArrayList<Menu> getMenus() {
        return menus;
    }
}
