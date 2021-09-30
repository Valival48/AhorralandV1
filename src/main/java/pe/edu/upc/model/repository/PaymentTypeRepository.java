package pe.edu.upc.model.repository;

import java.util.List;

import pe.edu.upc.model.entity.PaymentType;


public interface PaymentTypeRepository extends JpaRepository<PaymentType, Integer>{
	List<PaymentType> findByNPaymentType(String name)throws Exception;
}
