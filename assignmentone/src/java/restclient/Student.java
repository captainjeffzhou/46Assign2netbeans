/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restclient;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author CPZHOUCHENG
 */
@Entity
@Table(name = "STUDENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s")
    , @NamedQuery(name = "Student.findBySid", query = "SELECT s FROM Student s WHERE s.sid = :sid")
    , @NamedQuery(name = "Student.findByFirstname", query = "SELECT s FROM Student s WHERE s.firstname = :firstname")
    , @NamedQuery(name = "Student.findByLastname", query = "SELECT s FROM Student s WHERE s.lastname = :lastname")
    , @NamedQuery(name = "Student.findByDateofbirth", query = "SELECT s FROM Student s WHERE s.dateofbirth = :dateofbirth")
    , @NamedQuery(name = "Student.findByGender", query = "SELECT s FROM Student s WHERE s.gender = :gender")
    , @NamedQuery(name = "Student.findByCourse", query = "SELECT s FROM Student s WHERE s.course = :course")
    , @NamedQuery(name = "Student.findByStudymode", query = "SELECT s FROM Student s WHERE s.studymode = :studymode")
    , @NamedQuery(name = "Student.findByAddress", query = "SELECT s FROM Student s WHERE s.address = :address")
    , @NamedQuery(name = "Student.findBySuburb", query = "SELECT s FROM Student s WHERE s.suburb = :suburb")
    , @NamedQuery(name = "Student.findByNationality", query = "SELECT s FROM Student s WHERE s.nationality = :nationality")
    , @NamedQuery(name = "Student.findByNativelanguage", query = "SELECT s FROM Student s WHERE s.nativelanguage = :nativelanguage")
    , @NamedQuery(name = "Student.findByFavouritesport", query = "SELECT s FROM Student s WHERE s.favouritesport = :favouritesport")
    , @NamedQuery(name = "Student.findByFavouritemovie", query = "SELECT s FROM Student s WHERE s.favouritemovie = :favouritemovie")
    , @NamedQuery(name = "Student.findByFavouriteunit", query = "SELECT s FROM Student s WHERE s.favouriteunit = :favouriteunit")
    , @NamedQuery(name = "Student.findByCurrentjob", query = "SELECT s FROM Student s WHERE s.currentjob = :currentjob")
                 
        
        
///////// Task 2 - b - (4)  JOIN  
    , @NamedQuery(name = "Student.findByCourseANDfriendid", query = "SELECT s FROM Student s JOIN s.friendshipCollection f WHERE f.friendid = :friendid AND s.course = :course")    

       
        
        
        
///////// Task 3 (a)  locations and frequency          
       
    //, @NamedQuery(name = "Student.findBysidANDlocationdate", query = "select l.locationname, count(l.locationid) from Location l where l.sid.sid = :sid and l.datetime > :startdate and l.datetime < :endingdate group by l.locationname")    
//AND l.datetime >= :startdate AND l.datetime <= :endingdate 
        
        
///////// Task 3 (a)  locations and frequency          
       
   , @NamedQuery(name = "Student.findBysidANDlocationdate", query = "SELECT l.locationname  FROM Student s JOIN s.locationCollection l WHERE s.sid = :sid AND l.locationname = 'Caulfield Campus' GROUP BY l")    
