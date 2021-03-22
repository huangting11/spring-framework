import com.huang.bean.TestBean;
import com.huang.bean.User;
import com.huang.config.AppConfig;
import com.huang.config.OrderTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import java.util.HashMap;


/**
 * @Author Huangting
 * @Time 2020/5/21
 */
public class BeanFactoryTest {
	@Test
	public void test1() {

		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("MyConfig.xml");

		BeanDefinitionRegistry reg = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(reg);
		reader.loadBeanDefinitions(new ClassPathResource("MyConfig.xml"));
		BeanFactory bf = (BeanFactory)reg;
		ClassPathXmlApplicationContext c = new ClassPathXmlApplicationContext("MyConfig.xml");

//AnnotationConfigApplic ationContext
//		ApplicationContext
//		DefaultListableBeanFactory
//		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("MyConfig.xml"));
		User bean = (User) c.getBean("user");
		HashMap map = new HashMap();
		map.put(1,2);
	}

	@Test
	public void test2() {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);


		String[] namesForType = applicationContext.getBeanNamesForType(User.class);
		for (String name : namesForType) {
			System.out.println(name);
		}
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String beanDefinitionName: beanDefinitionNames) {
			System.out.println(beanDefinitionName);

		}

	}

	@Test
	public void test3() {
//		ClassPathXmlApplicationContext
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestBean.class);
//		applicationContext.
		TestBean testBean = (TestBean) applicationContext.getBean("testBean");
		testBean.getInformation();
	}



	@Test
	public void test4() {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(OrderTest.class);
		((OrderTest)applicationContext.getBean("orderTest")).testList.get(0).s();
	}
}
