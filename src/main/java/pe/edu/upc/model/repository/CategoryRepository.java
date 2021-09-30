package pe.edu.upc.model.repository;

import java.util.List;

import pe.edu.upc.model.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
	List<Category> findByNType(String type)throws Exception;
}
