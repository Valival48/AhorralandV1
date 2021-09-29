package pe.edu.upc.model.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pe.edu.upc.model.entity.Product;
import pe.edu.upc.model.repository.ProductRepository;

public class ProductRepositoryImpl implements ProductRepository{

	@PersistenceContext (unitName = "AhorralandV1")
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public Optional<Product> findById(Integer id) throws Exception {
		return findById(id, Product.class);
	}

	@Override
	public List<Product> findAll() throws Exception {
		String jpql = "SELECT productRepository FROM ProductRepository productRepository";
		return findAll(Product.class, jpql);
	}

}
