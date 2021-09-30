package pe.edu.upc.business.crud;

import java.util.List;

import pe.edu.upc.model.entity.Status;

public interface StatusService extends CrudService<Status, Integer> {
	List<Status>findByNombreStatus(String nombrestatus) throws Exception;
}
