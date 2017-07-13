package daoUtil;

public class LoadDriver {

	private LoadDriver() {
	}
	/***
	 * Loading MySql JDBC Driver
	 */
	public static void loadDriver(){

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(" Class.forName Exception "+e);
		}
	}
}
