package se.masv.jpa.service;

import java.util.List;

import se.masv.jpa.model.AbstractEntity;

public class JpaManager 
{	
	public static <E extends AbstractEntity> void persistEntity(E entity)
	{
		AbstractDao<E> dao = new Dao<>();
		dao.persistEntity(entity);
	}
	
	public static <E extends AbstractEntity> void removeEntity(E entity)
	{
		AbstractDao<E> dao = new Dao<>();
		dao.removeEntity(entity);
	}
	
	public static <E extends AbstractEntity> void updateEntity(E entity)
	{
		AbstractDao<AbstractEntity> dao = new Dao<>();
		dao.updateEntity(entity);
	}
	
	public static <E extends AbstractEntity> List<E> getEntity(NamedEntityQuery<E> namedEntityQuery, Class<E> classType)
	{
		AbstractDao<E> dao = new Dao<E>(classType);
		List<E> entities = dao.find(namedEntityQuery);
		return entities;
	}
}
