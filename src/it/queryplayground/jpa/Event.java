package it.queryplayground.jpa;

/*
 * 
 */

import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;


//@MappedSuperclass
@Entity
@Table(name = "event")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public abstract class Event implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@EmbeddedId
	private EventPK id;

	/** The body. */
	@Lob
	private String body;

	/** The title. */
	private String title = "";

	/** The user id. */
	@Column(name = "user_id")
	private int userId;

	/** The username. */
	private String username = "";

	/** The type. */
	private String type;

	/** The revision. */
	private String revision = "0.0";

	/** The date. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date date = new Date();

	/** The enddate. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date enddate;

	/** The sys date. */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "sys_date")
	private Date sysDate = new Date();

	/** The groups. */
	@Lob
	@Column(name = "GROUPS")
	private String groups;

	/** The code. */
	private String code;

	/** The undelable. */
	private int undelable;

	/** The bcs. */
	@Lob
	private String bcs;

	/** The teams. */
	private String teams;

	/** The disable revision. */
	@Column(name = "disable_revision")
	private int disableRevision;

	/** The to. */
	@Column(name = "to_users")
	@Lob
	private String to;

	/** The syncdate. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date syncdate = new Date();

	/** The lastrevision. */
	private String lastrevision;

	/** The metadata. */
	private String metadata;

	/** The freeze. */
	private boolean freeze;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public EventPK getId() {
		return this.id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	public void setId(EventPK id) {
		this.id = id;
	}

	/**
	 * Gets the body.
	 *
	 * @return the body
	 */
	public String getBody() {
		return this.body;
	}

	/**
	 * Sets the body.
	 *
	 * @param body
	 *            the new body
	 */
	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * Gets the freeze.
	 *
	 * @return the freeze
	 */
	public boolean getFreeze() {
		return this.freeze;
	}

	/**
	 * Sets the freeze.
	 *
	 * @param freeze
	 *            the new freeze
	 */
	public void setFreeze(boolean freeze) {
		this.freeze = freeze;
	}

	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * Sets the title.
	 *
	 * @param title
	 *            the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Sets the date.
	 *
	 * @param date
	 *            the new date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userId
	 *            the new user id
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * Sets the type.
	 *
	 * @param type
	 *            the new type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.acting.util.IGrouped#setGroups(java.lang.String)
	 */
	public void setGroups(String groups) {
		this.groups = groups;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.acting.util.IGrouped#getGroups()
	 */
	public String getGroups() {
		return groups;
	}

	/**
	 * Sets the username.
	 *
	 * @param username
	 *            the new username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the revision.
	 *
	 * @param revision
	 *            the new revision
	 */
	public void setRevision(String revision) {
		this.revision = revision;
	}

	/**
	 * Gets the revision.
	 *
	 * @return the revision
	 */
	public String getRevision() {
		return revision;
	}

	/**
	 * Sets the sys date.
	 *
	 * @param sysDate
	 *            the new sys date
	 */
	public void setSysDate(Date sysDate) {
		this.sysDate = sysDate;
	}

	/**
	 * Gets the sys date.
	 *
	 * @return the sys date
	 */
	public Date getSysDate() {
		return sysDate;
	}

	/**
	 * Sets the code.
	 *
	 * @param code
	 *            the new code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the undelable.
	 *
	 * @param undelable
	 *            the new undelable
	 */
	public void setUndelable(int undelable) {
		this.undelable = undelable;
	}

	/**
	 * Gets the undelable.
	 *
	 * @return the undelable
	 */
	public int getUndelable() {
		return undelable;
	}

	/**
	 * Sets the disable revision.
	 *
	 * @param disableRevision
	 *            the new disable revision
	 */
	public void setDisableRevision(int disableRevision) {
		this.disableRevision = disableRevision;
	}

	/**
	 * Gets the disable revision.
	 *
	 * @return the disable revision
	 */
	public int getDisableRevision() {
		return disableRevision;
	}

	/**
	 * Sets the to.
	 *
	 * @param to
	 *            the new to
	 */
	public void setTo(String to) {
		this.to = to;
	}

	/**
	 * Gets the to.
	 *
	 * @return the to
	 */
	public String getTo() {
		return to;
	}

	/**
	 * Sets the bcs.
	 *
	 * @param bcs
	 *            the new bcs
	 */
	public void setBcs(String bcs) {
		this.bcs = bcs;
	}

	/**
	 * Gets the bcs.
	 *
	 * @return the bcs
	 */
	public String getBcs() {
		return bcs;
	}

	/**
	 * Sets the teams.
	 *
	 * @param teams
	 *            the new teams
	 */
	public void setTeams(String teams) {
		this.teams = teams;
	}

	/**
	 * Gets the teams.
	 *
	 * @return the teams
	 */
	public String getTeams() {
		return teams;
	}

	/**
	 * Sets the syncdate.
	 *
	 * @param syncdate
	 *            the new syncdate
	 */
	public void setSyncdate(Date syncdate) {
		this.syncdate = syncdate;
	}

	/**
	 * Gets the syncdate.
	 *
	 * @return the syncdate
	 */
	public Date getSyncdate() {
		return syncdate;
	}

	/**
	 * Sets the enddate.
	 *
	 * @param enddate
	 *            the new enddate
	 */
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	/**
	 * Gets the enddate.
	 *
	 * @return the enddate
	 */
	public Date getEnddate() {
		return enddate;
	}

	/**
	 * Sets the lastrevision.
	 *
	 * @param lastrevision
	 *            the new lastrevision
	 */
	public void setLastrevision(String lastrevision) {
		this.lastrevision = lastrevision;
	}

	/**
	 * Gets the lastrevision.
	 *
	 * @return the lastrevision
	 */
	public String getLastrevision() {
		return lastrevision;
	}

	/**
	 * Sets the metadata.
	 *
	 * @param metadata
	 *            the new metadata
	 */
	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}

	/**
	 * Gets the metadata.
	 *
	 * @return the metadata
	 */
	public String getMetadata() {
		return metadata;
	}

	/**
	 * Gets the uri.
	 *
	 * @return the uri
	 */
	@XmlElement
	@XmlID
	public String getUri() {
		return getUri(true);
	}

	/**
	 * Gets the uri.
	 *
	 * @param showRevision
	 *            the show revision
	 * @return the uri
	 */
	public String getUri(boolean showRevision) {
		return "ev://" + getType() + "/" + getCode() + (showRevision ? "/" + getRevision() : "");
	}

	/**
	 * Gets the cache id.
	 *
	 * @return the cache id
	 */
	public String getCacheId() {
		return getId().getActivityId() + "-" + getId().getId() + "-" + getSyncdate().getTime();
	}

	/**
	 * Gets the web id.
	 *
	 * @return the web id
	 */
	public String getWebId() {
		if (getId() != null) { return getId().getActivityId() + "-" + getId().getId(); }
		return "-";
	}

	/**
	 * Gets the url params.
	 *
	 * @return the url params
	 */
	public String getUrlParams() {
		if (getId() != null) { return "id-activity=" + getId().getActivityId() + "&id-id=" + getId().getId(); }
		return "";
	}

	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[" + getUri() + "] - " + getTitle();
	}


}