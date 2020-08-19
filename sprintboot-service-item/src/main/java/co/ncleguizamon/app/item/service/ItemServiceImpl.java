package co.ncleguizamon.app.item.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import co.ncleguizamon.app.item.models.Item;
import co.ncleguizamon.app.item.models.Product;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private RestTemplate clienteRest;
	@Override
	public List<Item> findAll() {
		List<Product> products = Arrays.asList(clienteRest.getForObject("http://localhost:8001/products", Product[].class));
		return products.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer quantity) {
		Map<String, String> pathVariables = new HashMap<String, String>();
		pathVariables.put("id", id.toString());
		Product product = clienteRest.getForObject("http://localhost:8001/product/{id}", Product.class, pathVariables);
		return new Item(product, quantity);
	}

}