//AND l.datetime >= :startdate AND l.datetime <= :endingdate 
           
        
///////// Task 3 (a test)  join student and friendship 
 //   , @NamedQuery(name = "Student.findBysidANDfriendid", query = "SELECT f.startdate FROM Student s JOIN s.friendshipCollection f WHERE s.sid = :sid AND f.friendid = :friendid")    
        /////////////"SELECT f.startdate//////zhe ge f.startdate you wenti, it works fine if it is puly s/////
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    , @NamedQuery(name = "Student.findByMonashemail", query = "SELECT s FROM Student s WHERE s.monashemail = :monashemail")
    , @NamedQuery(name = "Student.findByPassword", query = "SELECT s FROM Student s WHERE s.password = :password")
    , @NamedQuery(name = "Student.findBySubscriptiondate", query = "SELECT s FROM Student s WHERE s.subscriptiondate = :subscriptiondate")})
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SID")
    private Integer sid;
    @Size(max = 20)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Size(max = 20)
    @Column(name = "LASTNAME")
    private String lastname;
    @Column(name = "DATEOFBIRTH")
    private Integer dateofbirth;
    @Size(max = 20)
    @Column(name = "GENDER")
    private String gender;
    @Size(max = 20)
    @Column(name = "COURSE")
    private String course;
    @Size(max = 20)
    @Column(name = "STUDYMODE")
    private String studymode;
    @Size(max = 20)
    @Column(name = "ADDRESS")
    private String address;
    @Size(max = 20)
    @Column(name = "SUBURB")
    private String suburb;
    @Size(max = 20)
    @Column(name = "NATIONALITY")
    private String nationality;
    @Size(max = 20)
    @Column(name = "NATIVELANGUAGE")
    private String nativelanguage;
    @Size(max = 20)
    @Column(name = "FAVOURITESPORT")
    private String favouritesport;
    @Size(max = 20)
    @Column(name = "FAVOURITEMOVIE")
    private String favouritemovie;
    @Size(max = 20)
    @Column(name = "FAVOURITEUNIT")
    private String favouriteunit;
    @Size(max = 20)
    @Column(name = "CURRENTJOB")
    private String currentjob;
    @Size(max = 40)
    @Column(name = "MONASHEMAIL")
    private String monashemail;
    @Size(max = 20)
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "SUBSCRIPTIONDATE")
    private Integer subscriptiondate;
    @OneToMany(mappedBy = "sid")
    private Collection<Location> locationCollection;
    @OneToMany(mappedBy = "sid")
    private Collection<Friendship> friendshipCollection;

    public Student() {
    }

    public Student(Integer sid) {
        this.sid = sid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(Integer dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getStudymode() {
        return studymode;
    }

    public void setStudymode(String studymode) {
        this.studymode = studymode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getNativelanguage() {
        return nativelanguage;
    }

    public void setNativelanguage(String nativelanguage) {
        this.nativelanguage = nativelanguage;
    }

    public String getFavouritesport() {
        return favouritesport;
    }

    public void setFavouritesport(String favouritesport) {
        this.favouritesport = favouritesport;
    }

    public String getFavouritemovie() {
        return favouritemovie;
    }

    public void setFavouritemovie(String favouritemovie) {
        this.favouritemovie = favouritemovie;
    }

    public String getFavouriteunit() {
        return favouriteunit;
    }

    public void setFavouriteunit(String favouriteunit) {
        this.favouriteunit = favouriteunit;
    }

    public String getCurrentjob() {
        return currentjob;
    }

    public void setCurrentjob(String currentjob) {
        this.currentjob = currentjob;
    }

    public String getMonashemail() {
        return monashemail;
    }

    public void setMonashemail(String monashemail) {
        this.monashemail = monashemail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSubscriptiondate() {
        return subscriptiondate;
    }

    public void setSubscriptiondate(Integer subscriptiondate) {
        this.subscriptiondate = subscriptiondate;
    }

    @XmlTransient
    public Collection<Location> getLocationCollection() {
        return locationCollection;
    }

    public void setLocationCollection(Collection<Location> locationCollection) {
        this.locationCollection = locationCollection;
    }

    @XmlTransient
    public Collection<Friendship> getFriendshipCollection() {
        return friendshipCollection;
    }

    public void setFriendshipCollection(Collection<Friendship> friendshipCollection) {
        this.friendshipCollection = friendshipCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sid != null ? sid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.sid == null && other.sid != null) || (this.sid != null && !this.sid.equals(other.sid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "restclient.Student[ sid=" + sid + " ]";
    }
    
}
