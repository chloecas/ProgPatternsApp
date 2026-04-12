public class Movie {
    private int movieId;
    private String title;
    private String description;
    private int releaseYear;
    private double avgRating;
    private String genre;
    private String directorId;

    public Movie(int movieId, String title, String description, int releaseYear, double avgRating, String genre,  String directorId) {
        this.movieId = movieId;
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.avgRating = avgRating;
        this.genre = genre;
        this.directorId = directorId;
    }

    public int getMovieId() {
        return movieId;
    }
    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public int getReleaseYear() {
        return releaseYear;
    }
    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public double getAvgRating() {
        return avgRating;
    }
    public void setAvgRating(double avgRating) {
        this.avgRating = avgRating;
    }

    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirectorId() {
        return directorId;
    }
    public void setDirectorId(String directorId) {
        this.directorId = directorId;
    }

    @Override
    public String toString() {
        return "Movie id: " + movieId + ", title: " + title + ", description: " + description +  ", releaseYear: " + releaseYear + ", avgRating: " + avgRating + ", genre: " + genre +  ", directorId: " + directorId;
    }
}
