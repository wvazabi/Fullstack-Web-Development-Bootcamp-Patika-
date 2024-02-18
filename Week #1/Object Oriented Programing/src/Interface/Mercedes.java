package Interface;

public class Mercedes implements Vehicle,Audi {
    @java.lang.Override
    public void run3() {
        System.out.println("run3");
    }

    @java.lang.Override
    public void run() {
        System.out.println("run2");
    }
}
