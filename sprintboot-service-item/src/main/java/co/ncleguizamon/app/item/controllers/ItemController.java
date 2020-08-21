package co.ncleguizamon.app.item.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import co.ncleguizamon.app.item.models.Item;
import co.ncleguizamon.app.item.models.Product;
import co.ncleguizamon.app.item.service.ItemService;

@RestController
public class ItemController {
	@Autowired
	@Qualifier("serviceFeign")
	private ItemService itemService;
	
	@GetMapping("list")
	public List<Item> list(){
		return itemService.findAll();
	}
	
    @HystrixCommand(fallbackMethod = "alternativeMethod")
	@GetMapping("detail/{id}/quantity/{quantity}")
	public Item detail(@PathVariable Long id, @PathVariable Integer quantity) {
		return itemService.findById(id, quantity);
		
	}
    
    public Item alternativeMethod(Long id, Integer quantity) {
    	Item item = new Item();
    	Product product = new Product();
    	
    	item.setQuantity(quantity);
    	product.setId(id);
    	product.setName("Camara zony");
    	product.setPrice(5000.0);
    	item.setProduct(product);
    	return item;
    	
    }
	
	
}
