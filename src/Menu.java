public class Menu {
    private String idMenu;
    private String namaMenu;
    private int hargaMenu;

    public Menu(String idMenu, String namaMenu, int hargaMenu) {
        this.idMenu = idMenu;
        this.namaMenu = namaMenu;
        this.hargaMenu = hargaMenu;
    }

    public Menu(String idMenu, String namaMenu, Integer hargaMenu) {
    }

    public String getNamaMenu() {
        return namaMenu;
    }

    public int getHargaMenu() {
        return hargaMenu;
    }
}
