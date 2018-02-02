package com.pointwest.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.pointwest.java.bean.FilmBean;
import com.pointwest.java.main.Main;

public class FilmDao {
	Logger logger = Logger.getLogger(FilmDao.class);
	List<FilmBean> filmList;

	public Connection getConnection() throws Exception {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dbUrl = "jdbc:mysql://172.26.83.193:3306/sakila";
			String user = "newuser";
			String password = "password123";
			// DriverManager.getConnection(dbUrl, user, password);

			conn = DriverManager.getConnection(dbUrl, user, password);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return conn;
	}
	
	public void closeConnection(Connection conn, Statement ps, ResultSet rs) throws SQLException {
		if(conn != null) {
			conn.close();
		}
		if(ps != null) {
			ps.close();
		}
		if(rs != null) {
			rs.close();
		}
	}

	public List<FilmBean> getFilms() throws SQLException{
		FilmDao filmDao = new FilmDao();
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			conn = filmDao.getConnection();
			PreparedStatement statement = conn.prepareStatement(Main.query4);
			// Statement statement = conn.createStatement();
			// statement.setString(1, "%the%");
			statement.setString(1, "'100'");
			statement.setInt(2, 150);
			rs = statement.executeQuery();
			filmList = new ArrayList<FilmBean>();
			while (rs.next()) {
				FilmBean film = new FilmBean();
				film.setTitle(rs.getString("title"));
				film.setDescription(rs.getString("description"));
				film.setLength(rs.getString("length"));

				filmList.add(film);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}finally {
			closeConnection(conn,ps,rs);
		}
		return filmList;
	}
}
