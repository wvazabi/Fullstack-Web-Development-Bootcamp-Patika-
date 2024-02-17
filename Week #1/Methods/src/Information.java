public class Information {
    int memory;
    int num = 20;



    private static String brand = "Audi";
    boolean status;
    String genre;

    static int model = 2024;

    static {
        model = 23234;
    }


    public Information() {

    }

    private void prvtMethod() {
        System.out.println("Top Secret");

    }

    public static void test2() {
        System.out.println("test method");
    }
    public Information(int xmemory, int xnum, int xmodel) {

        memory = xmemory;
        num = xnum;
        model = xmodel;
    }
    public void print() {
        System.out.println(memory);
        System.out.println(status);
        System.out.println(genre);
        System.out.println(model);
    }

}
