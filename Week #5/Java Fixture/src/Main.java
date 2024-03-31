import java.util.*;

public class Main {
    public static String[] karıştır(String Takımlar_dizisi[],String Temporary[],int mesaj){
        String Temporary2[] = new String[mesaj];
        Temporary=Temporary2;
        Temporary[0] = Takımlar_dizisi[0];

        for (int i = 1; i < Takımlar_dizisi.length - 1; i++) {
            Temporary[i + 1] = Takımlar_dizisi[i];
            if (i == Takımlar_dizisi.length - 2) {
                Temporary[1] = Takımlar_dizisi[Takımlar_dizisi.length - 1];
            }
        }

        return Temporary;

    }
    public static void yazdır(String Takımlar_dizisi[],int k,int mesaj){

        System.out.println(k+".HAFTA");
        System.out.println(Takımlar_dizisi[0] + " vs " + Takımlar_dizisi[mesaj/2]);
        for (int i = 1; i <= (Takımlar_dizisi.length / 2) - 1; i++) {
            System.out.println(Takımlar_dizisi[i] + " vs " + Takımlar_dizisi[mesaj - i]);
        }
        System.out.println();


    }
    public static String[] karıştır2(String Takımlar_dizisi[],String Temporary[],int mesaj){
        String Temporary2[] = new String[mesaj];
        Temporary=Temporary2;
        Temporary[0] = Takımlar_dizisi[0];
        for (int i = 0; i < Takımlar_dizisi.length - 1; i++) {
            if(i== 0){
                Temporary[0] = Takımlar_dizisi[Takımlar_dizisi.length-1];
            }
            Temporary[i + 1] = Takımlar_dizisi[i];
        }
        Takımlar_dizisi = Temporary;
        return Temporary;

    }

    public static void yazdır2(String Takımlar_dizisi[],int k,int mesaj){

        System.out.println(k+".HAFTA");
        for (int i = 0; i <= (Takımlar_dizisi.length / 2); i++) {
            if(i== Takımlar_dizisi.length/2){
                System.out.println(Takımlar_dizisi[i]+" Bay Geçti");
            }
            else{
                System.out.println(Takımlar_dizisi[i] + " vs " + Takımlar_dizisi[mesaj - i-1]);
            }

        }
        System.out.println();


    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        while (true){
            System.out.println("Kaç Takımlı Bir Fikstür Oluşturmak istiyorsunuz? (Çıkmak için 0'a basın)");
            int mesaj = input.nextInt();
            if(mesaj==0){
                break;
            }
            int x = mesaj;
            Random r = new Random();
            int random;
            int hafta=1;
            ArrayList<String> Takımlar = new ArrayList<>();
            String Takımlar_dizisi[] = new String[mesaj];
            String Temporary[] = new String[mesaj];

            for (int i = 0; i < mesaj; i++) {
                System.out.println((i+1)+".Takımın Adını Giriniz: ");
                String Takım=input2.nextLine();
                Takımlar.add(Takım);
            }




            for (int i = 0; i < Takımlar_dizisi.length; i++) {


                random = r.nextInt(x);
                Takımlar_dizisi[i] = Takımlar.get(random);
                Takımlar.remove(random);
                x--;


            }


            if(mesaj%2==0){
                yazdır(Takımlar_dizisi,hafta,mesaj);
                System.out.println();
                hafta++;
                for ( ; hafta < Takımlar_dizisi.length ; hafta++) {
                    Takımlar_dizisi=karıştır(Takımlar_dizisi,Temporary,mesaj);


                    yazdır(Takımlar_dizisi,hafta,mesaj);
                }
            }
            else{
                for ( ; hafta < Takımlar_dizisi.length+1 ; hafta++) {
                    Takımlar_dizisi=karıştır2(Takımlar_dizisi,Temporary,mesaj);


                    yazdır2(Takımlar_dizisi,hafta,mesaj);
                }


            }

        }




    }


}