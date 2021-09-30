package pe.edu.upc.business.crud;

import java.util.List;

import pe.edu.upc.model.entity.DeliveryMan;

public interface DeliveryManService extends CrudService<DeliveryMan, Integer> {
	List<DeliveryMan> findByNDeliveryMan(String nDeliveryMan)throws Exception;
}
