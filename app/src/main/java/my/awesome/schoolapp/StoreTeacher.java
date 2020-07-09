package my.awesome.schoolapp;

public class StoreTeacher {

    String name,phone,subject,userid,password;

    public StoreTeacher() {
    }

    public StoreTeacher(String name, String phone, String subject, String userid, String password) {
        this.name = name;
        this.phone = phone;
        this.subject = subject;
        this.userid = userid;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
