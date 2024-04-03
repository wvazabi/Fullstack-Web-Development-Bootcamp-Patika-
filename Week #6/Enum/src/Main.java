public class Main {
    public static void main(String[] args) {

        Day gunPzt = Day.PAZARTESI;
        System.out.println(gunPzt.ordinal()); // Dizideki indeksini verir.
        System.out.println(gunPzt.name()); // Sabit'in adını döndürür.

        Day[] values = Day.values(); // Tüm sabitlerini döndürür.

        Day gun = Day.valueOf("PAZARTESI"); // String'i enum'a dönüştürür.
    }
}