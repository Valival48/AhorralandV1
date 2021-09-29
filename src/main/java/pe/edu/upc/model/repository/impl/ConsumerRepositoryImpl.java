package pe.edu.upc.model.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pe.edu.upc.model.entity.Consumer;
import pe.edu.upc.model.repository.ConsumerRepository;

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

}
