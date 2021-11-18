package com.learner.springmvc.model;

public class Course {
	private long id;
    
    private String coursename;
     
    private String address;
     
    private String email;
     
    public Course(){
        id=0;
    }
     
    public Course(long id, String coursename, String address, String email){
        this.id = id;
        this.coursename = coursename;
        this.address = address;
        this.email = email;
    }
 
    public long getId() {
        return id;
    }
 
    public void setId(long id) {
        this.id = id;
    }
 
    public String getCoursename() {
        return coursename;
    }
 
    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }
 
    public String getAddress() {
        return address;
    }
 
    public void setAddress(String address) {
        this.address = address;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Course))
            return false;
        Course other = (Course) obj;
        if (id != other.id)
            return false;
        return true;
    }
 
    @Override
    public String toString() {
        return "Learner [id=" + id + ", coursename=" + coursename + ", address=" + address
                + ", email=" + email + "]";
    }
     
 
     
}
