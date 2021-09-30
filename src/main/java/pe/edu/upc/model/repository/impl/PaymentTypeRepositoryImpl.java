package pe.edu.upc.model.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.edu.upc.model.entity.PaymentType;
import pe.edu.upc.model.repository.PaymentTypeRepository;
@Named
@ApplicationScoped
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

	@Override
	public List<PaymentType> findByNPaymentType(String name) throws Exception {
		return findByField("NPaymentType", name);
		
	}
	private List<PaymentType> findByField(String field, String value) throws Exception {
		List<PaymentType> paymentTypes = new ArrayList<>();
		String jpql = "SELECT pt FROM Status pt WHERE pt." + field + " = '" + value + "'";	
		TypedQuery<PaymentType> typedQuery = getEntityManager().createQuery(jpql, PaymentType.class); //field q es el campo de la bd y value el atributo
		paymentTypes = typedQuery.getResultList();		
		return paymentTypes;
	}

}
