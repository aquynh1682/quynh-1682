package GiaoDien;

public class ViewMenu {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Modulo modulo = new Modulo();
        ModuloController moduloController = new ModuloController(modulo);
    }
}
