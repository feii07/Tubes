
package tubes;
import javax.swing.JOptionPane;

public class Daftar {
    
    static class Regis {
    
        String nama;
        String email;
        String no;
        String alamat;

        Regis next;
    }
    
    static Regis head;
    static Regis tail;
    static Regis temp;
    
    static void listorang(){
        
        Regis signup = new Regis();
        
        String name = JOptionPane.showInputDialog( "Masukkan nama Anda = ");
        String email = JOptionPane.showInputDialog( "Masukkan email Anda = ");
        String no = JOptionPane.showInputDialog( "Masukkan no telp Anda = ");
        String alamat = JOptionPane.showInputDialog( "Masukkan alamat Anda = ");
        
        if(head == null){
            signup.nama = name;
            signup.email = email;
            signup.no = no;
            signup.alamat = alamat;
            
            head = signup;
            tail = head;
        }else{
            while(tail.next != null){
                tail = tail.next;
            }
            signup.nama = name;
            signup.email = email;
            signup.no = no;
            signup.alamat = alamat;
            
            tail.next = signup;
            tail = tail.next;
        }
        
        System.out.println("Selamat " + tail.nama + " telah Terdaftar");
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
    
}
