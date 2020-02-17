package com.jpa.repository;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Properties;

import javax.persistence.EntityManager;

import org.hibernate.dialect.Dialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.repository.BatchRepository;

@Transactional(readOnly = true)
public class BatchRepositoryImpl<T, ID extends Serializable>  
				extends SimpleJpaRepository<T, ID> implements BatchRepository<T, ID>{
	
	public BatchRepositoryImpl(Class<T> domainClass, EntityManager em) {
		super(domainClass, em);
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private EntityManager entityManager;

	

	@Override
	@Transactional
	public <S extends T> void saveInBatch(Iterable<S> entities) {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>. " + entities);
		if(entities == null) {
			throw new IllegalArgumentException();
		}
		
		int i = 0;
		
		for(S entity : entities) {
			entityManager.persist(entity);
			
			i++;
			if(i % batchSize() == 0 && i > 0) {
				entityManager.flush();
				entityManager.clear();
				i = 0 ;
			}
		}
		
		
		if(i > 0) {
			entityManager.flush();
			entityManager.clear();
		}
	}
	
	private static int batchSize() {
		
		int batchsize = Integer.valueOf(Dialect.DEFAULT_BATCH_SIZE);
		
		Properties configuration = new Properties();
		
		try(InputStream inputStream = BatchRepositoryImpl.class.getClassLoader()
				.getResourceAsStream("application.properties")) {
			configuration.load(inputStream);
		} catch(IOException ex) {
			return batchsize;
		}
		
		String batchSizeStr = configuration.getProperty("spring.jpa.properties.hibernate.jdbc.batch_size");
		if(batchSizeStr != null) {
			batchsize = Integer.valueOf(batchSizeStr);
		}
		
		return batchsize;
		
	}

}
