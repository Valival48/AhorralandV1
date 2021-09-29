package pe.edu.upc.model.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pe.edu.upc.model.entity.Shipping;
import pe.edu.upc.model.repository.ShippingRepository;

public class ShippingRepositoryImpl implements ShippingRepository{

	@PersistenceContext (unitName = "AhorralandV1")
	private EntityManager entityManager;
	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public Optional<Shipping> findById(Integer id) throws Exception {
		return findById(id, Shipping.class);
	}

	@Override
	public List<Shipping> findAll() throws Exception {
		String jpql = "SELECT shipping FROM Shipping shipping";
		return findAll(Shipping.class, jpql);
	}

}
