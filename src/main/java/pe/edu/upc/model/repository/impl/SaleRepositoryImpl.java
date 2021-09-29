package pe.edu.upc.model.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pe.edu.upc.model.entity.Sale;
import pe.edu.upc.model.repository.SaleRepository;

public class SaleRepositoryImpl implements SaleRepository {

	@PersistenceContext (unitName = "AhorralandV1")
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public Optional<Sale> findById(Integer id) throws Exception {
		return findById(id, Sale.class);
	}

	@Override
	public List<Sale> findAll() throws Exception {
		String jpql = "SELECT sale FROM Sale sale";
		return findAll(Sale.class, jpql);
	}

}
