
public class Action extends Movie {
    private int explosionCount;
    private String mainStunt;

    public Action(String title, int year, String director, double rating,
                  int explosionCount, String mainStunt) {
        super(title, year, director, rating);
        this.explosionCount = explosionCount;
        this.mainStunt = mainStunt;
    }

    public int getExplosionCount() {
        return explosionCount;
    }

    public String getMainStunt() {
        return mainStunt;
    }

    public void setExplosionCount(int explosionCount) {
        this.explosionCount = explosionCount;
    }

    public void setMainStunt(String mainStunt) {
        this.mainStunt = mainStunt;
    }

    @Override
    public String toString() {
        return String.format("Action{%s, explosionCount=%d, mainStunt='%s'}",
                super.toString(), explosionCount, mainStunt);
    }
}