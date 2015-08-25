package se.masv.jpa.service;

import java.util.HashMap;
import java.util.Map;

public abstract class NamedEntityQuery<T> 
{
	private final Map<String, Object> params = new HashMap<>();
	
	protected void setParams(String name, Object value)
	{
		params.put(name, value);
	}
	
	public Map<String, Object> getParams() 
	{
		return params;
	}
	
	public abstract String getName();
}
