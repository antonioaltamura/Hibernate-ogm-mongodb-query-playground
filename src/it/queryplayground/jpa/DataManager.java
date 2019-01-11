package it.queryplayground.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class DataManager {

	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysqlEM");


	public DataManager() {
	}

	public static EntityManagerFactory getFactory() {
		return factory;
	}

	public static void setFactory(EntityManagerFactory factory) {
		DataManager.factory = factory;
	}
	public void save(Object entity) throws Exception {
		EntityManager em = factory.createEntityManager();
		try {
			EntityTransaction t = em.getTransaction();
			try {
				t.begin();
				
				em.persist(entity);
				t.commit();
			} catch (Exception ex) {
				throw new Exception("Error saving bean " + entity, ex);
			} finally {
				if (t.isActive()) {
					t.rollback();
				}
			}
		} finally {
			em.close();
		}
	}
	public void delete(Object entity) throws Exception {
		EntityManager em = getFactory().createEntityManager();
		try {
			EntityTransaction t = em.getTransaction();
			try {
				t.begin();
				
				em.remove(em.merge(entity));
				t.commit();
			} catch (Exception ex) {
				throw new Exception("Error deleting bean", ex);
			} finally {
				if (t.isActive()) {
					t.rollback();
				}
			}
		} finally {
			em.close();
		}
	}

}
