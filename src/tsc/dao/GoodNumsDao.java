package tsc.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;

import tsc.dbutil.StringUtil;
import tsc.model.Getid;
import tsc.model.GoodsNum2;
import tsc.model.GoodsType;
import tsc.model.Goodsin_Num;
import tsc.model.Goodsout_Num;
import tsc.model.InAndOutset0;

	public class GoodNumsDao {
		public static   int add(java.sql.Connection connection,GoodsNum2 goodsNum2) throws Exception{
			String sql="insert into goods_info values(null,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,goodsNum2.getGoodsName());
			preparedStatement.setInt(2, goodsNum2.getGoodsNum());
			preparedStatement.setFloat(3,goodsNum2.getGoodsPrice());
			preparedStatement.setInt(4,goodsNum2.getIn_Num());
			preparedStatement.setInt(5,goodsNum2.getOut_Num());
			preparedStatement.setString(6,goodsNum2.getManager());
			preparedStatement.setFloat(7,goodsNum2.getTotalPrice());
			
			int n=preparedStatement.executeUpdate();
			return n;
			
		}
		public static ResultSet list (java.sql.Connection connection,GoodsNum2 goodsNum2)throws Exception{
			StringBuffer sBuffer=new StringBuffer("SELECT * FROM goods_info");
			if(StringUtil.isNotEmpty(goodsNum2.getGoodsName())) {
				sBuffer.append(" where goodsName LIKE '%"+goodsNum2.getGoodsName()+"%'");
			}
			PreparedStatement preparedStatement=connection.prepareStatement(sBuffer.toString());
			return preparedStatement .executeQuery();
		}	
		public static    int update(java.sql.Connection connection,Goodsin_Num goodsin_Num)throws Exception{
			int n;
			String sql="update goods_info set in_num=? where id=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
		;
			preparedStatement.setInt(1,goodsin_Num.getIn_Num());
			preparedStatement.setInt(2,goodsin_Num.getId());
		
			n=preparedStatement.executeUpdate();
			return n;
		}
		public static    int update2(java.sql.Connection connection,Goodsout_Num goodsout_Num)throws Exception{
			int n;
			String sql="update goods_info set out_num=? where id=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
		
			preparedStatement.setInt(1,goodsout_Num.getOut_Num());
			preparedStatement.setInt(2,goodsout_Num.getId());
		
			n=preparedStatement.executeUpdate();
			return n;
		}
		public static int refresh (java.sql.Connection connection,Getid getid) throws Exception{
			int n;
			
			String sql="UPDATE goods_info set goodsNum= goodsNum + in_num - out_num where id=?";
			
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1,getid.getId());
			
			n=preparedStatement.executeUpdate();
			
		   return n;
		}
		public static    int set0(java.sql.Connection connection,InAndOutset0 inAndOutset0)throws Exception{
			int n;
			String sql="update goods_info set in_num=?,out_num=? where id=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
		
			preparedStatement.setInt(1,inAndOutset0.getIn_Num());
			preparedStatement.setInt(2,inAndOutset0.getOut_Num());
			preparedStatement.setInt(3,inAndOutset0.getId());
		
			n=preparedStatement.executeUpdate();
			return n;
		}
		public static int totalpricerefresh (java.sql.Connection connection,Getid getid) throws Exception{
			int n;
			
			String sql="UPDATE goods_info set totalPrice= goodsNum*goodsPrice  where id=?";
			
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1,getid.getId());
			
			n=preparedStatement.executeUpdate();
			
		   return n;
		}
		public static int deleteInventory (java.sql.Connection connection ,String id) throws Exception{
			String sql="delete from goods_info where id=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			return preparedStatement.executeUpdate();
		}
		public static int outinfo (java.sql.Connection connection) throws Exception{
			int n=1;
			if(n==1){
			String sql="SELECT * FROM goods_info INTO OUTFILE 'e:/shuliang.xls'";
			java.sql.Statement statement = connection.createStatement(); 

			ResultSet resultSet = statement.executeQuery(sql);
			
			}
		   return n=0;
		}
	};

	