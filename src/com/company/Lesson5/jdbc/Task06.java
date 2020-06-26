package com.company.Lesson5.jdbc;

import com.company.Lesson5.jdbc.utils.ConnectionUrl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * 
 * Подготовленный запрос с параметрами
 *
 */
public class Task06 {
	public static void main(String[] args) throws ClassNotFoundException,
            SQLException {
		Connection connection = ConnectionUrl.getConnection();
		String query = "SELECT login, password FROM users WHERE login LIKE ?";
		PreparedStatement statement = null;
		Scanner scanner = new Scanner(System.in);
		String like = "";
		try {
			statement = connection.prepareStatement(query);
			do {
				System.out.println("Введите часть искомого слова");
				like = scanner.nextLine();
				statement.setString(1, "%" + like + "%"); // установка параметра
				ResultSet rs = statement.executeQuery(); // переиспользование запроса
				while (rs.next()) {
					System.out.println(rs.getString(1) + " " + rs.getString(2));
				}
			} while (!like.isEmpty());
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