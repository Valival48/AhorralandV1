package pe.edu.upc.business.crud.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.business.crud.CategoryService;
import pe.edu.upc.model.entity.Category;
import pe.edu.upc.model.repository.CategoryRepository;
import pe.edu.upc.model.repository.JpaRepository;
@Named
@ApplicationScoped
public class CategoryServiceImpl implements CategoryService {

	@Inject
	private CategoryRepository categoryRepository;
	@Override
	public JpaRepository<Category, Integer> getJpaRepository() {
		return categoryRepository;
	}
	@Override
	public List<Category> findByNType(String type) throws Exception {
		return categoryRepository.findByNType(type);
	}

}
