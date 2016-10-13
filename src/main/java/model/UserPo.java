package model;

import javax.persistence.*;

/**
 * Created by lkq on 2016/10/11.
 */
@Entity
@Table(name = "user", schema = "wuziqi")
public class UserPo {
    private int id;
    private String username;
    private String password;
    private String email;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 20)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 30)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserPo userPo = (UserPo) o;

        if (id != userPo.id) return false;
        if (username != null ? !username.equals(userPo.username) : userPo.username != null) return false;
        if (password != null ? !password.equals(userPo.password) : userPo.password != null) return false;
        if (email != null ? !email.equals(userPo.email) : userPo.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
