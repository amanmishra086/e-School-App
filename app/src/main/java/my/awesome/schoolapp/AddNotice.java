package my.awesome.schoolapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//import com.example.schoolapp.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddNotice extends AppCompatActivity {

    EditText subject,notice;
    Button submit;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_notice);

        subject=findViewById(R.id.subject);
        notice=findViewById(R.id.notice);
        submit=findViewById(R.id.submit);

        databaseReference= FirebaseDatabase.getInstance().getReference("Notice");

     submit.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             String Subject=subject.getText().toString();
             String Notice=notice.getText().toString();

             StoreNotice storeNotice=new StoreNotice(Subject,Notice);

             databaseReference.push().setValue(storeNotice);
             Toast.makeText(AddNotice.this, "Notice send successfully", Toast.LENGTH_SHORT).show();
             Intent intent =new Intent(AddNotice.this,AdminPortal.class);
             startActivity(intent);

         }
     });


    }
}
