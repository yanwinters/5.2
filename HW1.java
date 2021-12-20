package Lection52;

import java.io.*;
import java.util.Scanner;

public class HW1 {
    static Scanner console = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        File file = new File("Текст.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            }
            catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }

        try (FileWriter writer = new FileWriter(file, true)) {
            BufferedReader br = new BufferedReader(new FileReader("Текст.txt"));
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            System.out.println("Введите строку, которую нужно дописать в файл:");
            String str1 = console.nextLine();
            sb.append(str1);
            sb.append('\n');
            String result = sb.toString();
            writer.write(result);
            writer.flush();
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
