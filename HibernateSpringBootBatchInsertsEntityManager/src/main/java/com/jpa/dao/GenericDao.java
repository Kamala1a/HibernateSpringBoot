package com.jpa.dao;

import java.io.Serializable;

public interface GenericDao<T, ID extends Serializable> {

	<R extends T> void saveInBatch(Iterable<R> entities);
	
}
