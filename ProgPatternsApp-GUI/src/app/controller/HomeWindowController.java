package app.controller;

import app.DAO.MovieDAO;
import app.model.Movie;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class HomeWindowController {

    @FXML
    Button acountButton;

    @FXML
    Pane topMoviePane, topMoviePane2, topMoviePane3;

    @FXML
    Button nextButton;

    @FXML
    Button prevButton;

    @FXML
    MenuItem closeItem;

    MovieDAO movieDAO = new MovieDAO();

    MovieCardController controller;

    private List<Movie> topMovies;

    private int currentIndex = 0;

    @FXML
    public void initialize() throws IOException {
        topMovies = movieDAO.getTopMovies();

        loadMovie(topMoviePane,0);
        loadMovie(topMoviePane2,1);
        loadMovie(topMoviePane3,2);
    }

    @FXML
    private void loadMovie(Pane pane, int index) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/app/view/MovieCard.fxml"));
        Parent parent = loader.load();
        this.controller = loader.getController();
        this.controller.setMovie(topMovies.get(index));

        pane.getChildren().add(parent);
    }

    @FXML
    public void handleLogin() {
       try {
           FXMLLoader loader = new FXMLLoader(getClass().getResource("/app/view/Login.fxml"));
           Parent parent = loader.load();

           Stage stage = new Stage();
           stage.setScene(new Scene(parent));
           stage.setTitle("My Account");
           stage.show();
       } catch (Exception e) {
           e.printStackTrace();
       }
    }

    @FXML
    public void nextMovie() throws IOException {
        if(currentIndex + 3 < topMovies.size()){
            currentIndex++;
            loadMovie(topMoviePane, currentIndex);
            loadMovie(topMoviePane2, currentIndex + 1);
            loadMovie(topMoviePane3, currentIndex + 2);
        }
    }

    @FXML
    public void prevMovie() throws IOException {
        if(currentIndex > 0){
            currentIndex--;
            loadMovie(topMoviePane, currentIndex);
            loadMovie(topMoviePane2, currentIndex + 1);
            loadMovie(topMoviePane3, currentIndex + 2);
        }
    }

    @FXML
    public void close(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    public void about(ActionEvent event) {
        Alert info = new Alert(Alert.AlertType.NONE, """
                This application is meant to simulate a website where users
                can browse a predefined catalogue of movies and rate /review them.
                
                Users with accounts can leave comments and follow their friends to see what movies others have been enjoying recently.""", ButtonType.CLOSE);
        info.show();
    }
}
