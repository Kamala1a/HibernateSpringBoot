package com.jpa.dao;

import java.io.Serializable;

public interface GenericDao<T, ID extends Serializable> {
	
	<S extends T> void saveInBatchUsingSession(Iterable<S> entities);
	
	<S extends T> void saveInBatchUsingSessionPerTransaction(Iterable<S> entities);
	
}
