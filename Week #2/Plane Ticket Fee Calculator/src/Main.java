import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Değişkenlerin tanımlanması
        int mesafe, yas, yolculukTipi;
        float mesafeBasiKM = 0.1F;
        double ucret, yasIndirim = 0, biletIndirim = 0;

        // Kullanıcı girişlerinin alınması için bir Scanner oluşturulması
        Scanner input = new Scanner(System.in);

        // Kullanıcıdan mesafe girişinin istenmesi
        System.out.print("Mesafe Giriniz: ");
        mesafe = input.nextInt();

        // Kullanıcıdan yaş girişinin istenmesi
        System.out.print("\nYas Giriniz: ");
        yas = input.nextInt();

        // Kullanıcıdan yolculuk tipi girişinin istenmesi (1 ya da 2)
        System.out.println("\nYolculuk Tipi Giriniz: (1 ya da 2)");
        yolculukTipi = input.nextInt();

        // Girilen verilerin doğruluğunun kontrol edilmesi ve hatalı girişlerin yeniden istenmesi
        while (!(mesafe > 0 && yas > 0 && (yolculukTipi == 1 || yolculukTipi == 2))) {
            System.out.println("Hatalı Veri Girdiniz !");
            System.out.print("Mesafe Giriniz: ");
            mesafe = input.nextInt();
            System.out.print("\nYas Giriniz: ");
            yas = input.nextInt();
            System.out.println("\nYolculuk Tipi Giriniz: (1 ya da 2) ");
            yolculukTipi = input.nextInt();
        }

        // Ücretin mesafe ile mesafe başına ücret çarpımı ile hesaplanması
        ucret = mesafe * mesafeBasiKM;

        // Yaşa göre indirim uygulanması
        if (yas < 12) {
            yasIndirim = (ucret * 0.5);
        } else if (yas > 12 && yas < 24) {
            yasIndirim = ucret * 0.1;
        } else if (yas > 65) {
            yasIndirim = ucret * 0.3;
        } else {
            // Herhangi bir indirim uygulanmaması durumu
        }

        // Yaş indiriminin ücretten düşülmesi
        ucret -= yasIndirim;

        // Yolculuk tipine göre işlemlerin yapılması
        switch (yolculukTipi) {
            case 1:
                System.out.println("Tek Yön");
                break;
            case 2:
                System.out.println("Çift Yön bilet");
                // Bilet indirimi ve çift yöne göre ek işlemlerin yapılması
                biletIndirim = ucret * 0.2;
                ucret -= biletIndirim;
                ucret *= 2;
                break;
            default:
                break;
        }

        // Son ücretin ekrana yazdırılması
        System.out.println("Uçak biletiniz: " + ucret);
    }
}
