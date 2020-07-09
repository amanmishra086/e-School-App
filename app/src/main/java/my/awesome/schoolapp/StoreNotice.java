package my.awesome.schoolapp;

public class StoreNotice {

private String subject,notice;

    public StoreNotice() {

    }

    public StoreNotice(String subject, String notice) {
        this.subject = subject;
        this.notice = notice;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    @Override
    public String toString() {
        return "StoreNotice{" +
                "subject='" + subject + '\'' +
                ", notice='" + notice + '\'' +
                '}';
    }
}
