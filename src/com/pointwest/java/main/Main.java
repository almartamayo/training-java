package com.pointwest.java.main;

import java.sql.SQLException;

import com.pointwest.java.ui.FilmUI;

public class Main {

	public static String query1 = "Select * from sakila.film";
	public static String query2 = "Select * from sakila.film where film.title = \"zoolander fiction\"; ";
	public static String query3 = "Select * from sakila.film where film.title like ? ; ";
	public static String query4 = "Select * from sakila.film where film.length > ? and film.length < ?; ";

	public static void main(String[] args) throws SQLException {
		FilmUI filmUI = new FilmUI();
		filmUI.getFilms(query4);
		
		
	}

}
