package co.edu.icesi.ci.talleres;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import co.edu.icesi.ci.talleres.model.UserApp;
import co.edu.icesi.ci.talleres.model.UserType;
import co.edu.icesi.ci.talleres.repositories.UserRepository;

@SpringBootApplication
public class Ci192TalleresApplication {

	@Bean
	public Java8TimeDialect java8TimeDialect() {
		return new Java8TimeDialect();
	}
	@Bean
	public CommandLineRunner demo(UserRepository userRepository) {
		return (args) -> {
			UserApp usuario = new UserApp();
			
			usuario.setUsername("admin");
			usuario.setPassword("{noop}admin");
			usuario.setType(UserType.admin);
						userRepository.save(usuario);
				UserApp usuario2 = new UserApp();			
			usuario2.setUsername("operador");
	
			
			usuario2.setPassword("{noop}operador");
			usuario2.setType(UserType.operador);
			userRepository.save(usuario2);
		};
		
	}
	public static void main(String[] args) {
		SpringApplication.run(Ci192TalleresApplication.class, args);
	}
	


	

}
