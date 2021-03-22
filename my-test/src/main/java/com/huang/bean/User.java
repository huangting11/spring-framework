package com.huang.bean;

/**
 * @Author Huangting
 * @Time 2020/5/21
 */
public class User {
	private String name = "testXml";
	private int age;

	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public void method1() {
		System.out.println("11");
	}
	public void method2() {
		System.out.println("22");
	}
	public void initMethod() {
		System.out.println("initMethod");
	}

	@Override
	public String toString() {
		return "name:" + name + "-age:" + age;
	}
}