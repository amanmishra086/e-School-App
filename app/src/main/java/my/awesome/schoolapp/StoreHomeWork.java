package my.awesome.schoolapp;

public class StoreHomeWork {

    String Class_subject,HomeWork;

    public StoreHomeWork() {
    }

    public StoreHomeWork(String class_subject, String homeWork) {
        Class_subject = class_subject;
        HomeWork = homeWork;
    }

    public String getClass_subject() {
        return Class_subject;
    }

    public void setClass_subject(String class_subject) {
        Class_subject = class_subject;
    }

    public String getHomeWork() {
        return HomeWork;
    }

    public void setHomeWork(String homeWork) {
        HomeWork = homeWork;
    }
}
