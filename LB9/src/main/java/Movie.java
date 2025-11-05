
    public class Movie {
        private String title;
        private int year;
        private String director;
        private double rating;

        public Movie(String title, int year, String director, double rating) {
            this.title = title;
            this.year = year;
            this.director = director;
            this.rating = rating;
        }

        public String getTitle() {
            return title;
        }

        public int getYear() {
            return year;
        }

        public String getDirector() {
            return director;
        }

        public double getRating() {
            return rating;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public void setDirector(String director) {
            this.director = director;
        }

        public void setRating(double rating) {
            this.rating = rating;
        }

        @Override
        public String toString() {
            return String.format("Movie{title='%s', year=%d, director='%s', rating=%.1f}",
                    title, year, director, rating);
        }
    }
