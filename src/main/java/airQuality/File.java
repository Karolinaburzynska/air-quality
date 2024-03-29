package airQuality;

import java.util.Scanner;

public class File {

    public static String fileLoading(java.io.File file) {

        StringBuilder fileContent = new StringBuilder();

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
                fileContent.append(line);
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Nie znaleziono pliku!");
            e.printStackTrace();
        }
        return fileContent.toString();
    }
}
