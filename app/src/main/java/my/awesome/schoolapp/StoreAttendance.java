package my.awesome.schoolapp;

public class StoreAttendance {

    String name,Roll,status;

    public StoreAttendance() {
    }

    public StoreAttendance(String name, String roll, String status) {
        this.name = name;
        Roll = roll;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoll() {
        return Roll;
    }

    public void setRoll(String roll) {
        Roll = roll;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
