package pe.edu.upc.business.crud.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.business.crud.StatusService;
import pe.edu.upc.model.entity.Status;
import pe.edu.upc.model.repository.JpaRepository;
import pe.edu.upc.model.repository.StatusRepository;

@Named
@ApplicationScoped
public class StatusServiceImpl implements StatusService{

	@Inject
	private StatusRepository statusRepository;
	
	
	@Override
	public JpaRepository<Status, Integer> getJpaRepository() {
		return statusRepository;
	}


	@Override
	public List<Status> findByNombreStatus(String nombrestatus) throws Exception {
		// TODO Auto-generated method stub
		return statusRepository.findByNombreStatus(nombrestatus);
	}
	
}

