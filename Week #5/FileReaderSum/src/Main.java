import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] numArr = {5,10,20,12,33};
        File file = new File("number.txt");
        if(!file.exists()){
            file.createNewFile();
        }

        FileWriter fWriter = new FileWriter(file, false);
        BufferedWriter bWriter = new BufferedWriter(fWriter);
        for(int n: numArr){
            System.out.println(n);
            bWriter.write(String.valueOf(n));
            bWriter.newLine();
        }
        bWriter.close();

        FileReader fReader = new FileReader(file);
        BufferedReader bReader = new BufferedReader(fReader);
        String line;

        int sum = 0;

        while ((line = bReader.readLine()) != null){
            sum += Integer.parseInt(line);
        }

        bReader.close();

        System.out.println("Sum of the numbers in the file : " + sum);

    }
}