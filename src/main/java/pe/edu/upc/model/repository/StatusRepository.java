package pe.edu.upc.model.repository;

import java.util.List;

import pe.edu.upc.model.entity.Status;

public interface StatusRepository extends JpaRepository<Status, Integer>{
	List<Status>findByNombreStatus(String nombrestatus) throws Exception;
}
