public class Main {
    public static void main(String[] args) {
        MarineAnimal[] animals = {
                new Shark(),
                new Dolphin(),
        };

        System.out.println("Демонстрация плавания морских животных");
        for (MarineAnimal animal : animals) {
            animal.swim();
            animal.breathe();

            if (animal instanceof Shark) {
                ((Shark) animal).hunt();
            } else if (animal instanceof Dolphin) {
                ((Dolphin) animal).jump();
            }

            System.out.println(" ");
        }

        System.out.println("\nОтдельное использование");
        Shark shark = new Shark();
        Dolphin dolphin = new Dolphin();

        shark.swim();
        dolphin.swim();
    }
}