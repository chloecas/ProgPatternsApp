package app.controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import app.model.AppLocale;


public class MainFX extends Application {
    public static Stage primaryStage;

    @Override
	public void start(Stage stage) throws Exception {
        primaryStage = stage;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/app/view/HomeWindow.fxml"), AppLocale.getBundle());
        Scene scene = new Scene(loader.load());
        stage.setTitle("Letterboxd");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
