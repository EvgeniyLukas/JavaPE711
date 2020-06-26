package com.company.Lesson5.jdbc;

import com.company.Lesson5.jdbc.utils.ConnectionUrl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * Чтение данных из запроса
 *
 */
public class Task05 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionUrl.getConnection();
		Statement statement = null;
		try {
			statement = connection.createStatement();
			// получения курсора для запроса
			ResultSet resultSet = statement.executeQuery("SELECT * FROM USERS");
			while (resultSet.next()) {
				// получает данные из второго столбца в запросе
				System.out.print(resultSet.getString(2));
				System.out.print(" ");
				// получает данные из столбца с именем login
				System.out.print(resultSet.getString("login"));
				System.out.println();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				statement.close();
			}
			connection.close();
		}
	}
}