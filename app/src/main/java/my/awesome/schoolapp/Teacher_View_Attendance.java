package my.awesome.schoolapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Toast;

//import com.example.schoolapp.R;

public class Teacher_View_Attendance extends AppCompatActivity {

    Spinner Class,Section,Subject;
    Button View_attendance;
    DatePicker datePicker;
   // String strDate;
    String strDay;
    String strMonth;
    String strYear;



    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher__view__attendance);


        Class=findViewById(R.id.View_attendance_class);
        Subject=findViewById(R.id.View_Attendance_Subject);
        Section=findViewById(R.id.View_Attendace_section);
        View_attendance=findViewById(R.id.View_attendance_btn);
        datePicker=findViewById(R.id.View_date);



        datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                monthOfYear++;
                //strDate=""+dayOfMonth+"-"+monthOfYear+"-"+year;
                strDay=""+dayOfMonth;
                strMonth=""+monthOfYear;
                strYear=""+year;
            }
        });
        View_attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Class_name=Class.getSelectedItem().toString();
                String Section_name=Section.getSelectedItem().toString();
                String Subject_name=Subject.getSelectedItem().toString();

                if(Section_name.length()==0){
                    Toast.makeText(Teacher_View_Attendance.this, "Please select Section", Toast.LENGTH_SHORT).show();
                }else if(Class_name.length()==0){
                    Toast.makeText(Teacher_View_Attendance.this, "Please select Class", Toast.LENGTH_SHORT).show();
                }else if(Subject_name.length()==0){
                    Toast.makeText(Teacher_View_Attendance.this, "Please select Subject", Toast.LENGTH_SHORT).show();
                }else{

                    Intent intent=new Intent(Teacher_View_Attendance.this,Teacher_View_Attendance_list.class);
                    intent.putExtra("Class",Class_name);
                    intent.putExtra("Section",Section_name);
                    intent.putExtra("Subject",Subject_name);
                    intent.putExtra("Day",strDay);
                    intent.putExtra("Month",strMonth);
                    intent.putExtra("Year",strYear);

                    startActivity(intent);
                }


            }
        });



    }
}
