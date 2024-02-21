import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Sıcaklık değerini giriniz: ");
        int heat = input.nextInt();

        String activity;

        switch (heat) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                activity = "Kayak yapabilirsiniz";
                break;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
                activity = "Sinema'ya gidilebilir";
                break;
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
                activity = "Pikniğe gidilebilir";
                break;
            default:
                if(heat >= 25){
                    activity = "Yüzme";
                } else {
                    activity = "Kayak";
                }
                break;
        }



        System.out.println(activity);
    }
}
