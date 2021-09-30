package pe.edu.upc.model.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.edu.upc.model.entity.Shipping;
import pe.edu.upc.model.repository.ShippingRepository;
@Named
@ApplicationScoped
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

	@Override
	public List<Shipping> findByCity(String direction) throws Exception {
		return findByField("TDestinationAdress", direction);
	}

	private List<Shipping> findByField(String field, String value) throws Exception {
		List<Shipping> shipping = new ArrayList<>();
		String jpql = "SELECT shi FROM Status shi WHERE shi." + field + " = '" + value + "'";	
		TypedQuery<Shipping> typedQuery = getEntityManager().createQuery(jpql, Shipping.class); //field q es el campo de la bd y value el atributo
		shipping = typedQuery.getResultList();		
		return shipping;
	}
}
