/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restclient;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CPZHOUCHENG
 */
@Entity
@Table(name = "FRIENDSHIP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Friendship.findAll", query = "SELECT f FROM Friendship f")
    , @NamedQuery(name = "Friendship.findByFriendshipid", query = "SELECT f FROM Friendship f WHERE f.friendshipid = :friendshipid")
    , @NamedQuery(name = "Friendship.findByStartdate", query = "SELECT f FROM Friendship f WHERE f.startdate = :startdate")
    , @NamedQuery(name = "Friendship.findByEnddate", query = "SELECT f FROM Friendship f WHERE f.enddate = :enddate")

    , @NamedQuery(name = "Friendship.findByFriendid", query = "SELECT f FROM Friendship f WHERE f.friendid = :friendid")})
public class Friendship implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "FRIENDSHIPID")
    private Integer friendshipid;
    @Column(name = "STARTDATE")
    private Integer startdate;
    @Column(name = "ENDDATE")
    private Integer enddate;
    @Column(name = "FRIENDID")
    private Integer friendid;
    @JoinColumn(name = "SID", referencedColumnName = "SID")
    @ManyToOne
    private Student sid;

    public Friendship() {
    }

    public Friendship(Integer friendshipid) {
        this.friendshipid = friendshipid;
    }

    public Integer getFriendshipid() {
        return friendshipid;
    }

    public void setFriendshipid(Integer friendshipid) {
        this.friendshipid = friendshipid;
    }

    public Integer getStartdate() {
        return startdate;
    }

    public void setStartdate(Integer startdate) {
        this.startdate = startdate;
    }

    public Integer getEnddate() {
        return enddate;
    }

    public void setEnddate(Integer enddate) {
        this.enddate = enddate;
    }

    public Integer getFriendid() {
        return friendid;
    }

    public void setFriendid(Integer friendid) {
        this.friendid = friendid;
    }

    public Student getSid() {
        return sid;
    }

    public void setSid(Student sid) {
        this.sid = sid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (friendshipid != null ? friendshipid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Friendship)) {
            return false;
        }
        Friendship other = (Friendship) object;
        if ((this.friendshipid == null && other.friendshipid != null) || (this.friendshipid != null && !this.friendshipid.equals(other.friendshipid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "restclient.Friendship[ friendshipid=" + friendshipid + " ]";
    }
    
}
