package com.huang.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Huangting
 * @Time 2021/2/13
 */
@Configuration
public class TestBean implements BeanNameAware, BeanFactoryAware, BeanClassLoaderAware{
	private String name;
	private BeanFactory beanFactory;
	private ClassLoader classLoader;

	@Override
	public void setBeanName(String name) {
		this.name = name;
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}

	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
		this.classLoader = classLoader;
	}

	@Bean
	public TestBean getTestBean() {
		return new TestBean();
	}

	public void getInformation() {
		System.out.println("BeanName: " + name);
		System.out.println("BeanFactory: " + beanFactory.toString());
		System.out.println("BeanClassLoader " + classLoader.toString());
	}
}
