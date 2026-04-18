package test;

public class Review {
    private String reviewId;
    private double rating;
    private String comment;
    private String creationDate;
    private String userId;
    private String movieId;

    public Review(String reviewId, double rating, String comment, String creationDate, String userId, String movieId) {
        this.reviewId = reviewId;
        this.rating = rating;
        this.comment = comment;
        this.creationDate = creationDate;
        this.userId = userId;
        this.movieId = movieId;
    }

    public String getReviewId() {
        return reviewId;
    }
    public void setReviewId(String reviewId) {
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

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMovieId() {
        return movieId;
    }
    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    @Override
    public String toString() {
        return "test.Review id: " + reviewId + ", rating: " + rating + ", comment: " + comment + ", creationDate: " + creationDate + ", userId: " + userId + ", movieId: " + movieId;
    }
}
