package pe.edu.upc.business.crud;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import pe.edu.upc.model.repository.JpaRepository;

public interface CrudService<T, ID> {
	
	JpaRepository<T, ID> getJpaRepository();
	
	@Transactional
	default T create(T entity) throws Exception {
		return getJpaRepository().save(entity);
	}
	
	@Transactional
	default T update(T entity) throws Exception {
		return getJpaRepository().update(entity);
	}
	
	default Optional<T> findById(ID id) throws Exception {
		return getJpaRepository().findById(id);
	}
	
	default List<T> getAll() throws Exception {
		return getJpaRepository().findAll();
	}
	
	@Transactional
	default void deleteById(ID id) throws Exception {
		getJpaRepository().deleteById(id);
	}
}
