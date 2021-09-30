package pe.edu.upc.business.crud;

import java.util.List;

import pe.edu.upc.model.entity.Product;

public interface ProductService extends CrudService<Product, Integer> {
	List<Product> findByNProduct(String name)throws Exception;
}
