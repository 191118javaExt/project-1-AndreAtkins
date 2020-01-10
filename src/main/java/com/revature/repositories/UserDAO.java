package com.revature.repositories;

import java.util.ArrayList;
import java.util.HashMap;

import com.revature.models.Users;

public interface UserDAO {
	
	public Users findUserByUserName(String username);
	public boolean addUser(Users user);
	public boolean updateUserBal(Users user);
	public HashMap<String,String> getUsersFromDataBaseMap();
	public HashMap<String,Users> getUsersFromDataBaseUserList();
	public boolean deleteUser(Users user);
    public HashMap<String, Integer> getIdMap();
    public HashMap<Integer,String> getNameByIdMap();
    public ArrayList<String> getAllEmails();
    
	
}
