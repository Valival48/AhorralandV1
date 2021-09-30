package pe.edu.upc.business.crud;

import java.util.List;

import pe.edu.upc.model.entity.PaymentType;

public interface PaymentTypeService extends CrudService<PaymentType, Integer> {
	List<PaymentType> findByNPaymentType(String name)throws Exception;
}
