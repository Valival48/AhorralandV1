package pe.edu.upc.business.crud.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.business.crud.DeliveryManService;
import pe.edu.upc.model.entity.DeliveryMan;
import pe.edu.upc.model.repository.DeliveryManRepository;
import pe.edu.upc.model.repository.JpaRepository;
@Named
@ApplicationScoped
public class DeliveryManServiceImpl implements DeliveryManService {

	@Inject
	private DeliveryManRepository deliveryManRepository;
	@Override
	public JpaRepository<DeliveryMan, Integer> getJpaRepository() {
		return deliveryManRepository;
	}
	@Override
	public List<DeliveryMan> findByNDeliveryMan(String nDeliveryMan) throws Exception {
		return deliveryManRepository.findByNDeliveryMan(nDeliveryMan);
	}

}
