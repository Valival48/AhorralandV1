package pe.edu.upc.model.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pe.edu.upc.model.entity.PaymentType;
import pe.edu.upc.model.repository.PaymentTypeRepository;

public class PaymentTypeRepositoryImpl implements PaymentTypeRepository{

	@PersistenceContext (unitName = "AhorralandV1")
	private EntityManager entityManager;
	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public Optional<PaymentType> findById(Integer id) throws Exception {
		return findById(id, PaymentType.class);
	}

	@Override
	public List<PaymentType> findAll() throws Exception {
		String jpql = "SELECT paymentType FROM PaymentType paymentType";
		return findAll(PaymentType.class, jpql);
	}

}
