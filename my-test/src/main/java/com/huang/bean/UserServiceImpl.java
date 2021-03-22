package com.huang.bean;

/**
 * @Author Huangting
 * @Time 2021/2/17
 */
public class UserServiceImpl implements UserService {

	@Override
	public void addUser(String name) {
		System.out.println("调用了UserServiceImpl.addUser()方法！");
	}
}
