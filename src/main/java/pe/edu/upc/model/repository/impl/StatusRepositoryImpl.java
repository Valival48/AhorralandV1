package pe.edu.upc.model.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.edu.upc.model.entity.Status;
import pe.edu.upc.model.repository.StatusRepository;
@Named
@ApplicationScoped
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

	@Override
	public List<Status> findByNombreStatus(String nombrestatus) throws Exception {
		return findByField("NStatus", nombrestatus);
	}
	private List<Status> findByField(String field, String value) throws Exception {
		List<Status> status = new ArrayList<>();
		String jpql = "SELECT st FROM Status st WHERE st." + field + " = '" + value + "'";	
		TypedQuery<Status> typedQuery = getEntityManager().createQuery(jpql, Status.class); //field q es el campo de la bd y value el atributo
		status = typedQuery.getResultList();		
		return status;
	}

}
