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

public class StudentHomeWork_list extends AppCompatActivity {

    ListView listView;


    ArrayList<String> myArrayList=new ArrayList<>();


    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_home_work_list);

        listView=findViewById(R.id.listview);

        SharedPreferences sharedPreferences = getSharedPreferences("myKey", MODE_PRIVATE);
        String Class = sharedPreferences.getString("Class","");
        String Section = sharedPreferences.getString("Section","");

        Intent intent=getIntent();
        String Date=intent.getExtras().getString("Date");


        final ArrayAdapter<String> myArrayAdapter =new ArrayAdapter<>(StudentHomeWork_list.this,android.R.layout.simple_list_item_1,myArrayList);

        listView.setAdapter(myArrayAdapter);

        databaseReference= FirebaseDatabase.getInstance().getReference("HomeWork").child(Class).child(Section).child(Date);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot ds : dataSnapshot.getChildren()){
                    StoreHomeWork student =ds.getValue(StoreHomeWork.class);
                    String name="Subject:-"+student.getClass_subject()+"\n"+"HomeWork:-"+student.getHomeWork();
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
