package tsc.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	private String dbUrl="jdbc:mysql://localhost:3306/dbgoods?useUnicode=true&characterEncoding=UTF-8";
	private String dbUser="root";
	private String dbPassword="123456";
	private String jdbc="com.mysql.jdbc.Driver"; 

	public Connection getConnection() throws Exception{
		Class.forName(jdbc);
		Connection connection=DriverManager.getConnection(dbUrl, dbUser, dbPassword);
		return connection;
	} 
	public static void main(String[] args)  {
		DbUtil dbUtil=new DbUtil();
		Connection connection=null;
		try {
			connection=dbUtil.getConnection();
			if (connection!=null) {
				System.out.println("连接成功");
			}
			
		} catch (Exception e){
			// TODO: handle finally clause
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
