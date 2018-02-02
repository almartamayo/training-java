package com.pointwest.java.manager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.pointwest.java.bean.FilmBean;
import com.pointwest.java.dao.FilmDao;

public class FilmManager {
	FilmDao filmDao = new FilmDao();
	FilmBean filmBeam = new FilmBean();

	public List<FilmBean> getFilms(String Query) throws SQLException {
		return filmDao.getFilms();
	}
	

}
