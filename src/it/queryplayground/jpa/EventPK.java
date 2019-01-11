/*
 * 
 */
package it.queryplayground.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

// TODO: Auto-generated Javadoc
/**
 * The primary key class for the event database table.
 * 
 */
@Embeddable
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class EventPK implements Serializable {
	
	/** The Constant serialVersionUID. */
	// default serial version id, required for serializable classes.
	@XmlTransient
	private static final long serialVersionUID = 1L;

	/** The id. */
	@TableGenerator(name = "eventgen", table = "actkeygen", pkColumnName = "name", pkColumnValue = "event", valueColumnName = "value", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "eventgen")
	@Column(name = "id")
	private long id;

	/** The activity id. */
	@Column(name = "activity_id")
	private long activityId;

	/**
	 * Instantiates a new event PK.
	 */
	public EventPK() {
	}

	/**
	 * Instantiates a new event PK.
	 *
	 * @param id the id
	 * @param activityId the activity id
	 */
	public EventPK(long id, long activityId) {
		super();
		this.id = id;
		this.activityId = activityId;
	}

	/**
	 * Instantiates a new event PK.
	 *
	 * @param activity the activity
	 */
	public EventPK(long activity) {
		activityId = activity;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getId() {
		return this.id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Gets the activity id.
	 *
	 * @return the activity id
	 */
	public long getActivityId() {
		return this.activityId;
	}

	/**
	 * Sets the activity id.
	 *
	 * @param activityId the new activity id
	 */
	public void setActivityId(long activityId) {
		this.activityId = activityId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EventPK)) {
			return false;
		}
		EventPK castOther = (EventPK) other;
		return this.id == castOther.id && this.activityId == castOther.activityId;

	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + new Long(this.id).hashCode();
		hash = hash * prime + new Long(this.activityId).hashCode();

		return hash;
	}
}