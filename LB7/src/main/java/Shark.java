public class Shark extends MarineAnimal implements MarineAnimal2 {

    @Override
    public void move() {
        System.out.println("Акула плавает ");
    }

    @Override
    public void swim() {
        System.out.println("Акула плавает быстро и агрессивно");
    }

    @Override
    public void breathe() {
        System.out.println("Акула дышит через жабры");
    }

    public void hunt() {
        System.out.println("Акула охотится на других рыб");
    }
}