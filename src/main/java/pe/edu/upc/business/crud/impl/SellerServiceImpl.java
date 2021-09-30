package pe.edu.upc.business.crud.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.business.crud.SellerService;
import pe.edu.upc.model.entity.Seller;
import pe.edu.upc.model.repository.JpaRepository;
import pe.edu.upc.model.repository.SellerRepository;


@Named
@ApplicationScoped
public class SellerServiceImpl implements SellerService {

	@Inject
	private SellerRepository sellerRepository;
	@Override
	public JpaRepository<Seller, Integer> getJpaRepository() {
		
		return sellerRepository;
	}
	@Override
	public List<Seller> findByNSeller(String nSeller) throws Exception {
		return sellerRepository.findByNSeller(nSeller);
	}
	@Override
	public List<Seller> findByNLastName(String nLastName) throws Exception {
		return sellerRepository.findByNLastName(nLastName);
	}

}
