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

public class TakeAttendance extends AppCompatActivity {

    Spinner Class,Section,Subject;
    DatePicker datePicker;
    Button btn;
   String strDay;
    String strMonth;
    String strYear;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_attendance);

        Class=findViewById(R.id.attendance_class);
        Section=findViewById(R.id.Attendace_section);
        Subject=findViewById(R.id.Attendance_Subject);
        datePicker=findViewById(R.id.date);
        btn=findViewById(R.id.attendance_btn);

        datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                monthOfYear++;
               // strDate=""+dayOfMonth+"-"+monthOfYear+"-"+year;
                strDay=""+dayOfMonth;
                strMonth=""+monthOfYear;
                strYear=""+year;
            }
        });
       // final String StrDay=String.valueOf(strDay);
        //final String StrMonth=String.valueOf(strMonth);
       // final String StrYear=String.valueOf(strYear);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String class_name=Class.getSelectedItem().toString();
                String section_name=Section.getSelectedItem().toString();
                String subject_name=Subject.getSelectedItem().toString();


                 if(section_name.length()==0){
                    Toast.makeText(TakeAttendance.this, "Please select Section", Toast.LENGTH_SHORT).show();
                }else if(class_name.length()==0){
                    Toast.makeText(TakeAttendance.this, "Please select Class", Toast.LENGTH_SHORT).show();
                }else if(subject_name.length()==0){
                    Toast.makeText(TakeAttendance.this, "Please select Subject", Toast.LENGTH_SHORT).show();
                }else{

                Intent intent=new Intent(TakeAttendance.this,TakeAttendance_list.class);
                intent.putExtra("Class",class_name);
                intent.putExtra("Section",section_name);
                intent.putExtra("Subject",subject_name);
                intent.putExtra("Day",strDay);
                intent.putExtra("Month",strMonth);
                intent.putExtra("Year",strYear);

                startActivity(intent);}




            }
        });
    }
}
