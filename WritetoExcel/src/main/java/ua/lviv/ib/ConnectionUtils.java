package ua.lviv.ib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {

	public static String URL = "jdbc:sqlserver://miscoutserver2015-test:1444;database=MiscoutBPU;integratedSecurity=false";
	public static String NAME = "miscout";
	public static String PASSWORD = "gwrules";

	public static Connection openConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return DriverManager.getConnection(URL, NAME, PASSWORD);
	}
}
