package com.huang.bean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author Huangting
 * @Time 2021/2/17
 */
public class JDKProxy implements InvocationHandler {
	private Object targetObject;

	public Object newProxy(Object obj) {
		this.targetObject = obj;
		return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),
				targetObject.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("增强");
		return method.invoke(targetObject, args);
	}

	public static void main(String[] args) {
		((UserService)new JDKProxy().newProxy(new UserServiceImpl())).addUser("tom");
	}
}
