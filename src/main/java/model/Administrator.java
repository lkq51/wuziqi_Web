package model;

/**
 * Created by lkq on 2016/10/12.
 */
public class Administrator extends User{
    private String workNo;
    public String getWorkNo(){
        return workNo;
    }
    public void setWorkNo(String workNo){
        this.workNo=workNo;
    }
}