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

public class HomeWork extends AppCompatActivity {


    Spinner Class,Section,Subject;
    DatePicker datePicker;
    Button btn,view_hw;
    String strDate;

    @RequiresApi(api = Build.VERSION_CODES.O)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_work);

        Class=findViewById(R.id.attendance_class);
        Section=findViewById(R.id.Attendace_section);
        Subject=findViewById(R.id.Attendance_Subject);
        datePicker=findViewById(R.id.date);
        btn=findViewById(R.id.attendance_btn);
        view_hw=findViewById(R.id.View_HomeWork);

        datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                monthOfYear++;
                strDate=""+dayOfMonth+"-"+monthOfYear+"-"+year;
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String class_name=Class.getSelectedItem().toString();
                String section_name=Section.getSelectedItem().toString();
                String subject_name=Subject.getSelectedItem().toString();

                if(strDate.length()==0){
                    Toast.makeText(HomeWork.this, "Please select Date..", Toast.LENGTH_SHORT).show();
                }else if(section_name.length()==0){
                    Toast.makeText(HomeWork.this, "Please select Section", Toast.LENGTH_SHORT).show();
                }else if(class_name.length()==0){
                    Toast.makeText(HomeWork.this, "Please select Class", Toast.LENGTH_SHORT).show();
                }else if(subject_name.length()==0){
                    Toast.makeText(HomeWork.this, "Please select Subject", Toast.LENGTH_SHORT).show();
                }else{

                    Intent intent=new Intent(HomeWork.this,AddHomeWork.class);
                    intent.putExtra("Class",class_name);
                    intent.putExtra("Section",section_name);
                    intent.putExtra("Subject",subject_name);
                    intent.putExtra("Date",strDate);

                    startActivity(intent);}




            }
        });

        view_hw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String class_name=Class.getSelectedItem().toString();
                String section_name=Section.getSelectedItem().toString();
                String subject_name=Subject.getSelectedItem().toString();

                if(strDate.length()==0){
                    Toast.makeText(HomeWork.this, "Please select Date..", Toast.LENGTH_SHORT).show();
                }else if(section_name.length()==0){
                    Toast.makeText(HomeWork.this, "Please select Section", Toast.LENGTH_SHORT).show();
                }else if(class_name.length()==0){
                    Toast.makeText(HomeWork.this, "Please select Class", Toast.LENGTH_SHORT).show();
                }else if(subject_name.length()==0){
                    Toast.makeText(HomeWork.this, "Please select Subject", Toast.LENGTH_SHORT).show();
                }else{

                    Intent intent1=new Intent(HomeWork.this,HomeWork_list.class);
                    intent1.putExtra("Class",class_name);
                    intent1.putExtra("Section",section_name);
                    intent1.putExtra("Subject",subject_name);
                    intent1.putExtra("Date",strDate);

                    startActivity(intent1);}




            }
        });


    }
}
