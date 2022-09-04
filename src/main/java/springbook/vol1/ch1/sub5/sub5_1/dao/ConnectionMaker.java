package springbook.vol1.ch1.sub5.sub5_1.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionMaker {

	public Connection makeConnection() throws SQLException;

}

