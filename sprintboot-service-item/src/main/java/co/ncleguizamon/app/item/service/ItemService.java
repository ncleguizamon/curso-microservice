package co.ncleguizamon.app.item.service;

import java.util.List;

import co.ncleguizamon.app.item.models.Item;

public interface ItemService {
	 public List<Item> findAll();
	 public Item findById(Long id, Integer quantity );
	 

}
