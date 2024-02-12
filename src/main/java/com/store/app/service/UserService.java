package com.store.app.service;

import com.store.app.bean.User;

public interface UserService 
{
	public User loginUser(String username, String password);
	
	public void registerUser(User user);
	
	public int getByEmail(String username, String email);
	
	public boolean changePassword(String username,String password);
<<<<<<< HEAD
	
	public User getUser(String username);
	
	public void updateUser(User user);
	
=======
	public User getUserByUsername(String username);

	public int update(User g);

>>>>>>> cf3bd3dd23743d6ba538f6a43e692d298f7dbbc1
}
