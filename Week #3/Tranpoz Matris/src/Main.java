public class Main {
    public static int[][] transpoze(int[][] x,int rows, int cols){

        int[][] matrix = new int[rows][cols];
        int[][] transMat = new int[cols][rows];
        int num = 10;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transMat[j][i] = x[i][j];
            }
        }
        return transMat;

    }
    public static void main(String[] args) {

//        int[][] matris = new int[2][3];
        int[][] matris = {
                {1,2,3},
                {4,5,6}
                         };
        matris = transpoze(matris,matris.length, matris[0].length);

        for (int i = 0; i < matris.length; i++) {
            for (int j = 0; j < matris[i].length; j++) {
                System.out.print(matris[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

    }
}