import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        int mesafe,yas,yolculukTipi;
        float mesafeBasiKM = 0.1F;
        double ucret, yasIndirim = 0, biletIndirim = 0;


        Scanner input = new Scanner(System.in);

        System.out.print("Mesafe Giriniz: ");
        mesafe = input.nextInt();

        System.out.print("\nYas Giriniz: ");
        yas = input.nextInt();

        System.out.println("\nYolculuk Tipi Giriniz: (1 ya da 2)");
        yolculukTipi = input.nextInt();



 // yolculuk tipi ise 1 veya 2


            while(!(mesafe > 0 && yas > 0 && (yolculukTipi == 1 || yolculukTipi == 2))) {

                System.out.println("Hatalı Veri Girdiniz !");

                System.out.print("Mesafe Giriniz: ");
                mesafe = input.nextInt();

                System.out.print("\nYas Giriniz: ");
                yas = input.nextInt();

                System.out.println("\nYolculuk Tipi Giriniz: (1 ya da 2) ");
                yolculukTipi = input.nextInt();

//                if((mesafe > 0 && yas > 0 && (yolculukTipi == 1 || yolculukTipi == 2))) {
//                    break;
//                }
            }

        ucret = mesafe * mesafeBasiKM;


        if(yas < 12) {
               yasIndirim =  (ucret * 0.5);
            } else if (yas > 12 && yas < 24) {
                yasIndirim =  ucret * 0.1;
            } else if (yas > 65) {
                yasIndirim =  ucret * 0.3;
            } else {

            }

        ucret -= yasIndirim;

            switch (yolculukTipi) {
                case 1:
                    System.out.println("Tek Yön");
                    break;
                case 2:
                    System.out.println("Çift Yön bilet");
                    biletIndirim = ucret * 0.2;
                    ucret -= biletIndirim;
                    ucret *= 2;
                    break;
                default:
                    break;
            }


            System.out.println("Uçak biletiniz: " + ucret);
















    }
}