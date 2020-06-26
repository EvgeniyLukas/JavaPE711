package com.company.Lesson5.jdbc;

import com.company.Lesson5.jdbc.utils.ConnectionUrl;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 
 * Обнавление данных в таблице
 *
 */
public class Task09 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionUrl.getConnection();
		// FIXME выведите все комментарии пользователей
		// FIXME выведите комментарии пользователей которые содержать слово like
	}
}