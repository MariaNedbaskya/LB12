
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Movie> movieMap = new HashMap<>();

        movieMap.put("The Matrix", new Action("The Matrix", 1999, "Lana Wachowski", 8.7, 15, "Bullet time"));
        movieMap.put("John Wick", new Movie("John Wick", 2014, "Chad Stahelski", 7.4));
        movieMap.put("The Godfather", new Drama("The Godfather", 1972, "Francis Ford Coppola", 9.2, "Crime family", true));

        System.out.println("Выводим все ключи (названия фильмов)");
        for (String title : movieMap.keySet()) {
            System.out.println(title);
        }

        System.out.println("\nПодробная информация о фильмах");
        for (Map.Entry<String, Movie> entry : movieMap.entrySet()) {
            System.out.println("Ключ: " + entry.getKey());
            System.out.println("Значение: " + entry.getValue());
            System.out.println();
        }
    }
}