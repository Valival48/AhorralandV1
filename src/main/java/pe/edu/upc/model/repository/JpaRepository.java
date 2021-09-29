package pe.edu.upc.model.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public interface JpaRepository <T, ID> {
	
	EntityManager getEntityManager();
	
	default T save (T entity)	throws Exception {
		getEntityManager().persist(entity);
		return entity;
	}
	default T update (T entity)throws Exception{
		return getEntityManager().merge(entity);
		
	}
	Optional<T> findById(ID id) throws Exception;
	
	default Optional<T> findById(ID id, Class<T>entityClass) throws Exception{
		Optional<T> optional= Optional.empty();
		T entity = getEntityManager().find(entityClass, id);
		if(entity !=null) {
			optional=Optional.of(entity);
		}			
		return optional;
	}
	List<T>findAll() throws Exception;
	
	default List<T>findAll(Class<T>entityClass,String jpql) throws Exception{
		List<T> entities = new ArrayList<T>();
		TypedQuery<T> typedQuery= getEntityManager().createQuery(jpql, entityClass);
		entities=typedQuery.getResultList();
		
		return entities;
	}
	default void deleteById(ID id)throws Exception{
		Optional <T> optional = findById(id);
		if(optional.isPresent()) {
			getEntityManager().remove(optional.get());
		}		
	}
}
