package com.company.Lesson5.jdbc;


import com.company.Lesson5.jdbc.utils.ConnectionUrl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * Удаление таблицы. 
 * ВНИМАНИЕ!!! после запуска все введеные данные будут потеряны.
 *
 */
public class Task11 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionUrl.getConnection();
		Statement statement = null;
		try {
			statement = connection.createStatement();
			statement.execute("DROP TABLE Users");
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