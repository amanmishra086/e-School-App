package my.awesome.schoolapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import my.awesome.schoolapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddStudent extends AppCompatActivity {

    EditText name,Fname,phone,userId,password,roll;
    Button addStudent;
    Spinner Class,Section;

    private FirebaseAuth firebaseAuth;
    private DatabaseReference studentDatabase;

    //String ClassNames[]={"L.K.G","U.K.G","1st","2nd","3rd","4th","5th"};
    //String section[]={"A","B","C","D","E"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);


        firebaseAuth=FirebaseAuth.getInstance();
        studentDatabase= FirebaseDatabase.getInstance().getReference("STUDENTS");

        name=findViewById(R.id.name);
        Fname=findViewById(R.id.Fname);
        phone=findViewById(R.id.phone);
        roll=findViewById(R.id.roll);
        userId=findViewById(R.id.userId);
        password=findViewById(R.id.password);
        Class=findViewById(R.id.Class);
        Section=findViewById(R.id.section);
        addStudent=findViewById(R.id.addStudent);



        addStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Name=name.getText().toString().trim();
                String FName=Fname.getText().toString().trim();
                String Phone=phone.getText().toString().trim();
                final String Roll=roll.getText().toString().trim();
                String UserId=userId.getText().toString().trim();
                String Password=password.getText().toString().trim();
                final String strClass=Class.getSelectedItem().toString();
                final String strSection=Section.getSelectedItem().toString();
                String RollId="Student"+roll.getText().toString()+"@gmail.com";

                final StoreStudent storeStudent= new StoreStudent(Name,FName,Phone,Roll,UserId,Password,strClass,strSection);

                firebaseAuth.createUserWithEmailAndPassword(RollId,Password).addOnCompleteListener(AddStudent.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        // Toast.makeText(StudentCredentials.this, "hello", Toast.LENGTH_SHORT).show();
                        if(task.isSuccessful()){
                            Toast.makeText(AddStudent.this, "Student Added successfully", Toast.LENGTH_SHORT).show();
                            studentDatabase.child(strClass).child(strSection).child(Roll).setValue(storeStudent);
                        }
                        else{
                            Toast.makeText(AddStudent.this, "error found", Toast.LENGTH_SHORT).show();
                        }


                    }
                });





            }
        });

    }
}
