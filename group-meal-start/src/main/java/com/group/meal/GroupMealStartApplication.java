package com.group.meal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication(scanBasePackages = {"com.group.meal"})
@PropertySource(value = "classpath:application.properties")
@ImportResource(value = {"classpath:spring-mybatis-config.xml","classpath:velocity-conf.xml"})
@EnableTransactionManagement
public class GroupMealStartApplication {

	public static void main(String[] args) {
		SpringApplication.run(GroupMealStartApplication.class, args);
	}

	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {

		return (container -> {
			ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/errorPage");
			ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/errorPage");
			ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/errorPage");

			container.addErrorPages(error401Page, error404Page, error500Page);
		});
	}


}
