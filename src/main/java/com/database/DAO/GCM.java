package com.database.DAO;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Entity
@Table(name="GCM")
public class GCM {
	
	@Column(name="registrationid")
	 private String registrationid;
	 
	 @Id
	 @Column(name="androidid")
	 private String androidid;


	 @ManyToMany(mappedBy = "androidids")  
	 private Set<User> users = new HashSet<User>();  
	 

	public GCM() {
		super();
	}

	public GCM(String registrationid, String androidid) {
		super();
		this.registrationid = registrationid;
		this.androidid = androidid;
	}


	public GCM(String androidid) {
		super();
		this.androidid = androidid;
	}

	public String getRegistrationid() {
		return registrationid;
	}


	public void setRegistrationid(String registrationid) {
		this.registrationid = registrationid;
	}


	public String getAndroidid() {
		return androidid;
	}


	public void setAndroidid(String androidid) {
		this.androidid = androidid;
	}


	public Set<User> getUsers() {
		return users;
	}


	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((androidid == null) ? 0 : androidid.hashCode());
		result = prime * result
				+ ((registrationid == null) ? 0 : registrationid.hashCode());
		return result;
	}


	@Override
	public String toString() {
		return "GCM [registrationid=" + registrationid + ", androidid="
				+ androidid + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GCM other = (GCM) obj;
		if (androidid == null) {
			if (other.androidid != null)
				return false;
		} else if (!androidid.equals(other.androidid))
			return false;
		if (registrationid == null) {
			if (other.registrationid != null)
				return false;
		} else if (!registrationid.equals(other.registrationid))
			return false;
		return true;
	}
}
