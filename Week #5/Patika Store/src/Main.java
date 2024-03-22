import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Store store = new Store();
    public static void main(String[] args) {

        userInterface();





    }





    public static void userInterface() {
        Scanner input = new Scanner(System.in);

        int id = 0;
        int subMenu = 0;
        do {
            System.out.println("Patika Store Ürün Yönetim Paneli !\n" +
                    "1 - Notebook İşlemleri\n" +
                    "2 - Cep Telefonu İşlemleri\n" +
                    "3 - Marka Listele\n" +
                    "0 - Çıkış Yap");
            System.out.print("\nPlease enter your selection: ");

            id = input.nextInt();
            if (id > 0 || id < 4){
                switch (id) {
                    case 1:
                        System.out.println("1 - Add Notebook\n"+
                                "2 - Remove Notebook\n" +
                                "3 - List Notebook");
                        System.out.print("\nPlease enter your selection: ");
                        subMenu = input.nextInt();
                        switch (subMenu) {
                            case 1:
                                System.out.print("Product Name: ");
                                String productName = input.next();
                                System.out.print("Unit Price: ");
                                int unitPrice = input.nextInt();
                                System.out.print("Stok Amount: ");
                                int stockAmount = input.nextInt();
                                System.out.print("Brand Name: ");
                                String brandName = input.next();
                                System.out.print("Storage (GB): ");
                                int storage = input.nextInt();
                                System.out.print("RAM (GB): ");
                                int ram = input.nextInt();
                                System.out.print("Screen size (inch): ");
                                int screenSize = input.nextInt();

                                Notebook nt =  new Notebook(unitPrice,10,stockAmount,productName,brandName,screenSize,ram,storage);

                                store.addNotebook(nt);

                                break;
                            case 2:
                                System.out.println("Please enter product ID for remove");
                                int notebookID = input.nextInt();
                                store.removeNotebook(notebookID);

                                break;
                            case 3:
                                int count = 1;
                                ArrayList<Notebook> notebookList = store.getNotebook();
                                //Notebook nttrt = new Notebook(23,23,32,"Mac","Apple",21,23,23);
                                //notebookList.add(nttrt);
                                System.out.println("----------------------------------------------------------------------------------------------------");
                                System.out.println("| ID | Ürün Adı                       | Fiyat      | Marka     | Depolama  | Ekran     | RAM         |");
                                for(Notebook ntbook : notebookList ) {
                                    System.out.format("| %-2d | %-30s | %-9.1f TL| %-9s | %-10d | %-6d | %-11d |",count,ntbook.productName,(float)ntbook.price,ntbook.brandName,ntbook.Storage,ntbook.screenSize,ntbook.ram );
                                    count++;
                                    System.out.println();
                                }
                                System.out.println();
                                System.out.println("----------------------------------------------------------------------------------------------------");


                                break;
                        }

                        break;
                    case 2:
                        System.out.println("1 - Add MobilePhone\n"+
                                "2 - Remove MobilePhone\n" +
                                "3 - List MobilePhone");
                        System.out.print("\nPlease enter your selection: ");

                        subMenu = input.nextInt();
                        switch (subMenu) {
                            case 1:
                                System.out.print("Product Name: ");
                                String productName = input.next();
                                System.out.print("Unit Price: ");
                                int unitPrice = input.nextInt();
                                System.out.print("Stok Amount: ");
                                int stockAmount = input.nextInt();
                                System.out.print("Brand Name: ");
                                String brandName = input.next();
                                System.out.print("Storage (GB): ");
                                int storage = input.nextInt();
                                System.out.print("RAM (GB): ");
                                int ram = input.nextInt();
                                System.out.print("Screen size (inch): ");
                                int screenSize = input.nextInt();
                                System.out.print("Color): ");
                                String color = input.next();
                                System.out.print("Battery: ");
                                int battery = input.nextInt();

                                MobilePhone mp2 = new MobilePhone(unitPrice,3,stockAmount,productName,brandName,screenSize,ram,storage,battery,color);
                                store.addMobilePhone(mp2);

                                break;
                            case 2:
                                System.out.println("Please enter product ID for remove");
                                int mobilePhoneID = input.nextInt();
                                store.removePhone(mobilePhoneID);
                                break;
                            case 3:
                                int count = 1;
                                ArrayList<MobilePhone> mobilePhones = store.getMobilePhones();
                                //Notebook nttrt = new Notebook(23,23,32,"Mac","Apple",21,23,23);
                                //notebookList.add(nttrt);
                                System.out.println("----------------------------------------------------------------------------------------------------");
                                System.out.println("| ID | Ürün Adı                       | Fiyat      | Marka     | Depolama  | Ekran     | RAM         | Battery       | Color         |");
                                for(MobilePhone mp : mobilePhones ) {
                                    System.out.format("| %-2d | %-30s | %-9.1f TL| %-9s | %-10d | %-6d | %-11d | %-6d | %-15s |",count,mp.productName,(float)mp.price,mp.brandName,mp.mobilePhoneMemory,mp.screenSize,mp.ram,mp.batteryPower,mp.color );
                                    count++;
                                    System.out.println();
                                }
                                System.out.println();
                                System.out.println("----------------------------------------------------------------------------------------------------");

                                break;
                        }

                        break;
                    case 3:
                        System.out.println();
                        for (Brands brands : Brands.brandsList) {
                            System.out.println(brands.getName());
                        }
                        System.out.println();
                        break;
                }
            } else {
                System.out.println("Please enter a valid selection");
            }

        } while (id != 0);

    }
}