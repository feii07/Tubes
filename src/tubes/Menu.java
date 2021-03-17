package tubes;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Menu {
    
    static void menu() {
        Scanner input = new Scanner(System.in);

        System.out.println("Menu: ");
        System.out.println("1. Daftar");
        System.out.println("2. Pinjam buku");
        System.out.println("3. Baca Buku");
        System.out.println("4. Tambah Buku");
        System.out.println("5. Hapus buku");
        System.out.println("6. List Buku");
        System.out.println("7. Uas ");
        System.out.println("8. Exit");

        System.out.print("Masukkan pilihan menu: ");
        int pilihan = input.nextInt();

        switch (pilihan) {
            case 1:
                Daftar.listorang();
                Menu.menu();
                break;
            case 2:
                List.print();
                Pinjam.pinjam();
                break;
            case 3:
                List.print();
                Baca.baca();
                break;
            case 4:
                int pass = Integer.parseInt(JOptionPane.showInputDialog("Masukkan Password !! "));
                if (pass != 123456) {
                    System.out.println("Anda Tidak Boleh Mengakses! ");
                    Menu.menu();
                } else {
                    List.list();
                    List.print();
                    Menu.menu();
                    break;
                }
            case 5:
                pass = Integer.parseInt(JOptionPane.showInputDialog("Masukkan Password !! "));
                if (pass != 123456) {
                    System.out.println("Anda Tidak Boleh Mengakses! ");
                    Menu.menu();
                } else {
                    List.Hapus();
                    List.print();
                    Menu.menu();
                    break;
                }
                break;
            case 6:
                List.print();
                Menu.menu();
                break;
            case 7:
                List.uas();
                
                break;
            case 8:
                
                break;
            default:
                System.out.println("Salah input!");
                Menu.menu();
                break;
        }
    }
}
