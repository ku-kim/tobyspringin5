package springbook.vol1.ch1.sub3.sub3_3.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionMaker {

	public Connection makeConnection() throws SQLException;

}

