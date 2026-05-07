package app.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {
    private int userId;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private Date joinDate;

    private List<Movie> watched;
    private List<Movie> wishList;

    public User(int userId,String username, String password, String firstName, String lastName, String email, int age, Date joinDate) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.joinDate = joinDate;

        watched = new ArrayList<Movie>();
        wishList = new ArrayList<Movie>();
    }

    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public Date getJoinDate() {
        return joinDate;
    }
    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public List<Movie> getWatched() {
        return watched;
    }
    public void setWatched(List<Movie> watched) {
        this.watched = watched;
    }

    public List<Movie> getWishList() {
        return wishList;
    }
    public void setWishList(List<Movie> wishList) {
        this.wishList = wishList;
    }

    @Override
    public String toString() {
        return "app.model.test.User id: " + userId + ", username: " + username + ", password: " + password + ", first name: " + firstName;
    }
}
