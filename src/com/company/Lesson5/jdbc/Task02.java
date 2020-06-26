package com.company.Lesson5.jdbc;

import com.company.Lesson5.jdbc.utils.ConnectionUrl;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * Получение соеденение 
 *
 */
public class Task02 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
		Connection connection = null;
		try {
			// получение соединения с базой данных
			connection = DriverManager.getConnection(ConnectionUrl.URL);
			System.out.println(connection.getMetaData().getURL());
			
			Statement statement = connection.createStatement();
			// выполнение запроса создающего таблицу пользователей
			statement.execute("CREATE TABLE if not exists 'users' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'login' text, 'password' text);");
			System.out.println("Table users created");
			// выполнение запроса создающего таблицу комментариев
			statement.execute("CREATE TABLE if not exists 'comments' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'id_user' INTEGER, 'comment' text);");
			System.out.println("Table Comments created");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			connection.close();
		}
	}
}