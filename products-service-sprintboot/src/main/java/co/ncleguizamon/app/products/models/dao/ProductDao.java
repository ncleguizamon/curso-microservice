package co.ncleguizamon.app.products.models.dao;

import org.springframework.data.repository.CrudRepository;

import co.ncleguizamon.app.products.models.entity.Product;


public interface ProductDao extends CrudRepository<Product, Long > {
	

}
