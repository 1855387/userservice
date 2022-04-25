package io.getarrays.userservice;

import io.getarrays.userservice.domain.Role;
import io.getarrays.userservice.domain.User;
import io.getarrays.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

	public static void main(String[] args) {

		SpringApplication.run(UserserviceApplication.class, args);
	}


	@Bean
	CommandLineRunner run(UserService userService) { // testing the database with role adds etc
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser((new User(null, "John Travolta", "john", "1234", new ArrayList<>())));
			userService.saveUser((new User(null, "Will Smith", "will", "1234", new ArrayList<>())));
			userService.saveUser((new User(null, "HAP", "ha", "1234", new ArrayList<>())));
			userService.saveUser((new User(null, "yet", "y", "y", new ArrayList<>())));

			userService.addRoletoUser("john", "ROLE_USER");
			userService.addRoletoUser("john", "ROLE_MANAGER");
			userService.addRoletoUser("will", "ROLE_MANAGER");
			userService.addRoletoUser("ha", "ROLE_ADMIN");
			userService.addRoletoUser("y", "ROLE_ADMIN");
			userService.addRoletoUser("y", "ROLE_SUPER_ADMIN");
			userService.addRoletoUser("y", "ROLE_USER");

		};
	}

}
