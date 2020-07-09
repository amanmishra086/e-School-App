package my.awesome.schoolapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//import com.example.schoolapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class TeacherLogin extends AppCompatActivity {
    Button teacherLogin;
    EditText email,password;

    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_login);

        TeacherLogin.this.setTitle("Teacher Login");

        firebaseAuth=FirebaseAuth.getInstance();

        teacherLogin=findViewById(R.id.Tech_login_btn);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);


        teacherLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Email=email.getText().toString();
                String Password=password.getText().toString();

                progressDialog = new ProgressDialog(TeacherLogin.this);

                progressDialog.setMessage("Loading Teacher from Firebase Database");

                progressDialog.show();

                firebaseAuth.signInWithEmailAndPassword(Email,Password).addOnCompleteListener(TeacherLogin.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            Toast.makeText(TeacherLogin.this, "Successfully login", Toast.LENGTH_SHORT).show();
                            Intent intent =new Intent(TeacherLogin.this,TeacherPortal.class);
                            startActivity(intent);
                            progressDialog.dismiss();
                        }
                        else{
                            Toast.makeText(TeacherLogin.this, "Invalid Id or Password", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        }

                    }
                });







            }
        });
    }


}
