package co.ncleguizamon.app.item;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
	
	@Bean("clienteRest")
	public RestTemplate RegisterRestTemplate() {
		return new RestTemplate();
		
	}

}
