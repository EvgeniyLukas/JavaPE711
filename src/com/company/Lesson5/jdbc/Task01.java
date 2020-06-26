package com.company.Lesson5.jdbc;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * Регистрация драйвера
 *
 */
public class Task01 {
	public static void main(String[] args) {

		// первый способ
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// второй способ
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
