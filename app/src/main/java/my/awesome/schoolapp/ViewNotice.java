package my.awesome.schoolapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

//import com.example.schoolapp.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ViewNotice extends AppCompatActivity {

    ListView listView;

    ArrayList<String> myArrayList=new ArrayList<>();

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_notice);

        ViewNotice.this.setTitle("Notice");

        final ArrayAdapter<String> myArrayAdapter =new ArrayAdapter<String>(ViewNotice.this,android.R.layout.simple_list_item_1,myArrayList);
        listView=findViewById(R.id.listView);
        listView.setAdapter(myArrayAdapter);


        databaseReference= FirebaseDatabase.getInstance().getReference("Notice");

       /* databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.

                StoreNotice value = dataSnapshot.getValue(StoreNotice.class);
                myArrayList.add(value);
                myArrayAdapter.notifyDataSetChanged();
                Toast.makeText(ViewNotice.this, "ho raha h", Toast.LENGTH_SHORT).show();
                //Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(ViewNotice.this, "nhi ho raha h", Toast.LENGTH_SHORT).show();
                // Failed to read value
               // Log.w(TAG, "Failed to read value.", error.toException());
            }
            Teacher teacher = (Teacher) dataSnapshot.getValue(Teacher.class);
String teacherString = String.valueOf(teacher);
arrayAdapter.add(teacherString);
        });*/






        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                StoreNotice notice= dataSnapshot.getValue(StoreNotice.class);
                final String v1="Notice:-"+notice.getSubject();
                //String valueString=String.valueOf(notice);
                final String v2=notice.getNotice();
              // myArrayList.add(notice);
                myArrayList.add(v1);
                myArrayAdapter.notifyDataSetChanged();

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        //StoreNotice entry= (StoreNotice) parent.getAdapter().getItem(position);
                        StoreNotice entry = (StoreNotice) parent.getItemAtPosition(position);
                        //System.out.println(entry.getNotice());
                        Intent intent=new Intent(ViewNotice.this,NoticeDetail.class);
                        //String m=entry.getNotice();
                        //String n=entry.getSubject();
                        intent.putExtra("Subject",entry.getSubject());
                        intent.putExtra("Notice",entry.getNotice());
                        startActivity(intent);

                    }
                });

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                myArrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
