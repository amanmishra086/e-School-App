package my.awesome.schoolapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

//import com.example.schoolapp.R;

public class AdminPortal extends AppCompatActivity {

    AlertDialog.Builder alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_portal);

        AdminPortal.this.setTitle("Admin Portal");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        alert=new AlertDialog.Builder(this);

        int id =item.getItemId();
        if(id==R.id.logout){
            Toast.makeText(this, "logout selected", Toast.LENGTH_SHORT).show();

            alert.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                    startActivity(new Intent(AdminPortal.this,AdminLogin.class));

                }
            });
            alert.setNegativeButton("no", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            AlertDialog dialog=alert.create();
            dialog.setMessage("are you sure want to exit");
            dialog.show();


            return true;
        }
        if(id==R.id.search){
            Toast.makeText(this, "search selected", Toast.LENGTH_SHORT).show();
            return true;
        }
        if(id==R.id.setting){
            Toast.makeText(this, "setting selected", Toast.LENGTH_SHORT).show();
            return true;
        }
        return true;

    }




    public void OnClickAddNotice(View view) {
        Intent intent =new Intent(AdminPortal.this,AddNotice.class);
        startActivity(intent);
    }
    public void OnClickAddStudent(View view) {
        Intent intent =new Intent(AdminPortal.this,AddStudent.class);
       startActivity(intent);
    }
    public void onClickAddTeacher(View view) {
        Intent intent =new Intent(AdminPortal.this,AddTeacher.class);
        startActivity(intent);
    }

    public void onClickViewTeacher(View view) {
        Intent intent =new Intent(AdminPortal.this,ViewTeacher.class);
        startActivity(intent);
    }

    public void ViewStudentClick(View view) {
        Intent intent =new Intent(AdminPortal.this,ViewStudent.class);
        startActivity(intent);
    }



}
