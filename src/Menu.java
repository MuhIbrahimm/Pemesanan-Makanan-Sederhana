public class Menu {
    private String idMenu;
    private String namaMenu;
    private double hargaMenu;

    public Menu(String idMenu, String namaMenu, int hargaMenu) {
        this.idMenu = idMenu;
        this.namaMenu = namaMenu;
        this.hargaMenu = hargaMenu;
    }

    public String getIdMenu() {
        return idMenu;
    }
    public String getNamaMenu() {
        return namaMenu;
    }

    public double getHargaMenu() {
        return hargaMenu;
    }
}