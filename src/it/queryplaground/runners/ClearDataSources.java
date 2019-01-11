package it.queryplaground.runners;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import it.queryplayground.jpa.DataManager;
import it.queryplayground.jpa.PolyEvent;



public class ClearDataSources {

	private static final Logger log = Logger.getAnonymousLogger();

	public static void main(String[] args) {

		
		
		long startTime = System.nanoTime();    

		javax.transaction.TransactionManager tx = com.arjuna.ats.jta.TransactionManager.transactionManager();
		try {


			tx.begin();
			
		
			DataManager dm = new DataManager();
			EntityManager em = dm.getFactory().createEntityManager();
			
	        Query query = em.createQuery("FROM Event e WHERE e.type=:type");
	            	query.setParameter("type","PolyEvent");
	        
            	List results = query.getResultList();
            	Iterator it = results.iterator();

            	while(it.hasNext()){
            		PolyEvent o = (PolyEvent) it.next();
        
            		System.out.println("removing: " + o.getTitle());
            		
            		dm.delete(o);

            	}
			tx.commit();
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		long estimatedTime = System.nanoTime() - startTime;

		System.out.println("deleted all PolyEvent entities in " + TimeUnit.NANOSECONDS.toMillis(estimatedTime));

	}

}
