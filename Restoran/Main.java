package Restoran;



/**
 *
 * @author NAFFA
 */

import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Penjualan menu = new Penjualan();       
        String keputusan = "N";
        Scanner input = new Scanner(System.in);
        menu.displayMenu();
        do {            
            System.out.print("\nPilih menu yang dipesan (masukkan angka) : ");
            int order = input.nextInt();
            System.out.print("Masukkan jumlah menu yang dipesan : ");
            int jumlah = input.nextByte();       
            menu.Pemesanan(order, jumlah);            
            System.out.print("\n\nApakah ingin menambah menu? (Y/N) : ");
            keputusan = input.next();
        }while (keputusan.equals("Y"));
        input.close();
        menu.displayPesanan();
        
        
    }
}
