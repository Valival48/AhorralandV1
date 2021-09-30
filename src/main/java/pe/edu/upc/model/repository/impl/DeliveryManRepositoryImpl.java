package pe.edu.upc.model.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.edu.upc.model.entity.DeliveryMan;
import pe.edu.upc.model.repository.DeliveryManRepository;
@Named
@ApplicationScoped
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

	@Override
	public List<DeliveryMan> findByNDeliveryMan(String nDeliveryMan) throws Exception {
		return findByField("NDeliveryMan", nDeliveryMan);
	}
	private List<DeliveryMan> findByField(String field, String value) throws Exception {
		List<DeliveryMan> deliveryman = new ArrayList<>();
		String jpql = "SELECT dm FROM Status dm WHERE dm." + field + " = '" + value + "'";	
		TypedQuery<DeliveryMan> typedQuery = getEntityManager().createQuery(jpql, DeliveryMan.class); //field q es el campo de la bd y value el atributo
		deliveryman = typedQuery.getResultList();		
		return deliveryman;
	}

}
