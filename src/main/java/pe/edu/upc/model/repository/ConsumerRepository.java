package pe.edu.upc.model.repository;

import java.util.List;

import pe.edu.upc.model.entity.Consumer;


public interface ConsumerRepository extends JpaRepository<Consumer, Integer> {
	List<Consumer> findByNName(String name)throws Exception;
	List<Consumer> findByNLastname(String lastName)throws Exception;
}
