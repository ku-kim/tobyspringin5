package springbook.vol1.ch1.sub2.sub2_2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class NUserDao extends UserDao {

	@Override
	protected Connection getConnection() throws SQLException {
		Connection con = DriverManager.getConnection(
			"jdbc:mysql://localhost/springbook", "spring", "book");
		return con;

	}
}

