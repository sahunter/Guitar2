package com.guitar.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class GuitarDAOImpl implements GuitarDAO {
	
	private DataSource datasource;
	public GuitarDAOImpl(DataSource datasource){
		this.datasource=datasource;
		
	}


	@Override
	public void addGuitar(Guitar guitar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Guitar getGuitar(Guitar guitar) {

		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement stmt=null;
		SQLException ex=null;
		
		
		try{                                         // and password=?
			conn=datasource.getConnection();
			stmt=conn.prepareStatement("SELECT * FROM Guitar  ");
			//stmt.setString(1,guitar.getSerialNumble());
			//stmt.setString(2, administrator.getPassword());
			ResultSet rs=stmt.executeQuery();
			
			while(rs.next()){
				guitar=new Guitar();
				
				guitar.setSerialNumble(rs.getString("serialNumble"));
				guitar.setBuilder(rs.getString("builder"));
				guitar.setModel(rs.getString("model"));
				guitar.setType(rs.getString("type"));
				guitar.setPrice(rs.getString("price"));
				guitar.setTopWood(rs.getString("topWood"));
				guitar.setBackWood(rs.getString("backWood"));
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
		return  guitar;
	
	}
		
		
	@Override
	public void updateGuitar(Guitar guitar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteGuitar(Guitar guitar) {
		// TODO Auto-generated method stub
		
		
		Connection conn=null;
		PreparedStatement stmt=null;
		//PreparedStatement stmt1=null;
		//PreparedStatement stmt2=null;

		SQLException ex=null;
		try{
			conn=datasource.getConnection();
			stmt=conn.prepareStatement("DELETE FROM Guitar WHERE serialNumble=? ");
		//	stmt1=conn.prepareStatement("DELETE FROM UserRole WHERE roleNO=? ");
		//	stmt2=conn.prepareStatement("DELETE FROM RoleAuthority WHERE roleNO=? ");


			stmt.setString(1,guitar.getSerialNumble());
		//	stmt1.setString(1,role.getRoleNO());
		//	stmt2.setString(1,role.getRoleNO());


			stmt.executeUpdate();
		//	stmt1.executeUpdate();
		//	stmt2.executeUpdate();


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

		
		
		
		
	}

	@Override
	public List<Guitar> getGuitars(Guitar guitar) {
		// TODO Auto-generated method stub
		Connection conn=null;
		//PreparedStatement stmt=null;
		PreparedStatement stmt1=null;
		SQLException ex=null;
		List<Guitar> guitars=null;
		
		try{												 //and password=?
			conn=datasource.getConnection();
			//stmt=conn.prepareStatement("SELECT * FROM RoleAuthority WHERE Id=?");	
			stmt1=conn.prepareStatement("SELECT * FROM Guitar");
		//	stmt.setString(1, roleAuthority.getId());
			
			
			//stmt.setString(2, customer.getPassword());
			//ResultSet rs=stmt.executeQuery();
		//	roleAuthoritys=new ArrayList<RoleAuthority>();
		//	while(rs.next()){
			//	roleAuthority=new RoleAuthority();
			//	roleAuthority.setRoleNO(rs.getString("roleNO"));
			//	roleAuthority.setAuthorityNO(rs.getString("authorityNO"));
			//	roleAuthority.setKind(rs.getString("kind"));
			//	roleAuthority.setState(rs.getString("state"));
			//	roleAuthority.setCreatetime(rs.getString("createtime"));
		    //	roleAuthoritys.add(roleAuthority);
			
		//	}
			
			ResultSet rs1=stmt1.executeQuery();
			guitars=new ArrayList<Guitar>();
			while(rs1.next()){
				guitar=new Guitar();
				
				guitar.setSerialNumble(rs1.getString("serialNumble"));
				guitar.setBuilder(rs1.getString("builder"));
				guitar.setModel(rs1.getString("model"));
				
			//	roleAuthority.setState(rs1.getString("state"));
				guitar.setType(rs1.getString("type"));
				
				guitar.setPrice(rs1.getString("price"));
				guitar.setBackWood(rs1.getString("backWood"));
				guitar.setTopWood(rs1.getString("topWood"));
				guitars.add(guitar);
			
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
		return guitars;
	
	
	
	
	}}
