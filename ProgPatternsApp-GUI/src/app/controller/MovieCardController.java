package app.controller;

import app.model.Movie;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class MovieCardController {
    @FXML
    private ImageView poster;

    @FXML
    private Label titleLabel;

    @FXML
    private Label ratingLabel;

    private Movie movie;

    private int movieID;


    public void setMovie(Movie movie){
        this.movie = movie;
        movieID = movie.getMovieId();

        titleLabel.setText(movie.getTitle());
        ratingLabel.setText(String.valueOf(movie.getAvgRating()));

        String path = movie.getImagePath();
        poster.setImage(new Image(new File(path).toURI().toString()));
    }

    @FXML
    private void initialize() {
        poster.getParent().setOnMouseClicked(e -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/app/view/MovieDetails.fxml"));
                Parent parent = loader.load();

                MovieDetailsController controller = loader.getController();
                controller.setMovie(movie);

                Stage stage = new Stage();
                stage.setScene(new Scene(parent));
                stage.setTitle("Movie Details");
                stage.show();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
}
