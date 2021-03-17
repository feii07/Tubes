package tubes;

import java.util.Scanner;

public class List {

    static class Buku {

        String nama;
        int golongan;
        int harga;
        Buku next;
        int tanggalk;
        int tanggal;
        
        Waiting head;

    }
    
    static class Waiting {

            String nama;
           
            Waiting next;
        }
    

    static Buku head;
    static Buku temp;

    static void list() {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan Judul Buku= ");
        String judul = input.nextLine();
        System.out.println("Pilih Golongan= ");
        System.out.println("1. Romantis ");
        System.out.println("2. Komedi ");
        System.out.println("3. Drama ");
        System.out.println("4. Horror ");
        System.out.println("5. Non-Fiksi ");
        System.out.println("6. Lainnya ");
        System.out.print("Masukkan pilihan golongan buku:  ");
        int gol = input.nextInt();

        int price;
        switch (gol) {
            case 1:
                price = 3000;
                break;
            case 2:
                price = 2500;
                break;
            case 3:
                price = 3500;
                break;
            case 4:
                price = 4000;
                break;
            case 5:
                price = 5000;
                break;
            case 6:
                price = 4500;
                break;
            default:
                throw new AssertionError();

        }
        List.insert(judul, gol, price);
    }

    static void insert(String judul, int gol, int price) {
        Buku buku = new Buku();
        if (head == null) {
            buku.nama = judul;
            buku.golongan = gol;
            buku.harga = price;

            head = buku;

        } else {
            temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            buku.nama = judul;
            buku.golongan = gol;
            buku.harga = price;

            temp.next = buku;
        }

    }

    static void Hapus(){
        Scanner input = new Scanner(System.in);
        System.out.println("Masukkan Judul Buku yang ingin dihapus = ");
        String judul = input.nextLine();

        temp = head;
        if (temp.nama.equalsIgnoreCase(judul) == true) {
            temp = temp.next;
            head = temp;
        } else {
            while (temp.next.nama.equalsIgnoreCase(judul) != true) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }

        System.out.println("1. Kembali ke Menu?");
        System.out.println("2. Hapus buku lagi?");
        int pilih = input.nextInt();
        switch (pilih) {
            case 1:
                Menu.menu();
                break;
            case 2:
                List.Hapus();
                break;
            default:
                throw new AssertionError();
        }
    }

    static void print() {
        temp = head;
        String b;
        
        while (temp != null) {
            System.out.println("Judul    :" + temp.nama);
            int a = temp.golongan;
            if(a == 1){
                b = "Romantis";
            }else if(a == 2){
                b = "Komedi";
            }else if(a == 3){
                b = "Drama";
            }else if(a == 4){
                b = "Horror";
            }else if(a == 5){
                b = "Non-Fiksi";
            }else{
                b = "Lainnya";
            }
            System.out.println("Kategori : " + b);
            System.out.println(temp.harga);
            System.out.println("----------------");

            temp = temp.next;
        }
    }

    static boolean cek(String nama) {
        temp = head;

        while (temp.nama.equalsIgnoreCase(nama) != true && temp.next != null) {
            temp = temp.next;
        }
        if (temp.nama.equalsIgnoreCase(nama) == true) {
            return true;
        } else {
            return false;
        }

    }
    
    static int bayar(String judul){
        temp = head;
        
        while (temp.nama.equalsIgnoreCase(judul) != true) {
            temp = temp.next;
        }
        return temp.harga;
    }
    
    static void waiting(String nama,String judul, int tanggal){
        Waiting waitingTemp = null;
        
        while (judul.equalsIgnoreCase(temp.nama) != true) {
            temp = temp.next;
        }
        Waiting waits = new Waiting();
        
        int count = 2;
        
        if(temp.head == null){
            waits.nama = nama;
            
            temp.head = waits;
            System.out.println("Anda Urutan ke 1");
            System.out.println("Selamat Membaca!!");
            int kembali = tanggal + 7000000;
            System.out.println("Jangan lupa kembalikan pada 0"+ kembali);
        }else{
            waitingTemp = temp.head;
            while( waitingTemp.next != null ){
                waitingTemp = waitingTemp.next;
                count++;
            }
            waits.nama = nama;
            waitingTemp.next = waits;
            
            System.out.println("Anda Urutan ke "+ count);
            System.out.println("Akan kami infokan kalau sudah tersedia!");
        }
    }
    
    static void printWaiting (){
        temp = head;
       Waiting waitingTemp = null;
        int counter=1;
        
        while (temp != null){
            System.out.println("Waiting Buku "+temp.nama);
            waitingTemp = temp.head;
            if(temp.head == null){
                System.out.println(" Tidak ada Waiting ");
            }else{
                waitingTemp = temp.head;
                while(waitingTemp != null){
                System.out.println("Urutan "+counter + " : "+ waitingTemp.nama);
                waitingTemp = waitingTemp.next;
                counter++;
                
                }
            }
            counter = 1;
            temp = temp.next;
        }
    }
    
    static void tanggal(int tgl , String buku){
        temp = head;
        
        while(temp != null && temp.nama.equalsIgnoreCase(buku)){
            temp = temp.next;
        }
        temp.tanggal = tgl;
        
    }
    
    static void kembali (int tanggal, String buku){
        temp = head;
        
        while(temp != null && temp.nama.equalsIgnoreCase(buku)){
            temp = temp.next;
        }
        temp.tanggalk = tanggal;
        
        int hasil = temp.tanggalk - temp.tanggal;
       if(hasil > 7000000){
           hasil = hasil - 7000000;
           hasil = hasil/1000000;
           int total = hasil*5000;
           System.out.println("Anda Harus Membayar denda sebesar "+total);
       }else{
           System.out.println("Terimakasih sudah meminjam dan mengembalikan tepat waktu!!");
       }
       
       
    }
    
    static void uas(){
        temp = head;
        Waiting waitingTemp = null;
        int counter=0;
        int total = 0;
        
        System.out.println(" Nama Buku    \t  Jumlah Antrian   ");
        while (temp != null){
            waitingTemp = temp.head;
            
                waitingTemp = temp.head;
                while(waitingTemp != null){
                waitingTemp = waitingTemp.next;
                counter++;
                
            }
         if(  temp.nama.equals("Penghuni Tanah Tabu")  ){
            System.out.print( temp.nama ); 
            System.out.print("\t ");
            System.out.print( counter );
            System.out.println("");
            temp = temp.next;
         }else if(temp.nama.equals("Rumah Boneka") ||  temp.nama.equals("Sherlock Holmes")){
            System.out.print( temp.nama ); 
            System.out.print("      \t ");
            System.out.print( counter );
            System.out.println("");
            temp = temp.next;
         }else{ 
             System.out.print( temp.nama ); 
            System.out.print("            \t ");
            System.out.print( counter );
            System.out.println("");
            temp = temp.next;
         }
         total = total + counter;
         counter = 0;
            
        }
        System.out.println(" ---------------------");
        System.out.println("Total : " + total );
    }

}
