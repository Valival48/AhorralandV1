package pe.edu.upc.model.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.edu.upc.model.entity.Consumer;
import pe.edu.upc.model.repository.ConsumerRepository;
@Named
@ApplicationScoped
public class ConsumerRepositoryImpl implements ConsumerRepository {

	@PersistenceContext (unitName = "AhorralandV1")
	private EntityManager entityManager;
	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public Optional<Consumer> findById(Integer id) throws Exception {
		return findById(id, Consumer.class);
	}

	@Override
	public List<Consumer> findAll() throws Exception {
		String jpql = "SELECT consumer FROM Consumer consumer";
		return findAll(Consumer.class, jpql);
	}

	@Override
	public List<Consumer> findByNName(String name) throws Exception {
		return findByField("NName", name);
	}

	@Override
	public List<Consumer> findByNLastname(String lastName) throws Exception {
		return findByField("NLastname", lastName);
	}
	private List<Consumer> findByField(String field, String value) throws Exception {
		List<Consumer> consumers = new ArrayList<>();
		String jpql = "SELECT cons FROM Status cons WHERE cons." + field + " = '" + value + "'";	
		TypedQuery<Consumer> typedQuery = getEntityManager().createQuery(jpql, Consumer.class); //field q es el campo de la bd y value el atributo
		consumers = typedQuery.getResultList();		
		return consumers;
	}
}
