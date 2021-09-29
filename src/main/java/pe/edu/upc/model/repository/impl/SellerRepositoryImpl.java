package pe.edu.upc.model.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pe.edu.upc.model.entity.Seller;
import pe.edu.upc.model.repository.SellerRepository;

public class SellerRepositoryImpl implements SellerRepository{

	@PersistenceContext (unitName = "AhorralandV1")
	private EntityManager entityManager;
	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public Optional<Seller> findById(Integer id) throws Exception {
		return findById(id, Seller.class);
	}

	@Override
	public List<Seller> findAll() throws Exception {
		String jpql = "SELECT seller FROM Seller seller";
		return findAll(Seller.class, jpql);
	}

}
