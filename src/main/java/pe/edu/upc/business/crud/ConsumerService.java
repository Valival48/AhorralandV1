package pe.edu.upc.business.crud;

import java.util.List;

import pe.edu.upc.model.entity.Consumer;

public interface ConsumerService extends CrudService<Consumer, Integer>{
	List<Consumer> findByNName(String name)throws Exception;
	List<Consumer> findByNLastname(String lastName)throws Exception;
}
