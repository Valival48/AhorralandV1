package pe.edu.upc.model.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pe.edu.upc.model.entity.Category;
import pe.edu.upc.model.repository.CategoryRepository;

public class CategoryRepositoryImpl implements CategoryRepository{

	@PersistenceContext (unitName = "AhorralandV1")
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public Optional<Category> findById(Integer id) throws Exception {
		return findById(id, Category.class);
	}

	@Override
	public List<Category> findAll() throws Exception {
		String jpql = "SELECT category FROM Category category";
		return findAll(Category.class, jpql);
	}

}
