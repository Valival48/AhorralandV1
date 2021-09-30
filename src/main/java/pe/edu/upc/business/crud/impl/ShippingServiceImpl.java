package pe.edu.upc.business.crud.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.business.crud.ShippingService;
import pe.edu.upc.model.entity.Shipping;
import pe.edu.upc.model.repository.JpaRepository;
import pe.edu.upc.model.repository.ShippingRepository;

@Named
@ApplicationScoped
public class ShippingServiceImpl implements ShippingService {

	@Inject
	private ShippingRepository shippingRepository;
	@Override
	public JpaRepository<Shipping, Integer> getJpaRepository() {
		return shippingRepository;
	}
	@Override
	public List<Shipping> findByCity(String direction) throws Exception {
		return shippingRepository.findByCity(direction);
	}

}
