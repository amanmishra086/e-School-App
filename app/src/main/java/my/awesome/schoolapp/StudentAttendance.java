package my.awesome.schoolapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//import com.example.schoolapp.R;

public class StudentAttendance extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_attendance);

        StudentAttendance.this.setTitle("Monthly Attendance");
    }

    public void January(View view) {
        String month="1";

        Intent intent=new Intent(StudentAttendance.this,StudentAttendance_list.class);
        intent.putExtra("month",month);
        startActivity(intent);


    }

    public void February(View view) {
        String month="2";

        Intent intent=new Intent(StudentAttendance.this,StudentAttendance_list.class);
        intent.putExtra("month",month);
        startActivity(intent);
    }

    public void March(View view) {
        String month="3";

        Intent intent=new Intent(StudentAttendance.this,StudentAttendance_list.class);
        intent.putExtra("month",month);
        startActivity(intent);
    }

    public void April(View view) {
        String month="4";

        Intent intent=new Intent(StudentAttendance.this,StudentAttendance_list.class);
        intent.putExtra("month",month);
        startActivity(intent);
    }
    public void May(View view) {
        String month="5";

        Intent intent=new Intent(StudentAttendance.this,StudentAttendance_list.class);
        intent.putExtra("month",month);
        startActivity(intent);
    }
    public void June(View view) {
        String month="6";

        Intent intent=new Intent(StudentAttendance.this,StudentAttendance_list.class);
        intent.putExtra("month",month);
        startActivity(intent);
    }
    public void July(View view) {
        String month="7";

        Intent intent=new Intent(StudentAttendance.this,StudentAttendance_list.class);
        intent.putExtra("month",month);
        startActivity(intent);
    }
    public void August(View view) {
        String month="8";

        Intent intent=new Intent(StudentAttendance.this,StudentAttendance_list.class);
        intent.putExtra("month",month);
        startActivity(intent);
    }
    public void September(View view) {
        String month="9";

        Intent intent=new Intent(StudentAttendance.this,StudentAttendance_list.class);
        intent.putExtra("month",month);
        startActivity(intent);
    }
    public void October(View view) {
        String month="10";

        Intent intent=new Intent(StudentAttendance.this,StudentAttendance_list.class);
        intent.putExtra("month",month);
        startActivity(intent);
    }
    public void November(View view) {
        String month="11";

        Intent intent=new Intent(StudentAttendance.this,StudentAttendance_list.class);
        intent.putExtra("month",month);
        startActivity(intent);
    }
    public void December(View view) {
        String month="12";

        Intent intent=new Intent(StudentAttendance.this,StudentAttendance_list.class);
        intent.putExtra("month",month);
        startActivity(intent);
    }
}
