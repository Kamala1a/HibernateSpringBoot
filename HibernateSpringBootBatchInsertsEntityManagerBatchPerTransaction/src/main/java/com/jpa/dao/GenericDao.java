package com.jpa.dao;

import java.io.Serializable;

public interface GenericDao<T, ID extends Serializable> {

	<S extends T> void saveInBatch(Iterable<S> entities);
	
}
