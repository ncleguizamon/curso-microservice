package co.ncleguizamon.app.products.models.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.ncleguizamon.app.products.models.entity.Product;
import co.ncleguizamon.app.products.models.service.IProductService;

@RestController
public class ProductController {
	
	@Autowired
	private IProductService productService;
	
	@GetMapping("/products")
	public List<Product> list(){
		return productService.findAll();
	}
	
	@GetMapping("/product/{id}")
	public Product productbyId(@PathVariable  long id) {
		return productService.findById(id);
	}

}
