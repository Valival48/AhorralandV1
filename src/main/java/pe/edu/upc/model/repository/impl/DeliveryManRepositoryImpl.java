package pe.edu.upc.model.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pe.edu.upc.model.entity.DeliveryMan;
import pe.edu.upc.model.repository.DeliveryManRepository;

public class DeliveryManRepositoryImpl implements DeliveryManRepository{

	@PersistenceContext (unitName = "AhorralandV1")
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public Optional<DeliveryMan> findById(Integer id) throws Exception {
		return findById(id, DeliveryMan.class);
	}

	@Override
	public List<DeliveryMan> findAll() throws Exception {
		String jpql = "SELECT deliveryMan FROM DeliveryMan deliveryMan";
		return findAll(DeliveryMan.class, jpql);
	}

}
