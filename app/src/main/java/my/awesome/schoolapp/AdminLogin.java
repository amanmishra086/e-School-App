package my.awesome.schoolapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

//import com.example.schoolapp.R;

public class AdminLogin extends AppCompatActivity {
    EditText email,password;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        AdminLogin.this.setTitle("Admin Login");


        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
    }

    public void onClickLogIn(View view) {

        String Email=email.getText().toString();
        String Password=password.getText().toString();

        progressDialog = new ProgressDialog(AdminLogin.this);

        progressDialog.setMessage("Loading Data from Firebase Database");

        progressDialog.show();

        if(Email.equals("admin@gmail.com")&&Password.equals("admin@123")){
            Intent intent=new Intent(AdminLogin.this,AdminPortal.class);
            startActivity(intent);
            progressDialog.dismiss();
        }
        else{
            Toast.makeText(AdminLogin.this, "Invalid Id or Password", Toast.LENGTH_SHORT).show();
            progressDialog.dismiss();
        }





    }


}
