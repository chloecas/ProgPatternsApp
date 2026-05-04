package app.controller;

import app.DAO.MovieDAO;
import app.model.AppLocale;
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
import java.util.Locale;
import java.util.ResourceBundle;

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
    MenuItem closeItem, frenchLocale, englishLocale;

    private ResourceBundle bundle;
    
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/app/view/MovieCard.fxml"), AppLocale.getBundle());
        Parent parent = loader.load();
        this.controller = loader.getController();
        this.controller.setMovie(topMovies.get(index));

        pane.getChildren().add(parent);
    }

    @FXML
    public void handleLogin() {
       try {
           FXMLLoader loader = new FXMLLoader(getClass().getResource("/app/view/Login.fxml"), AppLocale.getBundle());
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
        String message = AppLocale.getBundle().getString("main.aboutmessage");

        Alert info = new Alert(Alert.AlertType.NONE, message, ButtonType.CLOSE);
        info.setTitle(AppLocale.getBundle().getString("main.menuitemabout"));
        info.show();
    }

    @FXML
    public void changeLocale(ActionEvent event){
        MenuItem item = (MenuItem) event.getSource();
        String lang = item.getUserData().toString();

        String[] parts = lang.split("_");
        Locale locale = new Locale(parts[0], parts[1]);

        AppLocale.setLocale(locale);

         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/app/view/HomeWindow.fxml"), AppLocale.getBundle());
            Scene scene = new Scene(loader.load());
            MainFX.primaryStage.setScene(scene);
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
