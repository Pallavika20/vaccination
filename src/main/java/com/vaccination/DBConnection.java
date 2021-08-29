package com.vaccination;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class DBConnection {
	private static Connection connection;

	public static void register(String query) {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/FjwYt5GCC8", "FjwYt5GCC8",
					"THM4XRxGFy");
//    		String query = "INSERT INTO UserDetails(id, userName, phoneNumber) Values("+user.getId()+","+user.getUserName()+","+user.getPhoneNumber()+")";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.executeUpdate();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String getVaccinationDetails(String name) throws SQLException {
		String query = "SELECT * FROM UserDetails WHERE userName = " + name;
		PreparedStatement statement = connection.prepareStatement(query);
		ResultSet res = statement.executeQuery(query);
		return res.getInt("id") + "   |   " + res.getString("userName") + "   |   " + res.getInt("phoneNumber");
	}

	public static List<String> users(String query) {
		try {
			List<String> list = new ArrayList<String>();
			connection = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/FjwYt5GCC8", "FjwYt5GCC8",
					"THM4XRxGFy");
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet res = statement.executeQuery(query);
			while (res.next()) {
				list.add(res.getString("userName"));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
