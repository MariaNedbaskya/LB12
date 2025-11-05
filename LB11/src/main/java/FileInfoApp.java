import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class FileInfoApp {

    public static void main(String[] args) {
        String fileName = "my_info.txt";

        try {
            Path filePath = getFilePathFromResources(fileName);

            System.out.println("инфо файла:");
            displayFileInfo(filePath);

            System.out.println("\nсодержимое файла:");
            readWithBufferedReader(filePath);

        } catch (IOException e) {
            System.err.println("Ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static Path getFilePathFromResources(String fileName) throws IOException {
        Path resourcesPath = Paths.get("src", "main", "resources", fileName);

        if (Files.exists(resourcesPath)) {
            return resourcesPath;
        }
        return null;
    }

    private static void displayFileInfo(Path filePath) throws IOException {
        if (!Files.exists(filePath)) {
            System.out.println("Файл не существует по пути: " + filePath.toAbsolutePath());
            return;
        }

        BasicFileAttributes attrs = Files.readAttributes(filePath, BasicFileAttributes.class);
        System.out.println("Имя файла: " + filePath.getFileName());
        System.out.println("Абсолютный путь: " + filePath.toAbsolutePath());
        System.out.println("Размер: " + attrs.size() + " байт");
        System.out.println("Дата создания: " + attrs.creationTime());
    }

    private static void readWithBufferedReader(Path filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath.toFile()))) {
            String line;
            int lineNumber = 1;
            while ((line = reader.readLine()) != null) {
                System.out.println("  " + lineNumber + ": " + line);
                lineNumber++;
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении BufferedReader: " + e.getMessage());
        }
    }

}
