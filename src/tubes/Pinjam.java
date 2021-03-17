package tubes;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Pinjam {

    static void pinjam() {
        Scanner input = new Scanner(System.in);

        System.out.println("Pilihan : ");
        System.out.println("1. Pinjam Buku");
        System.out.println("2. Kembali Buku");
        System.out.println("3. Cek Waiting");
        int pilihan = input.nextInt();

        switch (pilihan) {
            case 1:
                Pinjam.pil1();
                break;
            case 2:
                Pinjam.pil2();
                break;
            case 3:
                List.printWaiting();
                break;
            default:
                throw new AssertionError();
        }
    }

    static void pil1() {
        Scanner input = new Scanner(System.in);
        String judul;
        boolean ada;
        boolean wait;
        int total = 0;
        String kata;

        System.out.print("Masukkan Tanggal hari ini (01012019) = ");
        int tanggal = input.nextInt();
        System.out.println("Berapa buku yang ingin dipinjam?? Maks 5");
        int jumlah = input.nextInt();
        if (jumlah > 5 && jumlah == 0) {
            System.out.println("Salah masukkan input");
        } else {
            for (int i = 0; i < jumlah; i++) {
                System.out.println("Masukkan judul buku = ");
                kata = input.next();
                judul = kata + input.nextLine();
                ada = List.cek(judul);
                int bayar = List.bayar(judul);
                total = total + bayar;

                while (ada == false) {
                    System.out.println("Anda Salah Input");
                    judul = input.next();
                    ada = List.cek(judul);
                }
                String nama = JOptionPane.showInputDialog("Masukkan Nama Anda = ");
                ada = Daftar.cek(nama);

                if (ada != true) {
                    System.out.println("Anda Belum Terdaftar, Silahkan Daftar!! ");
                } else {
                    List.tanggal(tanggal, judul);
                    List.waiting(nama, judul, tanggal);
                }

            }
            System.out.println("Silahkan bayar sejumlah " + total);
            Menu.menu();
        }

    }

    static void pil2() {
        Scanner input = new Scanner(System.in);
        boolean ada;

        String nama = JOptionPane.showInputDialog("Masukkan Nama Anda = ");
        ada = Daftar.cek(nama);

        if (ada) {
            System.out.print("Masukkan Tanggal kembali (01012019) = ");
            int tanggal = input.nextInt();
            System.out.println("Masukkan judul buku = ");
            String judul = input.next();
            ada = List.cek(judul);
            if (ada != true) {
                System.out.println("Salah input / Buku tidak tersedia");
            } else {
                List.kembali(tanggal, judul);
                Menu.menu();
            }
        }else{
            System.out.println("Tidak terdaftar !!");
            Menu.menu();
        }
    }
}