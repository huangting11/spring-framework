package com.huang.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Huangting
 * @Time 2021/2/14
 */
@Configuration
public class OrderTest {
	public interface Test {
		void s();
	}

	@Service
	@Order(2)
	public class Test1 implements Test {
		@Override
		public void s() {
			System.out.println(1);
		}
	}

	@Service
	@Order(1)
	public class Test2 implements Test {
		@Override
		public void s() {
			System.out.println(2);
		}
	}

	@Autowired
	public List<Test> testList;
}
