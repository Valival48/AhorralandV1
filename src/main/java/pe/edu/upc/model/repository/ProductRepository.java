package pe.edu.upc.model.repository;

import java.util.List;

import pe.edu.upc.model.entity.Product;


public interface ProductRepository extends JpaRepository<Product, Integer> {
	List<Product> findByNProduct(String name)throws Exception;
}
