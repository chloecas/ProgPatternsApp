package app.controller;

import app.DAO.RatingsDAO;
import app.DAO.ReviewsDAO;
import app.DAO.UserDAO;
import app.model.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class UserPortalController {
    @FXML
    Button manageAccountButton;

    @FXML
    Pane moviePane;

    @FXML
    ListView userDetailsList;

    @FXML
    ListView userReviewsList;

    @FXML
    Label movieCount;

    private ReviewsDAO reviewDAO = new ReviewsDAO();
    private int userID;
    private MovieCardController controller = new MovieCardController();
    private RatingsDAO ratingsDAO = new RatingsDAO();

    @FXML
    public void editUser() {

    }

    private void setUser(User user){
        this.userID = user.getUserId();

        List<String> reviews = reviewDAO.getReviewsByUser(userID);
        userReviewsList.getItems().clear();
        userReviewsList.getItems().addAll(reviews);



    }

    private void topMovies(){
        Map<Integer, Double> ratings = ratingsDAO.getRatingsByUser(userID);
        

    }


}
