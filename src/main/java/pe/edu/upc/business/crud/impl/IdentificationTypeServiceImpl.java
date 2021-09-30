package pe.edu.upc.business.crud.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.business.crud.IdentificationTypeService;
import pe.edu.upc.model.entity.IdentificationType;
import pe.edu.upc.model.repository.IdentificationTypeRepository;
import pe.edu.upc.model.repository.JpaRepository;
@Named
@ApplicationScoped
public class IdentificationTypeServiceImpl implements IdentificationTypeService {

	@Inject
	private IdentificationTypeRepository identificationTypeRepository;
	@Override
	public JpaRepository<IdentificationType, Integer> getJpaRepository() {
		return identificationTypeRepository;
	}

}
