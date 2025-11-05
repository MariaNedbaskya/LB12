public abstract class MarineAnimal {

    private String name;

    public MarineAnimal(String name){
        this.name = name;
    }

    public MarineAnimal(){

    }

    public abstract void swim();

    public void breathe() {
        System.out.println("Дышит воздухом или через жабры");
    }

}