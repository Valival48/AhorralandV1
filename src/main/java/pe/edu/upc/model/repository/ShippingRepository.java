package pe.edu.upc.model.repository;

import java.util.List;

import pe.edu.upc.model.entity.Shipping;

public interface ShippingRepository extends JpaRepository<Shipping, Integer> {
	List<Shipping> findByCity(String direction)throws Exception;
}
