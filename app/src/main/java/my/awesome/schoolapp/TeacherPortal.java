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
import com.google.firebase.auth.FirebaseAuth;

public class TeacherPortal extends AppCompatActivity {

    AlertDialog.Builder alert;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_portal);

        TeacherPortal.this.setTitle("Teacher Portal");
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
                    FirebaseAuth.getInstance().signOut();
                    finish();
                    startActivity(new Intent(TeacherPortal.this,TeacherLogin.class));

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



    public void takeAttendance(View view) {
        Intent intent =new Intent(TeacherPortal.this,TakeAttendance.class);
        startActivity(intent);

    }

    public void TeacherViewAttendance(View view) {
        Intent intent =new Intent(TeacherPortal.this,Teacher_View_Attendance.class);
       startActivity(intent);
    }

    public void OnClickHomeWork(View view) {
        Intent intent =new Intent(TeacherPortal.this,HomeWork.class);
        startActivity(intent);
    }
}
