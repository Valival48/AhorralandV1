package pe.edu.upc.business.crud.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.business.crud.DiscountService;
import pe.edu.upc.model.entity.Discount;
import pe.edu.upc.model.repository.DiscountRepository;
import pe.edu.upc.model.repository.JpaRepository;
@Named
@ApplicationScoped
public class DiscountServiceImpl implements DiscountService {

	@Inject
	private DiscountRepository discountRepository;
	@Override
	public JpaRepository<Discount, Integer> getJpaRepository() {
		return discountRepository;
	}

}
