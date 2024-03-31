import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String text = "";
        Scanner scanner = new Scanner(System.in);

        while (true) {
            File file = new File("notepad.txt");
            System.out.print("Please enter your text ('r' for read - 'e' for exit) : ");
            String time = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
            text = scanner.nextLine();

            if (text.equals("e")) {
                System.out.println("Program ended.");
                try {
                    FileReader fReader = new FileReader(file);
                    BufferedReader bReader = new BufferedReader(fReader);
                    String line = bReader.readLine();

                    if (line != null) {
                        String lastLine = "";

                        while (line != null) {
                            lastLine = line;
                            line = bReader.readLine();
                        }
                        System.out.println("Last data was recorded: " + lastLine);
                    }

                    bReader.close();
                } catch (Exception e) {

                }

            }

            if (text.equals("r")) {
                try {
                    FileReader fReader = new FileReader(file);
                    BufferedReader bReader = new BufferedReader(fReader);
                    String line = bReader.readLine();

                    if (line == null) {
                        System.out.println("No Data");
                    } else {
                        System.out.println("Data: ");
                        while (line != null) {
                            System.out.println(line);
                            line = bReader.readLine();
                        }
                    }
                    bReader.close();

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            } else {
                if (!file.exists()) {
                    boolean createFile =  file.createNewFile();
                }
                FileWriter fWriter = new FileWriter(file, file.exists());
                BufferedWriter bWriter = new BufferedWriter(fWriter);
                bWriter.write("(" + time + ") ");
                bWriter.write(text);
                bWriter.newLine();
                bWriter.close();

            }

        }


    }
}