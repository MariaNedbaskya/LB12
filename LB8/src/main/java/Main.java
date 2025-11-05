public class Main {
    public static void main(String[] args) {

        MarineAnimal[] animals = {
                new Shark(),
                new Dolphin(),
        };

        System.out.println("1. Полиморфизм через интерфейс:");
        for (MarineAnimal animal : animals) {
            animal.swim();
            System.out.println(" ");
        }

        System.out.println("\n2. Отдельное использование классов:");

        Shark shark = new Shark();
        Dolphin dolphin = new Dolphin();

        shark.swim();
        shark.hunt();
        shark.breathe();

        System.out.println();

        dolphin.swim();
        dolphin.jump();
        dolphin.breathe();
        dolphin.play();

        System.out.println("\n3. Приведение типов:");
        MarineAnimal marineAnimal1 = new Shark();
        MarineAnimal marineAnimal2 = new Dolphin();

        marineAnimal1.swim();
        marineAnimal2.swim();

        if (marineAnimal1 instanceof Shark) {
            Shark concreteShark = (Shark) marineAnimal1;
            concreteShark.hunt();
        }

        if (marineAnimal2 instanceof Dolphin) {
            Dolphin concreteDolphin = (Dolphin) marineAnimal2;
            concreteDolphin.jump();
        }
    }
}