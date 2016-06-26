package org.javachina.shopcart.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.catalina.storeconfig.IStoreConfig;
import org.javachina.connectionpool.ConnectionPool;
import org.javachina.shopcart.dto.GoodsInfoDto;

public class GoodsInfoDao {
	/*
	 * 根据类型Id取得对应的所有商品
	 */
	public ArrayList<GoodsInfoDto> getByTid(int lid){
		ArrayList<GoodsInfoDto> result = new ArrayList<GoodsInfoDto>();
		Connection conn = null;
		conn = ConnectionPool.getConnection();
		Statement stat =null;
		ResultSet rs = null;
		try {
			stat = conn.createStatement();
			String sql = "select id ,name,price,count,description from goods_info where leixingid="+lid;
			rs = stat.executeQuery(sql);
			while(rs.next()){
				GoodsInfoDto dto = new GoodsInfoDto();
				dto.setId(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setPrice(rs.getDouble(3));
				dto.setCount(rs.getInt(4));
				dto.setDescription(rs.getString(5));
				
				result.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null){
					rs.close();
				}
				if(stat!=null){
					stat.close();
				}
				if(conn!=null&&!conn.isClosed()){
					ConnectionPool.close(conn);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
}
