package co.ncleguizamon.app.item.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.ncleguizamon.app.item.models.Item;
import co.ncleguizamon.app.item.service.ItemService;

@RestController
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	@GetMapping("list")
	public List<Item> list(){
		return itemService.findAll();
	}
	
	@GetMapping("detail/{id}/quantity/{quantity}")
	public Item detail(@PathVariable Long id, @PathVariable Integer quantity) {
		return itemService.findById(id, quantity);
		
	}
	
	
}
