package pe.edu.upc.business.crud.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.business.crud.ConsumerService;
import pe.edu.upc.model.entity.Consumer;
import pe.edu.upc.model.repository.ConsumerRepository;
import pe.edu.upc.model.repository.JpaRepository;
@Named
@ApplicationScoped
public class ConsumerServerImpl implements ConsumerService {

	@Inject
	private ConsumerRepository consumerRepository;
	@Override
	public JpaRepository<Consumer, Integer> getJpaRepository() {
		return consumerRepository;
	}
	@Override
	public List<Consumer> findByNName(String name) throws Exception {
		return consumerRepository.findByNName(name);
	}
	@Override
	public List<Consumer> findByNLastname(String lastName) throws Exception {
		return consumerRepository.findByNLastname(lastName);
	}

}
