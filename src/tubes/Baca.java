package tubes;

import javax.swing.JOptionPane;
import java.util.Scanner;

public class Baca {

    static class Kursi {

        String nama;
        int no;

        Kursi next;
    }

    static Kursi head;
    static Kursi tail;
    static Kursi temp;

    static void noKursi(String nama) {
        Kursi kursi = new Kursi();
        int count = 2;

        temp = head;
        
        if (head == null) {
            kursi.nama = nama;
            kursi.no = 1;

            head = kursi;
            System.out.println("Silahkan duduk di "+ kursi.no);

        } else {
            while (temp.next != null && temp.nama.equals("a") != true) {
                temp = temp.next;
                count++;
            }
            if(temp.nama.equals("a") == true){
                kursi.nama = nama;
            }else{
                kursi.nama = nama;
                kursi.no = count;

                temp.next = kursi;
                
                System.out.println("Silahkan duduk di "+ count);
            }
            
        }

    }

    static void keluar(String nama) {
        Kursi kursi = new Kursi();
        
        temp = head;
        if (temp != null) {
            while (temp != null && temp.nama.equals(nama) != true) {
                temp = temp.next;
            }
            kursi.nama = "a";
        }
        System.out.println("Nama " +nama+ " telah dihapus dari kursi no "+ temp.no);
    }

    static void baca() {
        Scanner input = new Scanner(System.in);

        System.out.println("Pilihan");
        System.out.println("1. Membaca buku / 2. Keluar ");
        
        int pilih;
        pilih = input.nextInt();
        
        switch (pilih) {
            case 1:
                
                String nama = JOptionPane.showInputDialog("Masukkan Nama Anda = ");
                boolean ada = Daftar.cek(nama);
                if (ada != true) {
                    System.out.println("Anda Belum Terdaftar, Silahkan Daftar!! ");
                    Menu.menu();
                } else {
                    Baca.noKursi(nama);
                    Menu.menu();
                }
                
                break;
                
            case 2:
                nama = JOptionPane.showInputDialog("Masukkan Nama Anda = ");
                ada = Daftar.cek(nama);
                if (ada != true) {
                    System.out.println("Anda Belum Terdaftar, Silahkan Daftar!! ");
                    Menu.menu();
                } else {
                    Baca.keluar(nama);
                    Menu.menu();
                }
                break;
            default:
                throw new AssertionError();
        }
    }
}
