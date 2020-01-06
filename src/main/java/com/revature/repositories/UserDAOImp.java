package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import com.revature.models.Users;
import com.revature.services.UserServices;
import com.revature.util.ConnectionUtil;

public class UserDAOImp implements UserDAO{

	
	
	
	
	
	public Users findUserByUserName(String username) {
		
		HashMap<String, Users> usermap =  UserServices.usermap;
		
		return usermap.get(username);
		
		
	}

	public boolean addUser(Users user) {
		
		
	     try (Connection conn = ConnectionUtil.getConnection()) {
				
				// This String represents the SQL which we will execute on our database
				// We use ?'s as placeholders, which we can insert values from Java using
				// PreparedStatements
				String sql = "INSERT INTO \"Project1\".users (firstname, lastname, username, pass, email, roleid) " +
						"VALUES (?, ?, ?, ?, ?, ?);";
				
				// This PreparedStatement object is a wrapper around our SQL string
				// And is obtained through our connection to the database
				// And allows us to insert into the placeholders
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, user.getFirstname());
				stmt.setString(2, user.getLastname());
				stmt.setString(3, user.getUsername());
				stmt.setString(4, user.getPassword());
				stmt.setString(5, user.getEmail());
				stmt.setInt(6, user.getRoleId());
				System.out.println(conn);
				
				stmt.execute();
			} catch(SQLException ex) {
				//logger.warn("Unable to retrieve all users", ex);
				System.out.println("Unable to retrieve all users " + ex.getMessage());
				return false;
			}
			
			return true;
	}

	public boolean updateUserBal(Users user) {
		
		
		
		return false;
	}

	public HashMap<String, String> getUsersFromDataBaseMap() {
		
    HashMap< String,String> passmap =  new HashMap< String,String>(); 
		
		try (Connection conn = ConnectionUtil.getConnection()) {
				
				String sql = "SELECT * FROM \"Project1\".users;";
		
				Statement stmt = conn.createStatement();
				
				ResultSet rs = stmt.executeQuery(sql);
				
				
				
				while(rs.next()) {
					String firstname = rs.getString("firstname");
					String lastname = rs.getString("lastname");				
					String email = rs.getString("email");		
					String username = rs.getString("username");
					String password = rs.getString("pass");
				    int roleId = rs.getInt("roleid");
					int userId = rs.getInt("userid");

					
	                Users user1 = new Users(firstname, lastname, username, password, email, roleId, userId, UserServices.getReinbursementsForUser(userId));
					passmap.put(username,password);
					//UserServices.addPassToMap(username, password);
					
	                user1.setFirstname(firstname);
				    user1.setLastname(firstname);
	                user1.setEmail(username );
	                user1.setPassword( password);
	                user1.setRoleId(roleId);
	                user1.setUserId(userId);
				}
				
				rs.close();
			} catch(SQLException e) {
				System.out.println("Unable to retrieve all users" + e.getMessage());
				
			}

		return passmap;
			

	
	}

	public HashMap<String, Users> getUsersFromDataBaseUserList() {
		  
		HashMap< String,Users> namemap =  new HashMap< String,Users>(); 
		
		try (Connection conn = ConnectionUtil.getConnection()) {
				
				String sql = "SELECT * FROM \"Project1\" .users;";
		
				Statement stmt = conn.createStatement();
				
				ResultSet rs = stmt.executeQuery(sql);
				
				
				
				while(rs.next()) {
					String firstname = rs.getString("firstname");
					String lastname = rs.getString("lastname");				
					String email = rs.getString("email");		
					String username = rs.getString("username");
					String password = rs.getString("pass");
				    int roleId = rs.getInt("roleid");
					int userId = rs.getInt("userid");

					
	                Users user1 = new Users(firstname, lastname, username, password, email, roleId, userId, UserServices.getReinbursementsForUser(userId));
					namemap.put(username, user1);
					UserServices.addPassToMap(username, password);
	                
	                user1.setFirstname(firstname);
				    user1.setLastname(lastname);
	                user1.setEmail(username );
	                user1.setPassword( password);
	                user1.setRoleId(roleId);
	                user1.setUserId(userId);
				}
				
				rs.close();
			} catch(SQLException e) {
				System.out.println("Unable to retrieve all users" + e.getMessage());
				
			}

		return namemap;
			

	
	}

	public boolean deleteUser(Users user) {
		
		
		return false;
	} 

	@Override
	public HashMap<String, Integer> getIdMap() {
		
		HashMap< String,Integer> nametoid =  new HashMap< String,Integer>(); 
		
			
		try (Connection conn = ConnectionUtil.getConnection()) {
				
			    String sql = "SELECT * FROM \"Project1\" .users;";
				
			
				Statement stmt = conn.createStatement();
				
				ResultSet rs = stmt.executeQuery(sql);
			
				
				 while(rs.next()) {
			     int id  = rs.getInt ("userid");
			     String dbuname = rs.getString("username");
			     
			     nametoid.put(dbuname, id);
			     
			     
				}
				rs.close();
				
				
			
			} catch(SQLException ex) {
				//logger.warn("Unable to retrieve all users", ex);
				System.out.println("Unable to retrieve all users " + ex.getMessage());
				
			}
		return nametoid;
			
		
	}
	
	public HashMap<Integer, String> getNameByIdMap() {
		
		HashMap<Integer,String> idtonamemap =  new HashMap<Integer,String>(); 
		
			
		try (Connection conn = ConnectionUtil.getConnection()) {
				
			    String sql = "SELECT * FROM \"Project1\" .users;";
				
			
				Statement stmt = conn.createStatement();
				
				ResultSet rs = stmt.executeQuery(sql);
			
				
				 while(rs.next()) {
			     int id  = rs.getInt ("userid");
			     String dbuname = rs.getString("username");
			     
			     idtonamemap.put(id, dbuname);
			     
			     
				}
				rs.close();
				
				
			
			} catch(SQLException ex) {
				//logger.warn("Unable to retrieve all users", ex);
				System.out.println("Unable to retrieve all users " + ex.getMessage());
				
			}
		return idtonamemap;
			
		
	}

}
