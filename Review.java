package app.model;

public class Review {
    private int reviewId;
    private double rating;
    private String comment;
    private String creationDate;
    private int userId;
    private int movieId;

    public Review(int reviewId, double rating, String comment, String creationDate, int userId, int movieId) {
        this.reviewId = reviewId;
        this.rating = rating;
        this.comment = comment;
        this.creationDate = creationDate;
        this.userId = userId;
        this.movieId = movieId;
    }

    public Review(double rating, String comment, String creationDate, int userId, int movieId) {
        this.rating = rating;
        this.comment = comment;
        this.creationDate = creationDate;
        this.userId = userId;
        this.movieId = movieId;
    }

    public int getReviewId() {
        return reviewId;
    }
    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public double getRating() {
        return rating;
    }
    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMovieId() {
        return movieId;
    }
    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    @Override
    public String toString() {
        return "app.model.test.Review id: " + reviewId + ", rating: " + rating + ", comment: " + comment + ", creationDate: " + creationDate + ", userId: " + userId + ", movieId: " + movieId;
    }
}
