package test.keycloak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Sample web app based on tutorial from {@link https://www.thomasvitale.com/spring-boot-keycloak-security/} 
 * within spring-security config and restrictions.
 * @author Fahed CHAABANE
 *
 */
@SpringBootApplication
public class KeyCloakSample {

	public static void main(String[] args) {
		SpringApplication.run(KeyCloakSample.class, args);
	}
}