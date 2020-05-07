package it.usuratonkachi.mongomvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "it.usuratonkachi.mongomvc.domain")
public class MongomvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongomvcApplication.class, args);
	}

}
