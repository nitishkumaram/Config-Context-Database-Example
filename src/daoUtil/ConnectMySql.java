package daoUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectMySql {

	private static Connection connection=null;
	//private constructor
	private ConnectMySql() {
	}
	/***
	 * Based on Database name Connection is returned using SINGLETON pattern
	 * @param dbName
	 * @return Connection
	 */
	public static Connection getConnection(String dbName,String userName,String password)
	{
		if(connection==null){					//Singleton achieved
			LoadDriver.loadDriver();
			String url="jdbc:mysql://localhost:3306/"+dbName;
			try {
				connection=DriverManager.getConnection(url,userName,password);
			} catch (SQLException e) {
				System.out.println(" Database Not Found / Not Been Created "+e);
			}
		}
		return connection;
	}
	/***
	 * This method close the connection
	 * @param connection
	 */
	public static void close(Connection connection)
	{
		try {
			connection.close();
		} catch (SQLException e) {
			System.out.println(" Connection close error "+e);
		}
	}
}
