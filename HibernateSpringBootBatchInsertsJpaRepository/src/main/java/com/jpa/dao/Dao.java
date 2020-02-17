package com.jpa.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class Dao<T, ID extends Serializable> implements GenericDao<T, ID> {

	private static final Logger LOGGER = Logger.getLogger(Dao.class.getName());
	
	@Value("${spring.jpa.properties.hibernate.jdbc.batch_size}")
	private int BATCH_SIZE;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	@Override
	public <S extends T> void saveInBatchUsingSession(Iterable<S> entities) {
		if(entities == null) {
			throw new IllegalArgumentException("The given Iterable of entities cannot be null!");
		}
		
		int i = 0;
		
		Session session = entityManager.unwrap(Session.class);
		System.out.println(BATCH_SIZE);
		session.setJdbcBatchSize(BATCH_SIZE);
		
		for(S entity: entities) {
			entityManager.persist(entity);
			i++;
			if(i % session.getJdbcBatchSize() == 0 && i > 0) {
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

	@Override
	public <S extends T> void saveInBatchUsingSessionPerTransaction(Iterable<S> entities) {
		if(entities == null) {
			throw new IllegalArgumentException("The given Iterable of entities not be null!");
		}
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Session session = entityManager.unwrap(Session.class);
		session.setJdbcBatchSize(BATCH_SIZE);
		
		try {
			entityTransaction.begin();
			
			int i = 0;
			for(S entity : entities) {
				if(i % session.getJdbcBatchSize() == 0 && i > 0) {
					entityTransaction.commit();
					entityTransaction.begin();
					
					entityManager.clear();
				}
				
				entityManager.persist(entity);
				i++;
			}
			entityTransaction.commit();
		} catch(RuntimeException ex) {
			if(entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
			throw ex;
		} finally {
			entityManager.close();
		}
	}

}