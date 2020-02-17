package com.jpa.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class Dao<T, ID extends Serializable> implements GenericDao<T, ID>{

	@Value("${spring.jpa.properties.hibernate.jdbc.batch_size}")
	private int batchSize;
	
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	@Override
	public <S extends T> void saveInBatch(Iterable<S> entities) {
		if(entities == null) {
			throw new IllegalArgumentException();
		}
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		try {
			entityTransaction.begin();
			
			int i = 0;
			for(S entity : entities) {
				if(i % batchSize == 0 && i > 0) {
					entityTransaction.commit();
					entityTransaction.begin();
					entityManager.clear();
				}
				entityManager.persist(entity);
				i++;
			}
			entityTransaction.commit();
		} catch (RuntimeException e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            
            throw e;
        } finally {
            entityManager.close();
        }
	}

}
