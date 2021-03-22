package com.huang.config;

import com.huang.bean.User;
import com.huang.condition.LinuxCondition;
import com.huang.condition.WindowsCondition;
import org.springframework.context.annotation.*;

/**
 * @Author Huangting
 * @Time 2020/5/26
 */
//配置类==配置文件
@Configuration  //告诉Spring这是一个配置类
@ComponentScans(
		value = {
				@ComponentScan(value="com.huang")
//				,includeFilters = {		// 指定扫面的时候只需要包含哪些组件，多个按照先后顺序过滤
						//@ComponentScan.Filter(type= FilterType.ANNOTATION,classes={Controller.class}),    //按照注解
						//@ComponentScan.Filter(type=FilterType.ASSIGNABLE_TYPE,classes={UserService.class}),//按照给定的类型
						//FilterType.ASPECTJ 使用ASPECTJ表达式
						//FilterType.REGEX 基于正则表达式
//						@ComponentScan.Filter(type= FilterType.CUSTOM,classes={MyTypeFilter.class}) //使用自定义规则
//				},useDefaultFilters = false)	//为了使include生效，需要禁用默认规则
		}
)
//@ComponentScan  value:指定要扫描的包
//excludeFilters = Filter[] ：指定扫描的时候按照什么规则排除那些组件
//includeFilters = Filter[] ：指定扫描的时候只需要包含哪些组件
//FilterType.ANNOTATION：按照注解
//FilterType.ASSIGNABLE_TYPE：按照给定的类型；
//FilterType.ASPECTJ：使用ASPECTJ表达式
//FilterType.REGEX：使用正则指定
//FilterType.CUSTOM：使用自定义规则
public class AppConfig {
	//给容器中注册一个Bean;类型为返回值的类型，id默认是用方法名作为id
//	@Bean("user1")

	@Conditional(WindowsCondition.class)
	@Bean(value = "win")
	public User user1(){
		return new User("user", 20);
	}

	@Conditional(LinuxCondition.class)
	@Bean("linux")
	public User user2(){
		return new User("user", 20);
	}

	public void init() {

	}
}