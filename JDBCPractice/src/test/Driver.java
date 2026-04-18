package test;

import java.sql.*;

public class Driver {

	public static void main(String[] args) {
		try {
			
			Connection myCon = DriverManager.getConnection("jdbc:sqlite:MovieReviewApp.db");
			
			Statement mySt = myCon.createStatement();
			
			ResultSet myRs = mySt.executeQuery("select * from Movies");
			
			while(myRs.next()) {
				System.out.println(myRs.getString("movieTitle") + ", " + myRs.getInt("releaseYear"));
			}
			
			System.out.println();
			
			Statement st2 = myCon.createStatement();
			ResultSet res2 = st2.executeQuery("select * from Users");
			
			while(res2.next()) {
				System.out.println(res2.getString("username") +  ", joined on: " + res2.getString("joinDate"));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
