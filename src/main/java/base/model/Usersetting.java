package base.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by lkq on 2017/6/18.
 */
@Entity
public class Usersetting {
    private int id;
    private int userid;
    private Integer pagesize;
    private Boolean showOnlinecounts;
    private Boolean friendtips;
    private Boolean showmyinfo;

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
    @Column(name = "show_onlinecounts", nullable = true)
    public Boolean getShowOnlinecounts() {
        return showOnlinecounts;
    }

    public void setShowOnlinecounts(Boolean showOnlinecounts) {
        this.showOnlinecounts = showOnlinecounts;
    }

    @Basic
    @Column(name = "friendtips", nullable = true)
    public Boolean getFriendtips() {
        return friendtips;
    }

    public void setFriendtips(Boolean friendtips) {
        this.friendtips = friendtips;
    }

    @Basic
    @Column(name = "showmyinfo", nullable = true)
    public Boolean getShowmyinfo() {
        return showmyinfo;
    }

    public void setShowmyinfo(Boolean showmyinfo) {
        this.showmyinfo = showmyinfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usersetting that = (Usersetting) o;

        if (id != that.id) return false;
        if (userid != that.userid) return false;
        if (pagesize != null ? !pagesize.equals(that.pagesize) : that.pagesize != null) return false;
        if (showOnlinecounts != null ? !showOnlinecounts.equals(that.showOnlinecounts) : that.showOnlinecounts != null)
            return false;
        if (friendtips != null ? !friendtips.equals(that.friendtips) : that.friendtips != null) return false;
        if (showmyinfo != null ? !showmyinfo.equals(that.showmyinfo) : that.showmyinfo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userid;
        result = 31 * result + (pagesize != null ? pagesize.hashCode() : 0);
        result = 31 * result + (showOnlinecounts != null ? showOnlinecounts.hashCode() : 0);
        result = 31 * result + (friendtips != null ? friendtips.hashCode() : 0);
        result = 31 * result + (showmyinfo != null ? showmyinfo.hashCode() : 0);
        return result;
    }
}
