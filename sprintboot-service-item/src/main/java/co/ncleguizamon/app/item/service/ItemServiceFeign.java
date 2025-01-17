package co.ncleguizamon.app.item.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import co.ncleguizamon.app.item.client.ProductClientRest;
import co.ncleguizamon.app.item.models.Item;

@Service("serviceFeign")
@Primary
public class ItemServiceFeign implements ItemService {
	@Autowired
	private ProductClientRest clientFeign;

	@Override
	public List<Item> findAll() {
		
		return clientFeign.List().stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer quantity) {
		return new Item(clientFeign.detail(id), quantity);
	}

}
