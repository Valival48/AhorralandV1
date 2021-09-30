package pe.edu.upc.business.crud;

import java.util.List;

import pe.edu.upc.model.entity.Seller;

public interface SellerService extends CrudService<Seller, Integer> {
	List<Seller> findByNSeller(String nSeller)throws Exception;
	List<Seller> findByNLastName(String nLastName)throws Exception;
}
