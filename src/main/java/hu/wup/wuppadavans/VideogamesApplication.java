package hu.wup.wuppadavans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@ComponentScan(basePackages = VideogamesApplication.BASE_PACKAGE)
public class VideogamesApplication {

    public static final String BASE_PACKAGE = "hu.wup.wuppadavans";

	public static void main(String[] args) {
		SpringApplication.run(VideogamesApplication.class, args);
	}
}
