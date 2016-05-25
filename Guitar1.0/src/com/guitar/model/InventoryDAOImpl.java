package com.guitar.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.guitar.model.Guitar;
import com.guitar.model.GuitarDAO;
public class InventoryDAOImpl implements InventoryDAO{

	private DataSource datasource;
	public InventoryDAOImpl(DataSource datasource){
		this.datasource=datasource;
	}

	@Override
	public void addInventory(Inventory inventory) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Guitar getInventory(Inventory inventory) {
		// TODO Auto-generated method stub
		return null;
		
		
		
	}

	@Override
	public void updateInventory(Inventory inventory) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteInventory(Inventory inventory) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public List<Guitar> getInventorys(Guitar guitar) {
		// TODO Auto-generated method stub

		Connection conn=null;
		
		
	    List<Guitar> guitar1 = new ArrayList<Guitar>();
		String sqlselect = "select * from guitar where 2=2 ";
	
		if(guitar.getType()!=null&guitar.getType()!=""){
			sqlselect+=" and type='"+guitar.getType()+"'";
		}
		if(guitar.getBuilder()!=null&guitar.getBuilder()!=""){
			sqlselect+=" and builder='"+guitar.getBuilder()+"'";
		}
		if(guitar.getModel()!=null&guitar.getModel()!=""){
			sqlselect+=" and model='"+guitar.getModel()+"'";
		}
		if(guitar.getBackWood()!=null&guitar.getBackWood()!=""){
			sqlselect+=" and backwood='"+guitar.getBackWood()+"'";
		}
		if(guitar.getTopWood()!=null&guitar.getTopWood()!=""){
			sqlselect+=" and topwood='"+guitar.getBackWood()+"'";
		}
		
		SQLException ex = null;
		try{												 //and password=?
			conn=datasource.getConnection();
		
		PreparedStatement ptmt = conn.prepareStatement(sqlselect);
		ResultSet rs = ptmt.executeQuery();
		Guitar guitar2=null;
		
		
	
		while (rs.next()) {
				guitar2= new Guitar();
				
			//	rs =new String(rs1.getBytes("gbk"),"UTF-8");
				guitar2.setSerialNumble(rs.getString("serialNumble"));
		    	guitar2.setType(rs.getString("type"));
				guitar2.setBuilder(rs.getString("builder"));
				guitar2.setModel(rs.getString("model"));
				guitar2.setPrice(rs.getString("price"));
				guitar2.setBackWood(rs.getString("backwood"));
				guitar2.setTopWood(rs.getString("topwood"));
			//	guitar2.setSerialNumble(rs.get("serialNumble").toString());
			//	guitar2.setSerialNumble(rs.getBytes("type").toString());
			//	guitar2.setSerialNumble(rs.getBytes("builder").toString());
			//	guitar2.setSerialNumble(rs.getBytes("model").toString());
			//	guitar2.setSerialNumble(rs.getBytes("price").toString());
			//	guitar2.setSerialNumble(rs.getBytes("backwood").toString());
			//	guitar2.setSerialNumble(rs.getBytes("topwood").toString());	
				guitar1.add(guitar2);
		}
		}catch(SQLException e){
			ex=e;
		}finally{
			if(conn!=null){
				try{
					conn.close();
				}catch(SQLException e){
					if(ex==null){
						ex=e;
					}
				}
			}
		if(ex!=null){
			throw new RuntimeException(ex);
		}
		}
		return guitar1;
	}

}
