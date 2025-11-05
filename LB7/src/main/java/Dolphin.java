public class Dolphin extends MarineAnimal {

    @Override
    public void swim() {
        System.out.println("Дельфин плавает грациозно и быстро");
    }

    @Override
    public void breathe() {
        System.out.println("Дельфин дышит воздухом через дыхало");
    }

    public void jump() {
        System.out.println("Дельфин прыгает над водой");
    }
}