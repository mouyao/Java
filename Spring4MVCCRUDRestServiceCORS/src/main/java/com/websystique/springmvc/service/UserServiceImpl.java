package com.websystique.springmvc.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.websystique.springmvc.model.User;

import com.websystique.springmvc.jdbc.GetDataBase;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{  //ִ�У��᳹��ʹ��Ч
	private static final AtomicLong counter = new AtomicLong();
	private static List<User> users;   //List <user>��Ͽ�ܣ�һ�ִ洢���ݵ����ݸ�ʽ
	static{
		users= populateDummyUsers();
	}
	public List<User> findAllUsers() {
		return users;
	}
	
	public User findById(long id) {
		for(User user : users){
			if(user.getId() == id){
				return user;
			}
		}
		return null;
	}
	
	public User findByName(String name) {
		for(User user : users){
			if(user.getName().equalsIgnoreCase(name)){
				return user;
			}
		}
		return null;
	}
	
	public void saveUser(User user) {
		user.setId(counter.incrementAndGet());
		users.add(user);
	}

	public void updateUser(User user) {
		int index = users.indexOf(user);
		users.set(index, user);
	}

	public void deleteUserById(long id) {
		for (Iterator<User> iterator = users.iterator(); iterator.hasNext(); ) {
		    User user = iterator.next();
		    if (user.getId() == id) {
		        iterator.remove();
		    }
		}
	}

	public boolean isUserExist(User user) {
		return findByName(user.getName())!=null;
	}
	
	public void deleteAllUsers(){
		users.clear();
	}
   //�������ֱ�ӽ����������ݷ���ȥ���������ɾ����ĳһ������ȥ�����ʱ�������������أ�
	private static List<User> populateDummyUsers(){
		List<User> users = new ArrayList<User>();
		String data=GetDataBase.getAll();
		System.out.println(data+"666666666");    //��ȡ�����������ǿյ�,����Ϊʲô�أ�
		data="mouyao";
		/*users.add(new User(counter.incrementAndGet(),"Sam",30, 70000));
		users.add(new User(counter.incrementAndGet(),"Tom",40, 50000));
		users.add(new User(counter.incrementAndGet(),"Jerome",45, 30000));*/
		users.add(new User(counter.incrementAndGet(),data, 66, 1));
		users.add(new User(counter.incrementAndGet(),data, 99, 3));
		users.add(new User(counter.incrementAndGet(),data, 33, 4));
		return users;
	}
}
