package it.queryplaground.runners;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import it.queryplayground.jpa.DataManager;
import it.queryplayground.jpa.EventPK;
import it.queryplayground.jpa.PolyEvent;
import it.queryplayground.jpa.PolyEventBody;


public class BatchInsert {
	private static final Logger log = Logger.getAnonymousLogger();

	public static void main(String[] args) {


		Random rnd = new Random();
		rnd.setSeed(1109222111);

		final int SIZE = 100;
		
		long startTime = System.nanoTime();    

		javax.transaction.TransactionManager tx = com.arjuna.ats.jta.TransactionManager.transactionManager();
		try {


			tx.begin();
			
			DataManager dm = new DataManager();
			for(int i=0;i<SIZE;i++) {
				PolyEvent event = new PolyEvent();
				event.setTitle("Title");
				EventPK id = new EventPK(1);
				
				id.setId(rnd.nextLong());
				
				event.setId(id);
				PolyEventBody body = new PolyEventBody();
				body.setName("polyevent body name");
				body.setId(id.getId());
				event.setPolyEventBody(body);
				event.setUsername("Username");
				System.out.println("polyevent" + event.getTitle());
				
				dm.save(event); //this method creates an entity manager transaction 
			}
			
			
			tx.commit();
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		long estimatedTime = System.nanoTime() - startTime;

		System.out.println("saved " +SIZE+ " entities in " + TimeUnit.NANOSECONDS.toMillis(estimatedTime));

	}
}
