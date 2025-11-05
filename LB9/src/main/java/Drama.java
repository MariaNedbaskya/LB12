
public class Drama extends Movie {
    private String mainTheme;
    private boolean isTragic;

    public Drama(String title, int year, String director, double rating,
                 String mainTheme, boolean isTragic) {
        super(title, year, director, rating);
        this.mainTheme = mainTheme;
        this.isTragic = isTragic;
    }

    public String getMainTheme() {
        return mainTheme;
    }

    public boolean isTragic() {
        return isTragic;
    }

    public void setMainTheme(String mainTheme) {
        this.mainTheme = mainTheme;
    }

    public void setTragic(boolean tragic) {
        isTragic = tragic;
    }

    @Override
    public String toString() {
        return String.format("Drama{%s, mainTheme='%s', isTragic=%s}",
                super.toString(), mainTheme, isTragic);
    }
}