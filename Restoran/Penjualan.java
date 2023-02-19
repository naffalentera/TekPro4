package Restoran;

/**
 *
 * @author NAFFA
 */
public class Penjualan {
    private String[] nama_order = null;
    private int[] quantity;
    private double[] harga_order;
    private double harga_total;
    private int penampung;
    private static byte id = 0;
    
    private Produk[] menu = new Produk[20];
    
    public Penjualan(){
        this.nama_order = new String[20];
        this.quantity = new int[20];
        this.harga_order = new double[20];
        this.penampung = 0;
        for(int i = 0; i < 20; i++){
            menu[i] = new Produk();
        }
    }
    
    public void tambahMenuMakanan (String nama, double harga, int stok){        
        this.menu[id].setNama(nama); 
        this.menu[id].setHarga(harga);
        this.menu[id].setStok(stok);
    }
    
    public void Menu(){
        tambahMenuMakanan("Batagor", 5_000, 20);
        nextId();
        tambahMenuMakanan("Roti Bakar", 12_000, 20);
        nextId();
        tambahMenuMakanan("Indomie+Telor", 10_000, 20);
        nextId();
        tambahMenuMakanan("Kwetiaw", 12_000, 20);
        nextId();
        tambahMenuMakanan("Nasi Goreng", 12_000, 20);
        nextId();
        tambahMenuMakanan("Air Mineral", 3_000, 20);
        nextId();
        tambahMenuMakanan("Teh Manis", 4_000, 20);
        nextId();
        tambahMenuMakanan("Jus Alpukat", 8_000, 20);           
        nextId();
        tambahMenuMakanan("Teh Botol", 5_000, 20);
        nextId();
        tambahMenuMakanan("Kopi Susu", 3_000, 20);    
    }
    
    public void displayMenu(){
        Menu();
        System.out.println("\tDaftar Menu");
        int j = 1;
        for(int i = 0; i <= id; i++){
            if (!isOutOfStock(i)){ 
                    System.out.println(j+ ". " + menu[i].getNama() +"\t= Rp. "+menu[i].getHarga());
                    j++;
            }
        }
    }
    
    public boolean isOutOfStock(int id){
        if (this.menu[id].getStok() == 0){
            return true;
        }else{
            return false;
        }
    }
    
    public static void nextId(){
        id++;
    }
    
    public void Pemesanan(int order, int jumlah){
        String nama = "";
        String[] menuNames = {"Batagor", "Roti Bakar", "Indomie+Telor", "Kwetiaw", "Nasi Goreng", "Air Mineral", "Teh Manis", "Jus Alpukat", "Teh Botol", "Kopi Susu"};
        if (order >= 1) {
            nama = menuNames[order-1];
            System.out.println("\nMakanan yang dipesan : "+nama + "\nSejumlah : "+jumlah);
        }
        for (int i = 0; i <= id; i++){
            if (this.menu[i].getNama().equals(nama)){
                if(!isOutOfStock(i)){
                    if(this.menu[id].getStok() - jumlah < 0){
                       System.out.println("Status : Gagal! Pemesanan melebihi stok");
                       System.out.print("Stok tersisa : " + this.menu[i].getStok());
                       break;
                    }
                    else {
                        System.out.print("Status : Pemesanan berhasil");
                        this.menu[i].setStok(this.menu[i].getStok() - jumlah);
                        this.nama_order[penampung] = nama;
                        this.quantity[penampung] = jumlah;
                        this.harga_order[penampung] = this.menu[i].getHarga() * jumlah;                            
                        this.harga_total = totalBayar(this.nama_order, this.quantity);                       
                        penampung++;
                        break;                        
                    }
                }
                else {System.out.println("Status : Gagal! Pemesanan melebihi stok");
                       System.out.print("Stok tersisa : " + this.menu[i].getStok());}
            }
        }
    }
            
    public double totalBayar(String[] nama, int[] qty){ 
        this.harga_total = 0;
        boolean[] isNamaChecked = new boolean[nama.length];
        for (int i = 0; i <= id; i++){
            for (int j = 0; j < nama.length; j++) {
                if (this.menu[i].getNama().equals(nama[j]) && !isNamaChecked[j]){
                    this.harga_total += this.menu[i].getHarga() * qty[j];
                    isNamaChecked[j] = true;
                }
            }
        }
        return this.harga_total;
    }
       
    public void displayPesanan(){
        System.out.println("\n\tTotal Pesanan");
        boolean[] isMenuDisplayed = new boolean[this.nama_order.length];
        id = 0;
        do{
            System.out.println(this.nama_order[id] + "(" + this.quantity[id] + ")" + "\t= Rp. " + this.harga_order[id]);
            isMenuDisplayed[id] = true;
            id++;
        }while(!isMenuDisplayed[id] && this.nama_order[id] != null);
        System.out.println("\nTotal Harga \t= Rp. " + this.harga_total);
    }
    
}

