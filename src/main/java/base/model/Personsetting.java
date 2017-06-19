package base.model;

import org.springframework.stereotype.Repository;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by lkq on 2017/6/19.
 */
@Repository(value="personsetting")
@Entity
public class Personsetting {
    private int id;
    private int userid;
    private Integer pagesize;
    private Boolean onlinereminder;
    private Boolean onlinenumber;
    private Boolean myinfoshow;

    @Id
    @Column(name = "_id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "userid", nullable = false)
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "pagesize", nullable = true)
    public Integer getPagesize() {
        return pagesize;
    }

    public void setPagesize(Integer pagesize) {
        this.pagesize = pagesize;
    }

    @Basic
    @Column(name = "onlinereminder", nullable = true)
    public Boolean getOnlinereminder() {
        return onlinereminder;
    }

    public void setOnlinereminder(Boolean onlinereminder) {
        this.onlinereminder = onlinereminder;
    }

    @Basic
    @Column(name = "onlinenumber", nullable = true)
    public Boolean getOnlinenumber() {
        return onlinenumber;
    }

    public void setOnlinenumber(Boolean onlinenumber) {
        this.onlinenumber = onlinenumber;
    }

    @Basic
    @Column(name = "myinfoshow", nullable = true)
    public Boolean getMyinfoshow() {
        return myinfoshow;
    }

    public void setMyinfoshow(Boolean myinfoshow) {
        this.myinfoshow = myinfoshow;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Personsetting that = (Personsetting) o;

        if (id != that.id) return false;
        if (userid != that.userid) return false;
        if (pagesize != null ? !pagesize.equals(that.pagesize) : that.pagesize != null) return false;
        if (onlinereminder != null ? !onlinereminder.equals(that.onlinereminder) : that.onlinereminder != null)
            return false;
        if (onlinenumber != null ? !onlinenumber.equals(that.onlinenumber) : that.onlinenumber != null) return false;
        if (myinfoshow != null ? !myinfoshow.equals(that.myinfoshow) : that.myinfoshow != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userid;
        result = 31 * result + (pagesize != null ? pagesize.hashCode() : 0);
        result = 31 * result + (onlinereminder != null ? onlinereminder.hashCode() : 0);
        result = 31 * result + (onlinenumber != null ? onlinenumber.hashCode() : 0);
        result = 31 * result + (myinfoshow != null ? myinfoshow.hashCode() : 0);
        return result;
    }
}
