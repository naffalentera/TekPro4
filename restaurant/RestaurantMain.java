package restaurant;

import java.util.Scanner;


/**
 *
 * @author NAFFA
 */
public class RestaurantMain {
    public static void main(String[] args){
        Restaurant menu = new Restaurant();
        menu.tambahMenuMakanan("Bala-Bala",1_000, 20);
        Restaurant.nextId();
        menu.tambahMenuMakanan("Gehu",1_000, 20);
        Restaurant.nextId();
        menu.tambahMenuMakanan("Tahu", 1_000, 0);
        Restaurant.nextId();
        menu.tambahMenuMakanan("Molen", 1_000, 20);
        
        menu.tampilMenuMakanan();
        
        Scanner input = new Scanner(System.in);
        System.out.print("\nPilih makanan yang dipesan (masukkan angka) : ");
        byte nama = input.nextByte();
        System.out.print("Masukkan jumlah makanan yang dipesan : ");
        int jumlah = input.nextByte();       
        menu.Pemesanan(nama, jumlah);
        input.close();
        
        menu.tampilMenuMakanan();
    }
}
