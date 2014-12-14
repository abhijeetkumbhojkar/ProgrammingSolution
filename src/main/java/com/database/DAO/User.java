package com.database.DAO;



import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Entity
@Table(name="User")
public class User {
    @Column(name="name")
    private String name;
    
    @Id
    @Column(name="email")
    private String email;
    
    @Column(name="logintype")
    private String loginType;
    
    @Column(name="loginid")
    private String loginid;
    
    @Column(name="profileurl")
    private String profileurl;
   
	@Column(name="token")
    private String token;
    
	@Column(name="password")
    private String password;
	
	@ManyToMany  
	@JoinTable(name = "User_GCM", joinColumns = { @JoinColumn(name = "email") }, inverseJoinColumns = { @JoinColumn(name = "androidid") })  
	private Set<GCM> androidids = new HashSet<GCM>();  
  

	public void setAndroidid(String androidid) {
		GCM t= new GCM(androidid);

		if(!gcmDAO.IsPresent(t)){
			androidids.add(new GCM(androidid));
		}
		else{
			androidids.add(gcmDAO.GetGCM(androidid));	
		}
	}

	public User() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	public String getLoginid() {
		return loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	public String getProfileurl() {
		return profileurl;
	}

	public void setProfileurl(String profileurl) {
		this.profileurl = profileurl;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<GCM> getAndroidids() {
		return androidids;
	}

	public void setAndroidids(Set<GCM> androidids) {
		this.androidids = androidids;
	}

	public User(String name, String email, String loginType, String loginid,
			String profileurl, String token, String password) {
		super();
		this.name = name;
		this.email = email;
		this.loginType = loginType;
		this.loginid = loginid;
		this.profileurl = profileurl;
		this.token = token;
		this.password = password;
	}




	public User(String email) {
		super();
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((loginType == null) ? 0 : loginType.hashCode());
		result = prime * result + ((loginid == null) ? 0 : loginid.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result
				+ ((profileurl == null) ? 0 : profileurl.hashCode());
		result = prime * result + ((token == null) ? 0 : token.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (loginType == null) {
			if (other.loginType != null)
				return false;
		} else if (!loginType.equals(other.loginType))
			return false;
		if (loginid == null) {
			if (other.loginid != null)
				return false;
		} else if (!loginid.equals(other.loginid))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (profileurl == null) {
			if (other.profileurl != null)
				return false;
		} else if (!profileurl.equals(other.profileurl))
			return false;
		if (token == null) {
			if (other.token != null)
				return false;
		} else if (!token.equals(other.token))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", loginType="
				+ loginType + ", loginid=" + loginid + ", profileurl="
				+ profileurl + ", token=" + token + ", password=" + password
				+ "]";
	}

	

}