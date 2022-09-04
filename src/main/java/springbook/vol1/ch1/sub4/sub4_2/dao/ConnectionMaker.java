package springbook.vol1.ch1.sub4.sub4_2.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionMaker {

	public Connection makeConnection() throws SQLException;

}

