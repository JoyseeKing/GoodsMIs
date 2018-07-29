package tsc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import tsc.dbutil.StringUtil;
import tsc.model.GoodsType;

	public class GoodsTypeDao {
		public int add(java.sql.Connection connection,GoodsType goodsType) throws Exception{
			String sql="insert into goods_type values(null,?,?,?,?,?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, goodsType.getGoodsTypeName());
			preparedStatement.setString(2, goodsType.getGoodsTypeDesc());
			preparedStatement.setString(3, goodsType.getGoodsPrice());
			preparedStatement.setString(4, goodsType.getGoodsProd());
			preparedStatement.setString(5, goodsType.getOprater());
			
			int n=preparedStatement.executeUpdate();
			return n;
			
		}
		public ResultSet list (java.sql.Connection connection,GoodsType goodsType)throws Exception{
			StringBuffer sBuffer=new StringBuffer("SELECT * FROM goods_type");
			if(StringUtil.isNotEmpty(goodsType.getGoodsTypeName())) {
				sBuffer.append(" where goodsName LIKE '%"+goodsType.getGoodsTypeName()+"%'");
			}
			PreparedStatement preparedStatement=connection.prepareStatement(sBuffer.toString());
			return preparedStatement .executeQuery();
		}
		public int delete (java.sql.Connection connection ,String id) throws Exception{
			String sql="delete from goods_type where id=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			return preparedStatement.executeUpdate();
		}
		
		public static   int update(java.sql.Connection connection,GoodsType goodsType)throws Exception{
			int n;
			String sql="update goods_type set goodsName=?,goodsType=?,goodsPrice=?,operater=?,goodsProd=? where id=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, goodsType.getGoodsTypeName());
			preparedStatement.setString(2, goodsType.getGoodsTypeDesc());
			
			preparedStatement.setString(3, goodsType.getGoodsPrice());
			preparedStatement.setString(4, goodsType.getOprater());
			preparedStatement.setString(5, goodsType.getGoodsProd());
			preparedStatement.setInt(6, goodsType.getId());
			n=preparedStatement.executeUpdate();
			return n;
		}
		public static int outinfo (java.sql.Connection connection) throws Exception{
			int n=1;
			if(n==1){
			String sql="SELECT * FROM goods_type INTO OUTFILE 'e:/xinxi.xls'";
			java.sql.Statement statement = connection.createStatement(); 

			ResultSet resultSet = statement.executeQuery(sql);
			
			}
		   return n=0;
		}
}
