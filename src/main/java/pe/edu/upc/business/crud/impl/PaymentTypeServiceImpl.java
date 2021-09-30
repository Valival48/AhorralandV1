package pe.edu.upc.business.crud.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.business.crud.PaymentTypeService;
import pe.edu.upc.model.entity.PaymentType;
import pe.edu.upc.model.repository.JpaRepository;
import pe.edu.upc.model.repository.PaymentTypeRepository;
@Named
@ApplicationScoped
public class PaymentTypeServiceImpl implements PaymentTypeService {

	@Inject
	private PaymentTypeRepository paymentTypeRepository;
	@Override
	public JpaRepository<PaymentType, Integer> getJpaRepository() {
		return paymentTypeRepository;
	}
	@Override
	public List<PaymentType> findByNPaymentType(String name) throws Exception {
		return paymentTypeRepository.findByNPaymentType(name);
	}

}
