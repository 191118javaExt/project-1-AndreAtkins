package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.revature.models.Reinbursements;
import com.revature.models.Users;
import com.revature.services.UserServices;
import com.revature.util.ConnectionUtil;

public class ReinbursementDAOImp implements ReinbursementDAO{
	
	
	
	
	//UserServices us = new UserServices();
	
	
	//public ArrayList<Reinbursements> rlist = us.getAllReinbursements();
	
	public boolean addReinbursement(Reinbursements rein) {
		
		 try (Connection conn = ConnectionUtil.getConnection()) {
				
				// This String represents the SQL which we will execute on our database
				// We use ?'s as placeholders, which we can insert values from Java using
				// PreparedStatements
	    String sql = "INSERT INTO \"Project1\".reinbursements (rein_amount, rein_resolved, "
	    		+ "rein_submitted, rein_description, rein_receipt, rein_author, rein_resolver, "
	    		+ "rein_statusId, rein_typeID ) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
				
				// This PreparedStatement object is a wrapper around our SQL string
				// And is obtained through our connection to the database
				// And allows us to insert into the placeholders
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setDouble(1, rein.getAmount());
				stmt.setString(2, rein.getTimeRes());
				stmt.setString(3, rein.getTimeSub());
				stmt.setString(4, rein.getDesc());
				stmt.setBytes(5, rein.getReceipt());
				stmt.setInt(6, rein.getAuthor());
				stmt.setInt(7, rein.getResolver());
				stmt.setInt(8, rein.getStatusId());
				stmt.setInt(9, rein.getTypeId());
				
				stmt.execute();
				
				
			} catch(SQLException ex) {
				
				System.out.println("Unable to add all reimbursements " + ex.getMessage());
				return false;
			}
			
			return true;
		
		
	}

	public boolean updateReinbursement(Reinbursements rein) {
		
		
				 try (Connection conn = ConnectionUtil.getConnection()) {
					
					// This String represents the SQL which we will execute on our database
					// We use ?'s as placeholders, which we can insert values from Java using
					// PreparedStatements
		    String sql = "UPDATE \"Project1\".reinbursements (rein_amount, rein_resolved, "
		    		+ "rein_submitted, rein_description, rein_receipt, rein_author, rein_resolver, "
		    		+ "rein_statusId, rein_typeID ) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
					
					// This PreparedStatement object is a wrapper around our SQL string
					// And is obtained through our connection to the database
					// And allows us to insert into the placeholders
					PreparedStatement stmt = conn.prepareStatement(sql);
					stmt.setDouble(1, rein.getAmount());
					stmt.setString(2, rein.getTimeRes());
					stmt.setString(3, rein.getTimeSub());
					stmt.setString(4, rein.getDesc());
					stmt.setBytes(5, rein.getReceipt());
					stmt.setInt(6, rein.getAuthor());
					stmt.setInt(7, rein.getResolver());
					stmt.setInt(8, rein.getStatusId());
					stmt.setInt(9, rein.getTypeId());
					
					stmt.execute();
				} catch(SQLException ex) {
					
					System.out.println("Unable to update all users " + ex.getMessage());
					return false;
				}
				
				return true;
			
			
		
		
	
	}

	public ArrayList<Reinbursements> getAllReinbursements() {
		
		ArrayList<Reinbursements> rlist=new ArrayList<Reinbursements>();
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT * FROM \"Project1\" .reinbursements;";
	
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
	
			while(rs.next()) {
			
		
				int reinbursementId = rs.getInt("rein_id");
				int amount = rs.getInt("rein_amount");			
				String timeRes = rs.getString("rein_resolved");		
				String timeSub = rs.getString("rein_submitted");
				String decs = rs.getString("rein_description");		   
				int reinauthor = rs.getInt("rein_author");
				int resolver = rs.getInt("rein_resolver");
				int statusId = rs.getInt("rein_statusid");
				int  typeId = rs.getInt("rein_typeid");
				byte [] byts = new byte [0];
				
				//int receipt = rs.getInt("rein_receipt");
				
				System.out.println(amount);
				
                Reinbursements rein = new Reinbursements(reinbursementId, amount, timeSub, timeRes, decs, reinauthor, resolver, statusId, typeId, byts);
				
                System.out.println(rein.toString());
                
                rlist.add(rein);
                
                System.out.println(rlist.toString());
             
			}
			
			rs.close();
		} catch(SQLException e) {
			System.out.println("Unable to retrieve all reinbursements" + e.getMessage());
			
		}
		return rlist;
	}

	@Override
	public HashMap<Integer, Reinbursements> getReimByIdMap() {
	 
		
		HashMap<Integer, Reinbursements> idtoreinmap =  new HashMap<Integer,Reinbursements>(); 
		
		
		try (Connection conn = ConnectionUtil.getConnection()) {
				
			    String sql = "SELECT * FROM \"Project1\" .reinbursements;";
				
			
				Statement stmt = conn.createStatement();
				
				ResultSet rs = stmt.executeQuery(sql);
			
				
				 while(rs.next()) {
					    int reinbursementId = rs.getInt("rein_Id");
						int amount = rs.getInt("rein_amount");			
						String timeRes = rs.getString("rein_resolved");		
						String timeSub = rs.getString("rein_submitted");
						String decs = rs.getString("rein_description");		   
						int reinauthor = rs.getInt("rein_author");
						int resolver = rs.getInt("rein_resolver");
						int statusId = rs.getInt("rein_statusid");
						int  typeId = rs.getInt("rein_typeid");
				
		Reinbursements rein = new Reinbursements(reinbursementId,amount,timeSub,timeRes,decs,reinauthor,resolver,statusId, typeId, null);
						
			     
	    idtoreinmap.put(reinbursementId, rein);
			     
			     
				}
				rs.close();
				
				
			
			} catch(SQLException ex) {
				//logger.warn("Unable to retrieve all users", ex);
				System.out.println("Unable to retrieve all users " + ex.getMessage());
				
			}
		return idtoreinmap;
		
	}
	
public HashMap< Reinbursements,Integer> getIdByReinMap() {
	 
		
		HashMap< Reinbursements,Integer> reintoidmap =  new HashMap<Reinbursements,Integer>(); 
		
		
		try (Connection conn = ConnectionUtil.getConnection()) {
				
			    String sql = "SELECT * FROM \"Project1\" .reinbursements;";
				
			
				Statement stmt = conn.createStatement();
				
				ResultSet rs = stmt.executeQuery(sql);
			
				
				 while(rs.next()) {
					    int reinbursementId = rs.getInt("rein_Id");
						int amount = rs.getInt("rein_amount");			
						String timeRes = rs.getString("rein_resolved");		
						String timeSub = rs.getString("rein_submitted");
						String decs = rs.getString("rein_description");		   
						int reinauthor = rs.getInt("rein_author");
						int resolver = rs.getInt("rein_resolver");
						int statusId = rs.getInt("rein_statusid");
						int  typeId = rs.getInt("rein_typeid");
				
		Reinbursements rein = new Reinbursements(reinbursementId,amount,timeSub,timeRes,decs,reinauthor,resolver,statusId, typeId, null);
						
			     
	    reintoidmap.put(rein, reinbursementId);
			     
			     
				}
				rs.close();
				
				
			
			} catch(SQLException ex) {
				//logger.warn("Unable to retrieve all users", ex);
				System.out.println("Unable to retrieve all users " + ex.getMessage());
				
			}
		return reintoidmap;
		
	}
	



}
