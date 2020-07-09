package my.awesome.schoolapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import my.awesome.schoolapp.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddHomeWork extends AppCompatActivity {

    TextView t1,t2,t3,t4;
    EditText hw;
    Button save;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_home_work);

        t1=findViewById(R.id.ClassName);
        t2=findViewById(R.id.Section_name);
        t3=findViewById(R.id.Subject_name);
        t4=findViewById(R.id.date);
        hw=findViewById(R.id.editText);
        save=findViewById(R.id.save_btn);

        Intent intent=getIntent();
        final String Class=intent.getExtras().getString("Class");
        final String Subject=intent.getExtras().getString("Subject");
        final String Section=intent.getExtras().getString("Section");
        final String Date=intent.getExtras().getString("Date");

        t1.setText(Class);
        t2.setText(Section);
        t3.setText(Subject);
        t4.setText(Date);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String homework=hw.getText().toString().trim();

                databaseReference= FirebaseDatabase.getInstance().getReference("HomeWork").child(Class).child(Section).child(Date).child(Subject);
                StoreHomeWork storeHomeWork=new StoreHomeWork(Subject,homework);
                databaseReference.setValue(storeHomeWork);
                Toast.makeText(AddHomeWork.this, "Homework Saved...", Toast.LENGTH_SHORT).show();
            }
        });



    }


}
