package co.ncleguizamon.app.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ProductsServiceSprintbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsServiceSprintbootApplication.class, args);
	}

}
