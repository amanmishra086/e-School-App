package my.awesome.schoolapp;

public class StoreStudent {

    String name,fname,phone,roll,userid,pass,classname,section;

    public StoreStudent() {
    }

    public StoreStudent(String name, String fname, String phone,String roll, String userid, String pass, String classname, String section) {
        this.name = name;
        this.fname = fname;
        this.phone = phone;
        this.roll = roll;
        this.userid = userid;
        this.pass = pass;
        this.classname = classname;
        this.section = section;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    @Override
    public String toString() {
        return roll;
    }
}
