package com.esmabeydili.backend2;

import com.esmabeydili.backend2.dto.UserCreateDTO;
import com.esmabeydili.backend2.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.yaml.snakeyaml.comments.CommentLine;


@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class Backend2Application {

	public static void main(String[] args) {
		SpringApplication.run(Backend2Application.class, args);
	}

	@Bean
	CommandLineRunner createInitalUsers(UserService userService){
		return args -> {
			UserCreateDTO user= new UserCreateDTO();
			user.setUserName("user1");
			user.setFirstName("esma");
			user.setLastName("beydili");
			userService.createUser(user);

			UserCreateDTO user2= new UserCreateDTO();
			user2.setUserName("user2");
			user2.setFirstName("esma2");
			user2.setLastName("beydili2");
			userService.createUser(user2);

			UserCreateDTO user3= new UserCreateDTO();
			user3.setUserName("user3");
			user3.setFirstName("esma3");
			user3.setLastName("beydili3");
			userService.createUser(user3);
		};
	}

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource
				= new ReloadableResourceBundleMessageSource();

		messageSource.setBasenames(
				"classpath:/ValidationMessages_en"
		);
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

}
