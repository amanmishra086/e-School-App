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

public class parentPortal extends AppCompatActivity {

    AlertDialog.Builder alert;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_portal);

        parentPortal.this.setTitle("Parent Portal");


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
                    startActivity(new Intent(parentPortal.this,ParentLogin.class));

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


    public void onClickNotice(View view) {
        Intent intent =new Intent(parentPortal.this,View_Notice2.class);
        startActivity(intent);
    }

    public void OnClickPayment(View view) {
        Intent intent =new Intent(parentPortal.this,UPIpayment.class);
        startActivity(intent);
    }

    public void OnClickAttendance(View view) {
        Intent intent =new Intent(parentPortal.this,StudentAttendance.class);
        startActivity(intent);
    }

    public void onClickHomeWork(View view) {

        Intent intent =new Intent(parentPortal.this,StudentHomeWork.class);
        startActivity(intent);
    }
}
