package co.ncleguizamon.app.item.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import co.ncleguizamon.app.item.models.Product;

import java.util.List;
@FeignClient(name ="service-products", url="localhost:8001")
public interface ProductClientRest {
	
	@GetMapping("/products")
	public List<Product> List();
	
	@GetMapping("/product/{id}")
	public Product detail(@PathVariable  long id);

}
