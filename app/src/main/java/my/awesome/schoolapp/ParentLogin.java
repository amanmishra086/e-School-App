package my.awesome.schoolapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
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

public class ParentLogin extends AppCompatActivity {

    Spinner Class_name,Section_name;
    EditText userId,Password;
    Button logIn;

    FirebaseAuth firebaseAuth;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_login);

        ParentLogin.this.setTitle("Parent Login");

        firebaseAuth=FirebaseAuth.getInstance();

        Class_name=findViewById(R.id.Class);
        Section_name=findViewById(R.id.section);
        logIn=findViewById(R.id.button);
        userId=findViewById(R.id.editText);
        Password=findViewById(R.id.editText2);


        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Id="Student"+userId.getText().toString()+"@gmail.com";
                String pass=Password.getText().toString();
                final String Class=Class_name.getSelectedItem().toString();
                final String Section=Section_name.getSelectedItem().toString();

                progressDialog = new ProgressDialog(ParentLogin.this);

                progressDialog.setMessage("Loading Parent from Firebase Database");

                progressDialog.show();


                firebaseAuth.signInWithEmailAndPassword(Id,pass).addOnCompleteListener(ParentLogin.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            Toast.makeText(ParentLogin.this, "Successfully login", Toast.LENGTH_SHORT).show();

                            Intent intent=new Intent(ParentLogin.this,parentPortal.class);
                            //intent.putExtra("Class",Class);
                            // intent.putExtra("Section",Section);
                            //intent.putExtra("Roll",userId.getText().toString());
                            startActivity(intent);
                            progressDialog.dismiss();

                            SharedPreferences sharedPref = getSharedPreferences("myKey", MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPref.edit();
                            editor.putString("Class", Class);
                            editor.putString("Section", Section);
                            editor.putString("Roll", userId.getText().toString());
                            editor.apply();


                        }
                        else{
                            Toast.makeText(ParentLogin.this, "Invalid class, Section or Roll.", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        }

                    }
                });

            }
        });



    }
}
