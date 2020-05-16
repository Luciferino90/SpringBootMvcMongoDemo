package it.usuratonkachi.mongomvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableMongoRepositories(basePackages = "it.usuratonkachi.mongomvc.domain")
public class MongomvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongomvcApplication.class, args);
	}

}
