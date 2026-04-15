package app.model;

public class Rating {
	private int ratingId;
	private int movieId;
	private int userId;
	private double rating;
	
	public Rating(int ratingId, int movieId, int userId, double rating) {
		this.ratingId = ratingId;
		this.movieId = movieId;
		this.userId = userId;
		this.rating = rating;
	}

	public int getRatingId() {
		return ratingId;
	}

	public void setRatingId(int ratingId) {
		this.ratingId = ratingId;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Rating " + ratingId + ", movieId=" + movieId + ", userId=" + userId + ", rating=" + rating;
	}
}
