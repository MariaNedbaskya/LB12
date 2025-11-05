import java.io.*;
import java.util.Scanner;

public class TextReplacementApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String resourcesPath = "src/main/resources/";
        String inputFile = resourcesPath + "my_info.txt";
        String outputFile = resourcesPath + "my_info2.txt";

        File file = new File(inputFile);
        if (!file.exists()) {
            System.out.println("Файл my_info.txt не найден");
            return;
        }

        System.out.println("Файл для обработки: " + inputFile);
        System.out.print("Какое слово заменить? ");
        String oldWord = scanner.nextLine();

        System.out.print("На какое слово заменить? ");
        String newWord = scanner.nextLine();

        try {
            StringBuilder content = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
                reader.close();
            }

            String originalText = content.toString();
            String newText = originalText.replace(oldWord, newWord);

            try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {
                writer.print(newText);
            }

            System.out.println("Новый файл: " + outputFile);
            System.out.println("\nИзменения:");
            System.out.println("БЫЛО: " + originalText.split("\n")[0]);
            System.out.println("СТАЛО: " + newText.split("\n")[0]);

        } catch (IOException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}