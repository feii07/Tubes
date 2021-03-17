
package tubes;
import javax.swing.JOptionPane;

public class Tubes {
        
        public static void main(String[] args) {
            List.insert("Garis Waktu", 1, 3000);
            List.insert("Jomblo", 2, 2500);
            List.insert("Rumah Boneka", 3, 3500);
            List.insert("Penghuni Tanah Tabu", 4, 4000);
            List.insert("Self Riding", 5, 5000);
            List.insert("Sherlock Holmes", 6, 4500);
            
            
            JOptionPane.showMessageDialog(null, "Selamat Datang Di Perpustakaan ");
            Menu.menu();
            
    }
    
}