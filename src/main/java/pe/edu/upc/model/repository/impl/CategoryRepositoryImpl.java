package pe.edu.upc.model.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.edu.upc.model.entity.Category;
import pe.edu.upc.model.repository.CategoryRepository;

@Named
@ApplicationScoped
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

	@Override
	public List<Category> findByNType(String type) throws Exception {
		return findByField("NType", type);
	}
	private List<Category> findByField(String field, String value) throws Exception {
		List<Category> categories = new ArrayList<>();
		String jpql = "SELECT cat FROM Status cat WHERE cat." + field + " = '" + value + "'";	
		TypedQuery<Category> typedQuery = getEntityManager().createQuery(jpql, Category.class); //field q es el campo de la bd y value el atributo
		categories = typedQuery.getResultList();		
		return categories;
	}
}
