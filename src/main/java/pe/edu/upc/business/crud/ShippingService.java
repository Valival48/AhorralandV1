package pe.edu.upc.business.crud;

import java.util.List;

import pe.edu.upc.model.entity.Shipping;

public interface ShippingService extends CrudService<Shipping, Integer> {
	List<Shipping> findByCity(String direction)throws Exception;
}
