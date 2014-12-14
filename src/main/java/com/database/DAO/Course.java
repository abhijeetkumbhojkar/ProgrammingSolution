package com.database.DAO;


import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Course")
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="courseid")
	private Integer courseid;
	
	@Column(name="coursefile")
	private byte[] coursefile;
	
	@Column(name="coursename")
	private String coursename;
	
	@Column(name="coursestatus")
	private String coursestatus;
	
	@Column(name="mcqfile")
	private byte[] mcqfile;
	
	@Column(name="courseicon")
	private byte[] courseicon;
	
	@Column(name="courseimage")
	private byte[] courseimage;
	
	@Column(name="videourl")
	private String videourl;
	
	@Column(name="dateadded")
	private Date dateadded;
	
	@ManyToOne
	@JoinColumn(name="email")
	private User email;

	public Course(Integer courseid, byte[] coursefile, String coursename,
			String coursestatus, byte[] mcqfile, byte[] courseicon,
			byte[] courseimage, String videourl, Date dateadded, User email) {
		super();
		this.courseid = courseid;
		this.coursefile = coursefile;
		this.coursename = coursename;
		this.coursestatus = coursestatus;
		this.mcqfile = mcqfile;
		this.courseicon = courseicon;
		this.courseimage = courseimage;
		this.videourl = videourl;
		this.dateadded = dateadded;
		this.email = email;
	}

	public Course() {
		super();
	}

	public Course(byte[] coursefile, String coursename, String coursestatus,
			Date dateadded, User email) {
		super();
		this.coursefile = coursefile;
		this.coursename = coursename;
		this.coursestatus = coursestatus;
		this.dateadded = dateadded;
		this.email = email;
	}

	public Integer getCourseid() {
		return courseid;
	}

	public void setCourseid(Integer courseid) {
		this.courseid = courseid;
	}

	public byte[] getCoursefile() {
		return coursefile;
	}

	public void setCoursefile(byte[] coursefile) {
		this.coursefile = coursefile;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public String getCoursestatus() {
		return coursestatus;
	}

	public void setCoursestatus(String coursestatus) {
		this.coursestatus = coursestatus;
	}

	public byte[] getMcqfile() {
		return mcqfile;
	}

	public void setMcqfile(byte[] mcqfile) {
		this.mcqfile = mcqfile;
	}

	public byte[] getCourseicon() {
		return courseicon;
	}

	public void setCourseicon(byte[] courseicon) {
		this.courseicon = courseicon;
	}

	public byte[] getCourseimage() {
		return courseimage;
	}

	public void setCourseimage(byte[] courseimage) {
		this.courseimage = courseimage;
	}

	public String getVideourl() {
		return videourl;
	}

	public void setVideourl(String videourl) {
		this.videourl = videourl;
	}

	public Date getDateadded() {
		return dateadded;
	}

	public void setDateadded(Date dateadded) {
		this.dateadded = dateadded;
	}

	public User getEmail() {
		return email;
	}

	public void setEmail(User email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Course [courseid=" + courseid + ", coursefile="
				+ Arrays.toString(coursefile) + ", coursename=" + coursename
				+ ", coursestatus=" + coursestatus + ", mcqfile="
				+ Arrays.toString(mcqfile) + ", courseicon="
				+ Arrays.toString(courseicon) + ", courseimage="
				+ Arrays.toString(courseimage) + ", videourl=" + videourl
				+ ", dateadded=" + dateadded + ", email=" + email + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(coursefile);
		result = prime * result + Arrays.hashCode(courseicon);
		result = prime * result
				+ ((courseid == null) ? 0 : courseid.hashCode());
		result = prime * result + Arrays.hashCode(courseimage);
		result = prime * result
				+ ((coursename == null) ? 0 : coursename.hashCode());
		result = prime * result
				+ ((coursestatus == null) ? 0 : coursestatus.hashCode());
		result = prime * result
				+ ((dateadded == null) ? 0 : dateadded.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + Arrays.hashCode(mcqfile);
		result = prime * result
				+ ((videourl == null) ? 0 : videourl.hashCode());
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
		Course other = (Course) obj;
		if (!Arrays.equals(coursefile, other.coursefile))
			return false;
		if (!Arrays.equals(courseicon, other.courseicon))
			return false;
		if (courseid == null) {
			if (other.courseid != null)
				return false;
		} else if (!courseid.equals(other.courseid))
			return false;
		if (!Arrays.equals(courseimage, other.courseimage))
			return false;
		if (coursename == null) {
			if (other.coursename != null)
				return false;
		} else if (!coursename.equals(other.coursename))
			return false;
		if (coursestatus == null) {
			if (other.coursestatus != null)
				return false;
		} else if (!coursestatus.equals(other.coursestatus))
			return false;
		if (dateadded == null) {
			if (other.dateadded != null)
				return false;
		} else if (!dateadded.equals(other.dateadded))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (!Arrays.equals(mcqfile, other.mcqfile))
			return false;
		if (videourl == null) {
			if (other.videourl != null)
				return false;
		} else if (!videourl.equals(other.videourl))
			return false;
		return true;
	}
	
	
	
}
