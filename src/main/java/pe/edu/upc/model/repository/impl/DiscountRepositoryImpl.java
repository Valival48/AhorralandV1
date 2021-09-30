package pe.edu.upc.model.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pe.edu.upc.model.entity.Discount;
import pe.edu.upc.model.repository.DiscountRepository;
@Named
@ApplicationScoped
public class DiscountRepositoryImpl implements DiscountRepository {

	@PersistenceContext (unitName = "AhorralandV1")
	private EntityManager entityManager;
	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public Optional<Discount> findById(Integer id) throws Exception {
		return findById(id, Discount.class);
	}

	@Override
	public List<Discount> findAll() throws Exception {
		String jpql = "SELECT discount FROM Discount discount";
		return findAll(Discount.class, jpql);
	}

}
