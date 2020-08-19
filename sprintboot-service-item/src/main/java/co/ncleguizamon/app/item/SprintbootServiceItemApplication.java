package co.ncleguizamon.app.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SprintbootServiceItemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprintbootServiceItemApplication.class, args);
	}

}