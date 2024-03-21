import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    Store store = new Store();
    public static void main(String[] args) {

        for (Brands brands : Brands.brandsList) {
            System.out.println(brands.getName());
        }





    }

    public void userInterface() {
        Scanner input = new Scanner(System.in);

        int id = 0;
        int subMenu = 0;
        do {
            System.out.println("atikaStore Ürün Yönetim Paneli !\n" +
                    "1 - Notebook İşlemleri\n" +
                    "2 - Cep Telefonu İşlemleri\n" +
                    "3 - Marka Listele\n" +
                    "0 - Çıkış Yap");

            id = input.nextInt();
            if (id > 0 || id < 4){
                switch (id) {
                    case 1:
                        System.out.println("1 - Add Notebook\n"+
                                "2 - Remove Notebook\n" +
                                "3 - List Notebook");
                        subMenu = input.nextInt();
                        switch (subMenu) {
                            case 1:
                                System.out.print("Ürün Adı: ");
                                String urunAdi = input.nextLine();
                                System.out.print("Birim Fiyat: ");
                                double birimFiyat = input.nextDouble();
                                System.out.print("Stok Miktarı: ");
                                int stokMiktari = input.nextInt();
                                System.out.print("Marka ID: ");
                                int markaId = input.nextInt();
                                System.out.print("Depolama (GB): ");
                                depolama = scanner.nextInt();
                                System.out.print("RAM (GB): ");
                                ram = scanner.nextInt();
                                System.out.print("Ekran Boyutu (inç): ");
                                ekranBoyutu = scanner.nextDouble();

                                Notebook nt = new Notebook()
                                store.addNotebook();
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                        }

                        break;
                    case 2:
                        System.out.println("1 - Add MobilePhone\n"+
                                "2 - Remove MobilePhone\n" +
                                "3 - List MobilePhone");
                        subMenu = input.nextInt();

                        break;
                    case 3:
                        break;
                }
            } else {
                System.out.println("Please enter a valid selection");
            }

        } while (id != 0);

    }
}