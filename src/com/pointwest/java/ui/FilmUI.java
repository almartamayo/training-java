package com.pointwest.java.ui;


import java.sql.SQLException;

import com.pointwest.java.bean.FilmBean;
import com.pointwest.java.manager.FilmManager;

public class FilmUI {
	FilmManager filmManager = new FilmManager();
	FilmBean filmBeam = new FilmBean();
	
	public void getFilms(String query) throws SQLException {
		
		for(FilmBean film : filmManager.getFilms(query)) {
			System.out.println(film.getTitle() + " "+ film.getDescription()+ " "+film.getLength());
		}
	}
	

}
