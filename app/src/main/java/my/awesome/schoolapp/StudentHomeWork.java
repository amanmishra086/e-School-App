package my.awesome.schoolapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

//import com.example.schoolapp.R;

public class StudentHomeWork extends AppCompatActivity {

    DatePicker datePicker;
    Button buttonn;
    String strDate;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_home_work);

        datePicker=findViewById(R.id.date);
        buttonn=findViewById(R.id.button);

        datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                monthOfYear++;
                strDate=""+dayOfMonth+"-"+monthOfYear+"-"+year;
            }
        });
        buttonn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(StudentHomeWork.this,StudentHomeWork_list.class);
                intent.putExtra("Date",strDate);
                startActivity(intent);

            }
        });




    }
}
