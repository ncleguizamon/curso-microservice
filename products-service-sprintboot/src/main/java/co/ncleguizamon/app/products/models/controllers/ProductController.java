package co.ncleguizamon.app.products.models.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.ncleguizamon.app.products.models.entity.Product;
import co.ncleguizamon.app.products.models.service.IProductService;

@RestController
public class ProductController {
	
	@Autowired
	private Environment env;
	
	@Autowired
	private IProductService productService;
	
	@GetMapping("/products")
	public List<Product> list(){
		return productService.findAll().stream().map(product ->{
			product.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			return product;
		}).collect(Collectors.toList());
	}
	
	@GetMapping("/product/{id}")
	public Product productbyId(@PathVariable  long id) {
		Product product = productService.findById(id);
		product.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		return product;
	}

}
