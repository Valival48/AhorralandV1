package pe.edu.upc.model.repository;

import java.util.List;

import pe.edu.upc.model.entity.Seller;


public interface SellerRepository extends JpaRepository<Seller, Integer> {
	List<Seller> findByNSeller(String nSeller)throws Exception;
	List<Seller> findByNLastName(String nLastName)throws Exception;
}
