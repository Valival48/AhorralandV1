package pe.edu.upc.business.crud.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.business.crud.ProductService;
import pe.edu.upc.model.entity.Product;
import pe.edu.upc.model.repository.JpaRepository;
import pe.edu.upc.model.repository.ProductRepository;

@Named
@ApplicationScoped
public class ProductServiceImpl implements ProductService {

	@Inject
	private ProductRepository productRepository;
	@Override
	public JpaRepository<Product, Integer> getJpaRepository() {
		
		return productRepository;
	}
	@Override
	public List<Product> findByNProduct(String name) throws Exception {
		return productRepository.findByNProduct(name);
	}

}
