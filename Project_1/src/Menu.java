import java.util.Scanner;

public class Menu {
    public static void ShowMenu() {
        Scanner input = new Scanner(System.in);
        
        int choice;
        do {
            System.out.println("------------------------");
            System.out.println("   WELCOME TO ...");
            System.out.println("------------------------");
            System.out.println("1.] Read Data");
            System.out.println("2.] Insert data");
            System.out.println("3.] Edit Data");
            System.out.println("4.] Delete data");
            System.out.println("5.] Exit");
            System.out.println("------------------------");
            System.out.print("Pilih: ");
            
            choice = input.nextInt();
            input.nextLine(); // Consume the newline character
            
            switch (choice) {
                case 1:
                    // Read Data
                    MyConfig.getDatabase();
                    break;
                case 2:
                    // Insert Data
                    System.out.print("NAMA : ");
                    String newNama = input.nextLine();

                    System.out.print("HARGA : ");
                    long newharga = input.nextLong();

                    System.out.print("STOK : ");
                    int newstok = input.nextInt();
                    MyConfig.addData(newNama, newharga, newstok);
                    break;
                case 3:
                    // Edit Data
                    System.out.print("ID: ");
                    int id = input.nextInt();
                    input.nextLine();
                    System.out.print("NAMA: ");
                    String nama = input.nextLine();
                    System.out.print("HARGA: ");
                    int harga = input.nextInt();
                    System.out.print("STOK: ");
                    int stok = input.nextInt();
                    MyConfig.editData(id, nama, harga, stok);
                    break;
                case 4:
                    // Delete Data
                    System.out.print("ID: ");
                    int deleteId = input.nextInt();
                    MyConfig.deleteData(deleteId);
                    break;
                case 5:
                    System.out.println("Exit App...");
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia");
                    break;
            }
            
        } while (choice != 5);
        
        input.close();
    }
}
    

