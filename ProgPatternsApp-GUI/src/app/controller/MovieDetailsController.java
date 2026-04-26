package app.controller;

import app.DAO.*;
import app.model.Director;
import app.model.Movie;
import javafx.fxml.FXML;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;

import java.io.File;
import java.util.*;


public class MovieDetailsController {
    @FXML
    TextArea movieDescription;

    @FXML
    TextArea directorBio;

    @FXML
    ListView<String> ratingsListView;

    @FXML
    ListView<String> reviewsListView;

    @FXML
    ImageView moviePoster;

    @FXML
    Label movieTitle;

    private int movieID;
    private Movie movie;

    MovieDAO movieDAO = new MovieDAO();
    RatingsDAO ratingsDAO = new RatingsDAO();
    ReviewsDAO reviewsDAO = new ReviewsDAO();
    DirectorDAO directorDAO = new DirectorDAO();

    public void setMovie(Movie movie) {
        this.movieID = movie.getMovieId();

        movieTitle.setText(movie.getTitle());
        movieDescription.setText(movie.getDescription());
        String path = movie.getImagePath();
        moviePoster.setImage(new Image(new File(path).toURI().toString()));

        Director dir = directorDAO.getDirectorByMovie(movieID);
        directorBio.setText(dir.toString());

        Map<String, Double> ratings = ratingsDAO.getRatingsByMovie(movieID);
        ratingsListView.getItems().clear();

        for(Map.Entry<String, Double> entry: ratings.entrySet()){
            ratingsListView.getItems().add(
                    entry.getKey() + " - " + entry.getValue()
            );
        }

        List<String> reviews = reviewsDAO.getReviewsByMovie(movieID);
        reviewsListView.getItems().clear();
        reviewsListView.getItems().addAll(reviews);
    }
}
