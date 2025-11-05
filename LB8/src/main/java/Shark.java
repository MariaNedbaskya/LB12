public class Shark implements MarineAnimal, MarineAnimal2 {

    @Override
    public void move() {
        System.out.println(" Акула плавает быстро ");
    }

    @Override
    public void swim() {
        System.out.println(" Акула плавает быстро и агрессивно, рассекая воду");
    }

    public void hunt() {
        System.out.println(" Акула охотится на других рыб");
    }

    public void breathe() {
        System.out.println(" Акула дышит через жабры");
    }
}