package se.masv.jpa.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import se.masv.jpa.model.AbstractEntity;

public class Dao<T extends AbstractEntity> extends AbstractDao<T>{
	
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("EmployeeService");
	private Class<T> classType;
	
	public Dao(Class<T> classType) 
	{
		this.classType = classType;
	}
	
	public Dao(){}
	
	@Override
	protected EntityManager getEntityManager() 
	{
		return factory.createEntityManager();
	}

	@Override
	protected Class<T> getEntityClass() 
	{
		return this.classType;
	}

}
