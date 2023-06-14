public class App {
    public static void main(String[] args) {
        // memanggil method dari kelas MyConfig dan Menu
        MyConfig.getConnection();
        MyConfig.createTable();
        Menu.ShowMenu();
    }
}