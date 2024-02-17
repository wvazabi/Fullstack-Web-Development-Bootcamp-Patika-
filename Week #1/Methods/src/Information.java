public class Information {
    int memory;
    int num = 20;
    boolean status;
    String genre;


    public Information(int xmemory, int xnum) {

        memory = xmemory;
        num = xnum;
    }
    public void print() {
        System.out.println(memory);
        System.out.println(status);
        System.out.println(genre);
    }

}
