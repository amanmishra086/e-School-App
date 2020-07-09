package my.awesome.schoolapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

//import com.example.schoolapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class StudentAttendance_list extends AppCompatActivity {

    ListView listView;

    ArrayList<String> myArrayList=new ArrayList<>();
    ArrayList<String> keyList=new ArrayList<>();

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_attendance_list);

        SharedPreferences sharedPreferences = getSharedPreferences("myKey", MODE_PRIVATE);
        String Class = sharedPreferences.getString("Class","");
        String Section = sharedPreferences.getString("Section","");
        final String Roll = sharedPreferences.getString("Roll","");

        listView=findViewById(R.id.listView);

        Intent intent=getIntent();
        final String Month=intent.getExtras().getString("month");

        final ArrayAdapter<String> myArrayAdapter =new ArrayAdapter<>(StudentAttendance_list.this,android.R.layout.simple_list_item_1,myArrayList);

        listView.setAdapter(myArrayAdapter);

        databaseReference = FirebaseDatabase.getInstance().getReference("Attendance").child(Class).child(Section)
                .child("2020").child(Month);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot ds : dataSnapshot.getChildren()){

                    StoreAttendance student =ds.child(Roll).getValue(StoreAttendance.class);
                    keyList.add(ds.getKey());
                    String name="Name:-"+student.getName()+"\n"+"Roll:-"+student.getRoll()+"\n"+"Status:-"+student.getStatus()+"\n"+"Date:-"+ds.getKey()+"-"+Month+"-"+"2020";
                    myArrayList.add(name);
                }
                myArrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                myArrayAdapter.notifyDataSetChanged();
            }
        });
    }
}
