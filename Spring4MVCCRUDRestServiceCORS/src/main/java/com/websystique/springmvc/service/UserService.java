package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.User;

//������������˷��������ǲ�������ʵ�֣�����һ���ļ��н��з�����ʵ�֣��������implement��������ʲô��Ϊʲô����ֱ��������ʵ�֣�
//�ļ����޸ĺ��Ϸ������*�ţ���ʾû�б�����

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
