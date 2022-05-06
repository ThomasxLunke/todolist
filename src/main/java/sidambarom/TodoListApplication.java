package sidambarom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import sidambarom.todolist.repository.UsersRepository;

/**
 * Date: Mai 05-2022
 * Ceci est une application web permettant de gérer une todolist, protéger par des comptes utilisateur.
 * Cette classe permet de lancer l'application
 * @author Thomas Sidambarom
 * @version 1.0
 *
 */

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UsersRepository.class)
public class TodoListApplication implements WebMvcConfigurer {
	
	/**
	 * Ceci est le main de l'application
	 */
	public static void main(String[] args) {
		SpringApplication.run(TodoListApplication.class, args);
	}
	
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
	}
	
	
}
