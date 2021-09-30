package pe.edu.upc.model.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.edu.upc.model.entity.Product;
import pe.edu.upc.model.repository.ProductRepository;
@Named
@ApplicationScoped
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

	@Override
	public List<Product> findByNProduct(String name) throws Exception {
		return findByField("NProduct", name);
	}
	private List<Product> findByField(String field, String value) throws Exception {
		List<Product> products = new ArrayList<>();
		String jpql = "SELECT pro FROM Status pro WHERE pro." + field + " = '" + value + "'";	
		TypedQuery<Product> typedQuery = getEntityManager().createQuery(jpql, Product.class); //field q es el campo de la bd y value el atributo
		products = typedQuery.getResultList();		
		return products;
	}
}
