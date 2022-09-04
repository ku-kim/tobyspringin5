package springbook.vol1.ch1.sub5.sub5_1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DConnectionMaker implements ConnectionMaker {

	@Override
	public Connection makeConnection() throws SQLException {
		Connection con = DriverManager.getConnection(
			"jdbc:mysql://localhost/springbook", "spring", "book");
		return con;
	}
}

