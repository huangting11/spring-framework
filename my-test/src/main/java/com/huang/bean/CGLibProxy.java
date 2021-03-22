package com.huang.bean;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author Huangting
 * @Time 2021/2/17
 */
public class CGLibProxy implements MethodInterceptor{
	private Object targetObject;

	public Object createProxyObject(Object obj) {
		this.targetObject = obj;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(obj.getClass());
		enhancer.setCallback(this);
		return enhancer.create();
	}

	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		System.out.println("增强");
		return method.invoke(targetObject, objects);
	}

	public static void main(String[] args) {
		((UserService) new CGLibProxy().createProxyObject(new UserServiceImpl())).addUser("tom");;
	}
}
