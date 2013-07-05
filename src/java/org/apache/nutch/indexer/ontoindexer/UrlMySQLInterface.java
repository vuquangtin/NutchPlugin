package org.apache.nutch.indexer.ontoindexer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UrlMySQLInterface {

	private static UrlMySQLInterface mySqlInterface = null;
	private String url = null;
	private String user = null;
	private String password = null;
	private Connection con = null;
	private Statement st = null;
	private ResultSet rs = null;

	public static UrlMySQLInterface getinstance() {
		if (mySqlInterface == null) {
			mySqlInterface = new UrlMySQLInterface();
		}
		return mySqlInterface;
	}

	private UrlMySQLInterface() {
		url = "jdbc:mysql://" + Configuration.urlDBServerIp + ":" + Configuration.urlDBServerPort
				+ "/" + Configuration.urlDBName;
		user = Configuration.urlDBUser;
		password = Configuration.urlDBPassword;

	}

	private void openConnection() throws SQLException {
		con = DriverManager.getConnection(url, user, password);
		st = con.createStatement();
	}

	private void closeConnection() throws SQLException {
		if (rs != null) {
			rs.close();
		}
		if (st != null) {
			st.close();
		}
		if (con != null) {
			con.close();
		}
	}

	public void addUrl(String url){
		try {
			openConnection();
			
			String query = "SELECT url FROM Website WHERE url=\"" + url + "\"";
			rs = st.executeQuery(query);
			if(rs.next()){
				query = "UPDATE Website SET booking=FALSE, date_of_booking=DEFAULT";
			}
			else{
				query = "INSERT INTO Website VALUES (\"" + url + "\", " + "FALSE" + ", DEFAULT)";
			}
			st.executeUpdate(query);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			closeConnection();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
