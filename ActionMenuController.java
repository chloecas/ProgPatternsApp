package app.controller;

import app.DAO.RatingsDAO;
import app.DAO.ReviewsDAO;
import app.DAO.UserDAO;
import app.model.Movie;
import app.model.Rating;
import app.model.Review;
import app.model.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;

import java.sql.SQLException;
import java.time.LocalDateTime;

public class ActionMenuController {

    @FXML
    Button doneButton;

    @FXML
    Button watchButton;

    @FXML
    Button watchListButton;

    @FXML
    TextArea reviewTextArea;

    @FXML
    Slider ratingSlider;

    UserDAO userDAO = new UserDAO();
    User user;
    Movie movie;
    Rating rating;
    Review review;

    RatingsDAO ratingsDAO = new RatingsDAO();
    ReviewsDAO reviewsDAO = new ReviewsDAO();


    public void setMovie(Movie movie){
        this.movie = movie;
    }

    public void setUser(User user){
        this.user = user;
    }

    @FXML
    public void addToJournal() {
        if(user == null || movie == null) {
            return;
        }

        if(!user.getWatched().contains(movie)) {
            user.getWatched().add(movie);
        }
    }

    @FXML
    public void submitReview() throws SQLException {
        String rvw = reviewTextArea.getText();
        double rt = ratingSlider.getValue();

        rating = new Rating(movie.getMovieId(), user.getUserId(), rt);
        ratingsDAO.createRating(rating);

        review = new Review(rt, rvw, String.valueOf(LocalDateTime.now()), user.getUserId(), movie.getMovieId());
        reviewsDAO.createReview(review);
    }

    @FXML
    public void addWatchList() {
        if(user == null || movie == null){
            return;
        }

        if(!user.getWishList().contains(movie)){
            user.getWishList().add(movie);
        }
    }
}
