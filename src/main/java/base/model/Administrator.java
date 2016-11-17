package base.model;

/**
 * Created by lkq on 2016/10/12.
 */
public class Administrator extends User{
    private String admin;
    public String getAdmin(){
        return admin;
    }
    public void setAdmin(String admin){
        this.admin=admin;
    }
}