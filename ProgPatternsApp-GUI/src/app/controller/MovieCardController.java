package app.controller;

import app.model.Movie;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MovieCardController {
    @FXML
    private ImageView poster;

    @FXML
    private Label titleLabel;

    @FXML
    private Label ratingLabel;

    private Movie movie;

    public void setMovie(Movie movie){
        this.movie = movie;

        titleLabel.setText(movie.getTitle());
        ratingLabel.setText(String.valueOf(movie.getAvgRating()));
        poster.setImage(new Image(movie.getImagePath()));
    }

    @FXML
    private void initialize() {
        poster.getParent().setOnMouseClicked(e -> openDetails());
    }

    private void openDetails() {

    }

}
