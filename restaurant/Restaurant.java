package restaurant;

/**
 *
 * @author NAFFA
 */
public class Restaurant {
    private static byte id = 0;            
    
    private Makanan[] menu = new Makanan[10];
    
    public Restaurant(){
        for(int i = 0; i < 10; i++){
            menu[i] = new Makanan();
        }
    }
    
    public boolean isOutOfStock(int id){
        if (this.menu[id].getStok() == 0){
            return true;
        }else{
            return false;
        }
    }
    
    public void tambahMenuMakanan (String nama, double harga, int stok){        
        this.menu[id].setNama_makanan(nama); 
        this.menu[id].setHarga_makanan(harga);
        this.menu[id].setStok(stok);
    }
    
    public void tampilMenuMakanan(){
        System.out.println("\tDaftar Menu");
        int j = 1;
        for(int i = 0; i <= id; i++){
            if (!isOutOfStock(i)){ 
                    System.out.println(j+ ". " + menu[i].getNama_makanan() +" ["+menu[i].getStok()+"}\t"+"Rp. "+menu[i].getHarga_makanan());
                    j++;
            }
        }
    }
    
    public static void nextId(){
        id++;
    }
    
    public void Pemesanan(byte order, int jumlah){
        String nama = null;
        switch (order){
            case 1 : nama = "Bala-Bala" ; break;
            case 2 : nama = "Gehu"; break;
            case 3 : nama = "Molen"; break;
        }
        System.out.println("\nMakanan yang dipesan : "+nama + "\nSejumlah : "+jumlah);
        for (int i = 0; i <= id; i++){
            if (this.menu[i].getNama_makanan().equals(nama)){
                if(!isOutOfStock(i)){
                    if(this.menu[id].getStok() - jumlah < 0){
                       System.out.println("Status : Gagal! Pemesanan melebihi stok\n");
                       break;
                    }
                    else {
                        System.out.println("Status : Pemesanan berhasil\n");
                        this.menu[i].setStok(this.menu[i].getStok() - jumlah);
                    }
                }
            }
        }
    }
}
