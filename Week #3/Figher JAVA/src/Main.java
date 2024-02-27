public class Main {
    public static void main(String[] args) {

    Fighter f1 = new Fighter("Mike",15,200,90,30);
    Fighter f2 = new Fighter("M.Ali",19,190,80,55);

    Match match = new Match(f1,f2,80,150);
    match.run();

    }
}