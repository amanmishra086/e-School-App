package my.awesome.schoolapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

//import com.example.schoolapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddTeacher extends AppCompatActivity {

    EditText name,phone ,userid,password;
    Spinner subject;
    Button addteacher;

    private FirebaseAuth firebaseAuth;
    private DatabaseReference teacherDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_teacher);

        firebaseAuth=FirebaseAuth.getInstance();
        teacherDatabase= FirebaseDatabase.getInstance().getReference("TEACHER");


        name=findViewById(R.id.teacher_name);
        phone=findViewById(R.id.teacher_phone);
        userid=findViewById(R.id.teacher_userId);
        subject=findViewById(R.id.teacher_subject);
        password=findViewById(R.id.teacher_password);
        addteacher=findViewById(R.id.AddTeacher_btn);

      addteacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Name=name.getText().toString().trim();
                String Phone=phone.getText().toString().trim();
                String UserId=userid.getText().toString().trim();
                final String Subject=subject.getSelectedItem().toString();
                String Password=password.getText().toString().trim();


                final StoreTeacher storeTeacher= new StoreTeacher(Name,Phone,Subject,UserId,Password);

                firebaseAuth.createUserWithEmailAndPassword(UserId,Password).addOnCompleteListener(AddTeacher.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        // Toast.makeText(StudentCredentials.this, "hello", Toast.LENGTH_SHORT).show();
                        if(task.isSuccessful()){
                            Toast.makeText(AddTeacher.this, "Teacher Added successfully", Toast.LENGTH_SHORT).show();
                            teacherDatabase.child(Subject).push().setValue(storeTeacher);
                        }
                        else{
                            Toast.makeText(AddTeacher.this, "error found", Toast.LENGTH_SHORT).show();
                        }


                    }
                });





            }
        });




    }
}
