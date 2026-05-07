package app.controller;

import app.DAO.*;
import app.model.AppLocale;
import app.model.Director;
import app.model.Movie;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
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

    @FXML
    Pane actionPane;

    private int movieID;
    private Movie movie;

    RatingsDAO ratingsDAO = new RatingsDAO();
    ReviewsDAO reviewsDAO = new ReviewsDAO();
    DirectorDAO directorDAO = new DirectorDAO();

    public void setMovie(Movie movie) {
        this.movieID = movie.getMovieId();
        this.movie = movie;

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

    @FXML
    public void openMenu() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/app/view/ActionMenu.fxml"), AppLocale.getBundle());
            Parent parent = loader.load();

            ActionMenuController controller = loader.getController();
            controller.setMovie(movie);
            controller.setUser(null);

            Stage stage = new Stage();
            stage.setScene(new Scene(parent));
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
