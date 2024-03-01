public class Main {
    public static void main(String[] args) {

        String[][] arr = new String[7][4];

        for (int i = 0; i < arr.length; i++) {
            System.out.println();
            for(int j = 0; j < arr[i].length; j++) {
                if(i == 0 || i == 3 || i == 6) {
                    System.out.print(" * ");
                } else if (j == 0 || j == 3 ) {
                    System.out.print(" * ");
                } else {
                    System.out.print("   ");
                }
            }
        }
    }
}