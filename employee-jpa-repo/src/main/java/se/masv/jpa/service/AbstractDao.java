package se.masv.jpa.service;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import se.masv.jpa.model.AbstractEntity;

public abstract class AbstractDao<T extends AbstractEntity>
{
	EntityManager manager;
	
	public List<T> find(NamedEntityQuery<T> namedEntityQuery)
	{
		Map<String, ?> params = namedEntityQuery.getParams();
		String queryName = namedEntityQuery.getName();
		List<T> entities = findByNamedQuery(queryName, params);
		manager.close();
		return entities;
	}

	private List<T> findByNamedQuery(String queryName, Map<String, ?> params) 
	{
		TypedQuery<T> query = getNamedQuery(queryName);
		query = applyQueryParams(query, params);
		return query.getResultList();
	}


	private TypedQuery<T> getNamedQuery(String queryName) 
	{
		manager = getEntityManager();
		TypedQuery<T> query = manager.createNamedQuery(queryName, getEntityClass());
		return query;
	}

	private TypedQuery<T> applyQueryParams(TypedQuery<T> query, Map<String, ?> params) 
	{
		for (Map.Entry<String, ?> param : params.entrySet())
		{
			query.setParameter(param.getKey(), param.getValue());
		}
		
		return query;
	}
	
	public void persistEntity(T entity)
	{
		EntityManager manager = getEntityManager();
		manager.getTransaction().begin();
		manager.persist(entity);
		manager.getTransaction().commit();
		manager.close();
	}
	
	@SuppressWarnings("unchecked")
	public void removeEntity(T entity)
	{
		EntityManager manager = getEntityManager();
		entity = (T) manager.find(entity.getClass(), entity.getId());
		
		if (entity != null)
		{
			manager.getTransaction().begin();
			manager.remove(entity);
			manager.getTransaction().commit();
		}
		
		manager.close();
	}
	
	public void updateEntity(T entity)
	{
		EntityManager manager = getEntityManager();
		
		if (entity != null)
		{
			manager.getTransaction().begin();
			entity = manager.merge(entity);
			manager.getTransaction().commit();
		}

		manager.close();
	}
	
	protected abstract EntityManager getEntityManager();
	protected abstract Class<T> getEntityClass();
}
