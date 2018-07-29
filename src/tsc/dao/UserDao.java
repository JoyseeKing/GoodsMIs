package tsc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import tsc.model.User;

public class UserDao {
	public static User login(java.sql.Connection connection,User user)throws Exception{
		User resultUser=null;
		String sql="SELECT * from goods_user where username=? and password=?";
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setString(1, user.getUsername());
		preparedStatement.setString(2, user.getPassword());
		
		ResultSet rSet=preparedStatement.executeQuery();
		while(rSet.next()) {
			resultUser=new User();
			resultUser.setUsername(rSet.getString("username"));
			resultUser.setUsername(rSet.getString("password"));
			resultUser.setId(rSet.getInt("id"));
		}
		return resultUser;
		}

}
