package testCSV;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
class Util
{
	private static Connection con;
	static
	{
		Properties pr = new Properties();
		try(FileReader fin = new FileReader("C:\\Users\\c5292542\\Documents\\Java\\db.properties"))
		{
			pr.load(fin);
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
		String driverClass = pr.getProperty("driverClass");
		String url = pr.getProperty("url");
		String username = pr.getProperty("user");
		String password = pr.getProperty("pwd");
		try
		{
			Class.forName(driverClass);
		}
		catch (ClassNotFoundException ex)
		{
			ex.printStackTrace();
		}
		try
		{ 
			con = DriverManager.getConnection(url, username, password);
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
	}//sib end
	public static Connection getConnection()
	{
		return con;
	}
}

