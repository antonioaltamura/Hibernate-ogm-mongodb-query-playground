package it.queryplayground.jpa;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Objects;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PostLoad;
import javax.persistence.PostRemove;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Query;
import javax.persistence.Transient;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


/** This Class is a first test to make the Event persistent in Mysql and its body in Mongodb
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@DiscriminatorValue("PolyEvent")
public class PolyEvent extends Event {

	
	@Transient
	private static EntityManager em = Persistence.createEntityManagerFactory("mongoEM").createEntityManager();

	
	/**
	 * 
	 */
	@Transient
	@XmlElement
	private PolyEventBody polyEventBody;
	/**
	 * 
	 */
	@Transient
	private final String workingTable = ("MyWorkingCopy");
	/**
	 * 
	 */
	@Transient
	private final String instance = ("MyInstance");



	/**
	 * 
	 */
	public PolyEvent() {
	}


	/**
	 * 
	 * @return
	 */
	public PolyEventBody getDCStorageBody() {
		return this.polyEventBody;
	}

	
	@PostLoad
	public void loadBody()  {
		if (polyEventBody == null) {
			Query query = em.createQuery("FROM PolyEventBody e WHERE id=:id");
			query.setParameter("id",this.getId().getId());
			PolyEventBody r = (PolyEventBody) query.getSingleResult();
			setPolyEventBody(r);


		}

	}

	
	@PrePersist
	@PreUpdate
	public void persistBody() {
		if (polyEventBody != null)  {
			try {
				em.persist(this.polyEventBody);

			} catch (Exception e) {
				e.printStackTrace();

			}
			super.setBody(this.polyEventBody.getId() + ""); //this is the Event id.id 
		}


	}
	
	@PostRemove
	public void remove() {
		em.remove(this.polyEventBody);

	}
	/**
	 * 
	 * @return
	 */
	public String getName() {
		return this.polyEventBody.getName();
	}


	/**
	 * 
	 * @return
	 */
	public String getWorkingTable() {
		return workingTable;
	}

	/**
	 * 
	 * @return
	 */
	public String getInstance() {
		return instance;
	}


	

	public PolyEventBody getPolyEventBody() {
		return polyEventBody;
	}


	public void setPolyEventBody(PolyEventBody polyEventBody) {
		this.polyEventBody = polyEventBody;
	}

}
