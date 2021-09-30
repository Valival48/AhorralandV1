package pe.edu.upc.model.repository;

import java.util.List;

import pe.edu.upc.model.entity.DeliveryMan;

public interface DeliveryManRepository extends JpaRepository<DeliveryMan, Integer>{
	List<DeliveryMan> findByNDeliveryMan(String nDeliveryMan)throws Exception;
}
