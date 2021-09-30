package pe.edu.upc.business.crud.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.business.crud.SaleService;
import pe.edu.upc.model.entity.Sale;
import pe.edu.upc.model.repository.JpaRepository;
import pe.edu.upc.model.repository.SaleRepository;

@Named
@ApplicationScoped
public class SaleServiceImpl implements SaleService {

	@Inject
	private SaleRepository saleRepository;
	
	@Override
	public JpaRepository<Sale, Integer> getJpaRepository() {
		return saleRepository;
	}

}
