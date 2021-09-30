package pe.edu.upc.model.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.edu.upc.model.entity.Seller;
import pe.edu.upc.model.repository.SellerRepository;
@Named
@ApplicationScoped
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

	@Override
	public List<Seller> findByNSeller(String nSeller) throws Exception {
		return findByField("NSeller", nSeller);
	}

	@Override
	public List<Seller> findByNLastName(String nLastName) throws Exception {
		return findByField("NLastname", nLastName);
	}
	
	private List<Seller> findByField(String field, String value) throws Exception {
		List<Seller> sellers = new ArrayList<>();
		String jpql = "SELECT sel FROM Status sel WHERE sel." + field + " = '" + value + "'";	
		TypedQuery<Seller> typedQuery = getEntityManager().createQuery(jpql, Seller.class); //field q es el campo de la bd y value el atributo
		sellers = typedQuery.getResultList();		
		return sellers;
	}
}
