package ma.khabbachi.controle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "ma.khabbachi.entities")
@ComponentScan(basePackages = {"ma.khabbachi.controllers","ma.khabbachi.services"})
@EnableJpaRepositories(basePackages = "ma.khabbachi.repository")
public class ControleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControleApplication.class, args);
	}

}
