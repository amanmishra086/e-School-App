package my.awesome.schoolapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

//import com.example.schoolapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class TakeAttendance_list extends AppCompatActivity {

    private List<StoreStudent> arrayList;
    private AttendanceAdapter attendanceAdapter;
    private RecyclerView recyclerView;
    Button submit_btn;
    DatabaseReference databaseReference;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_attendance_list);

        submit_btn=findViewById(R.id.Attendance_submit_btn);

        final Intent intent=getIntent();
        String Class=intent.getExtras().getString("Class");
        String Subject=intent.getExtras().getString("Subject");
        String Section=intent.getExtras().getString("Section");
        String Day=intent.getExtras().getString("Day");
        String Month=intent.getExtras().getString("Month");
        String Year=intent.getExtras().getString("Year");

       // Toast.makeText(this, "Loading...", Toast.LENGTH_SHORT).show();

        progressDialog = new ProgressDialog(TakeAttendance_list.this);

        progressDialog.setMessage("Loading Data from Firebase Database");

        progressDialog.show();

        arrayList=new ArrayList<>();

        recyclerView=(RecyclerView) findViewById(R.id.Attendance_recyclerview_id);
        recyclerView.setHasFixedSize(true);

        //recyclerViewAdapter = new RecyclerViewAdapter(arrayList);
        //recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        attendanceAdapter = new AttendanceAdapter(this,arrayList,Subject,Day,Month,Year);
        recyclerView.setAdapter(attendanceAdapter);

        databaseReference= FirebaseDatabase.getInstance().getReference("STUDENTS").child(Class).child(Section);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot ds : dataSnapshot.getChildren()){
                    StoreStudent student =ds.getValue(StoreStudent.class);
                   // keyList.add(ds.getKey());
                    //String name="Name:-"+student.getName()+"\n"+"Roll:-"+student.getRoll()+"  "+"Phone:-"+student.getPhone();
                    arrayList.add(student);
                }
                attendanceAdapter.notifyDataSetChanged();
                progressDialog.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                attendanceAdapter.notifyDataSetChanged();
                progressDialog.dismiss();
            }
        });

        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TakeAttendance_list.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
                Intent intent1=new Intent(TakeAttendance_list.this,TeacherPortal.class);
                startActivity(intent1);
            }
        });








    }
}
