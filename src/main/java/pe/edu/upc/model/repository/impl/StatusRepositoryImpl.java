package pe.edu.upc.model.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pe.edu.upc.model.entity.Status;
import pe.edu.upc.model.repository.StatusRepository;

public class StatusRepositoryImpl implements StatusRepository {

	@PersistenceContext (unitName = "AhorralandV1")
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public Optional<Status> findById(Integer id) throws Exception {
		return findById(id, Status.class);
	}

	@Override
	public List<Status> findAll() throws Exception {
		String jpql = "SELECT status FROM Status status";
		return findAll(Status.class, jpql);
	}

}
