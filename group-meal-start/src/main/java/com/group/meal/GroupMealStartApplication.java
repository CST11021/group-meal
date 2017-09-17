package com.group.meal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication(scanBasePackages = {"com.group.meal"})
@PropertySource(value = "classpath:application.properties")
@ImportResource(value = {"classpath:mybatis-config.xml","classpath:velocity-conf.xml"})
@EnableTransactionManagement
public class GroupMealStartApplication {

	public static void main(String[] args) {
		SpringApplication.run(GroupMealStartApplication.class, args);
	}
}
