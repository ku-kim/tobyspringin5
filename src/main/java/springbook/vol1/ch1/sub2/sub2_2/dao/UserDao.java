package springbook.vol1.ch1.sub2.sub2_2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import springbook.vol1.ch1.sub2.sub2_2.domain.User;

/**
 * JDBC 4.0 이후부터 Class.forName()사용하여 JDBC 드라이버를 로딩할 필요가 없어졌다. 왜냐하면 SPI가 JDBC 드라이버는 자동으로 로딩되기 때문이다.
 * (SPI: Service Provider Interface)
 */
public abstract class UserDao {

	public void add(User user) throws SQLException {
		Connection con = getConnection();

		PreparedStatement ps = con.prepareStatement(
			"insert into users(id, name, password) values(?, ?, ?)");

		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());

		ps.executeUpdate();
		ps.close();
		con.close();
	}

	public User get(String id) throws SQLException {
		Connection con = getConnection();

		PreparedStatement ps = con.prepareStatement("select * from users where id = ?");
		ps.setString(1, id);

		ResultSet rs = ps.executeQuery();
		rs.next();
		User user = new User();
		user.setId(rs.getString("id"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));

		rs.close();
		ps.close();
		con.close();

		return user;
	}

	abstract protected Connection getConnection() throws SQLException;

	public void clean() throws SQLException {
		Connection con = getConnection();

		Statement statement = con.createStatement();
		statement.execute("Truncate table users");
		con.close();
	}

}
