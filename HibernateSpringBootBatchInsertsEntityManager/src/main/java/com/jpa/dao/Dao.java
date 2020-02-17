package com.jpa.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class Dao<T, ID extends Serializable> implements GenericDao<T, ID>{

	@Value("${spring.jpa.properties.hibernate.jdbc.batch_size}")
	private int batchSize;
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public <R extends T> void saveInBatch(Iterable<R> entities) {
		if(entities == null) {
			throw new IllegalArgumentException();
		}
		int i = 0;
		
		for(R entity:entities) {
			entityManager.persist(entity);
			i++;
			if(i % batchSize == 0 && i > 0) {
				entityManager.flush();
				entityManager.clear();
				i = 0;
			}
		}
		if(i > 0) {
			entityManager.flush();
			entityManager.clear();
		}
	}

}
