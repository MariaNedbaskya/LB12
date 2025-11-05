import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TemperatureApp {

    public static void main(String[] args) {
        String fileName = "temperatures.txt";

        writeTemperaturesToFile(fileName);
        calculateAverageTemperature(fileName);
    }

    private static void writeTemperaturesToFile(String fileName) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите 5 температур:");

        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (int i = 1; i <= 5; i++) {
                System.out.print(i + ". ");

                while (!scanner.hasNextDouble()) {
                    System.out.println("Ошибка! Введите вещественное число (например: 25.5):");
                    scanner.next();
                    System.out.print(i + ". ");
                }

                double temperature = scanner.nextDouble();
                writer.println(temperature);
            }

            System.out.println("Все температуры успешно записаны в: " + fileName);

        } catch (IOException e) {
            System.err.println("Ошибка при записи: " + e.getMessage());
        }
    }

    private static void calculateAverageTemperature(String fileName) {

        List<Double> temperatures = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int lineNumber = 1;

            System.out.println("Считанные температуры:");
            while ((line = reader.readLine()) != null) {
                try {
                    double temperature = Double.parseDouble(line.trim());
                    temperatures.add(temperature);
                    System.out.printf("  %2d: %.1f°C%n", lineNumber, temperature);
                    lineNumber++;
                } catch (NumberFormatException e) {
                    System.err.println("Ошибка формата в строке " + lineNumber + ": " + line);
                }
            }

        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
            return;
        }

        if (temperatures.size() < 5) {
            System.out.println("Внимание: считано только " + temperatures.size() + " значений из 15");
        }

        if (temperatures.isEmpty()) {
            System.out.println("Не удалось считать ни одного значения температуры");
            return;
        }

        double sum = 0;

        for (double temp : temperatures) {
            sum += temp;
        }
        double average = sum / 5;

        System.out.printf("Количество считанных температур: %d%n", temperatures.size());
        System.out.printf("Сумма всех температур: %.1f°C%n", sum);
        System.out.printf("средняя температура: %.2f°C%n", average);
    }
}