package pe.edu.upc.model.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pe.edu.upc.model.entity.IdentificationType;
import pe.edu.upc.model.repository.IdentificationTypeRepository;

public class IdentificationTypeRepositoryImpl implements IdentificationTypeRepository {

	@PersistenceContext (unitName = "AhorralandV1")
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public Optional<IdentificationType> findById(Integer id) throws Exception {
		return findById(id, IdentificationType.class);
	}

	@Override
	public List<IdentificationType> findAll() throws Exception {
		String jpql = "SELECT identificationType FROM IdentificationType identificationType";
		return findAll(IdentificationType.class, jpql);
	}

}
