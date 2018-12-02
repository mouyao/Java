package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.User;

//这里仅仅定义了方法，但是并不进行实现，在另一个文件中进行方法的实现，重新理解implement的作用是什么？为什么不能直接在这里实现？
//文件被修改后上方会出现*号，表示没有被保存

public interface UserService {
	User findById(long id);
	User findByName(String name);
	void saveUser(User user);
	void updateUser(User user);
	void deleteUserById(long id);
	List<User> findAllUsers(); 
	void deleteAllUsers();
	public boolean isUserExist(User user);
	
}
