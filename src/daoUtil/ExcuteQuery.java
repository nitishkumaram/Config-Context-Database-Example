package daoUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ExcuteQuery {
	//Private Constructor
	private ExcuteQuery() {
	}

	/***
	 * This Method will display result of particular field using SELECT query 
	 * based on table name and connection passed as an argument
	 * @param tableName
	 * @param field
	 * @param connection
	 * @param value
	 */
	public static boolean selectQuery(String tableName,String field,Connection connection,String value)
	{	
		ResultSet rs=null;
		Statement st=null;
		boolean flag=false;
		try {
			if(doTableExists(tableName, connection))
			{	

				st=connection.createStatement();
				String query="select * from "+tableName;

				rs=st.executeQuery(query);
				while(rs.next())
					if(rs.getString(field).equalsIgnoreCase(value)){
						flag=true;
						break;
					}
			}
			else
				flag=false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			try {
				rs.close();
				st.close();
			} catch (SQLException e) {
				System.out.println("close error "+e);
			}catch(NullPointerException e){}
		
		}
		return flag;
	}
/***
 * Check whether Table exists in database
 * @param tableName
 * @param connection
 * @return boolean true if table found or false if not found
 */
	public static boolean doTableExists(String tableName,Connection connection)
	{
		ResultSet rs=null;
		try {
			Statement st=connection.createStatement();

			String tableExistsQuery=" show tables like '"+tableName+"'";
			rs=st.executeQuery(tableExistsQuery);

			try {
				while(rs.next())
					if(rs.getString(1).isEmpty())
						return false;
					else
						return true;
			} catch (SQLException e) {
				System.out.println(" Table Exists error "+e);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return false;
	}

}


