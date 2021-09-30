package pe.edu.upc.business.crud;

import java.util.List;

import pe.edu.upc.model.entity.Category;

public interface CategoryService extends CrudService<Category, Integer> {
	List<Category> findByNType(String type)throws Exception;
}
