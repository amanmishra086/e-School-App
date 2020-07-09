package my.awesome.schoolapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

//import com.example.schoolapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class View_Notice2 extends AppCompatActivity {

    private List <StoreNotice > arrayList;
    private RecyclerViewAdapter recyclerViewAdapter;
    private RecyclerView recyclerView;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__notice2);

        Toast.makeText(this, "Loading...", Toast.LENGTH_SHORT).show();

        arrayList=new ArrayList<>();

        recyclerView=(RecyclerView) findViewById(R.id.recyclerview_id);
        recyclerView.setHasFixedSize(true);

        //recyclerViewAdapter = new RecyclerViewAdapter(arrayList);
        //recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerViewAdapter = new RecyclerViewAdapter(this,arrayList);
        recyclerView.setAdapter(recyclerViewAdapter);




       databaseReference= FirebaseDatabase.getInstance().getReference().child("Notice");

         databaseReference.addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                 if (dataSnapshot.exists()) {
                     for (DataSnapshot ds : dataSnapshot.getChildren()) {
                         StoreNotice notice = ds.getValue(StoreNotice.class);


                         arrayList.add(notice);
                         //notice.getSubject();
                         // notice.getNotice();
                         //Log.d("TAG", notice.getSubject() + " / " +
                         //notice.getSubject());


                         //arrayList.add(new StoreNotice(notice.getSubject(), notice.getNotice()));


                     }


                     //recyclerViewAdapter = new RecyclerViewAdapter(arrayList);
                     //recyclerView.setAdapter(recyclerViewAdapter);

                     recyclerViewAdapter.notifyDataSetChanged();

                 }
             }
             @Override
             public void onCancelled(@NonNull DatabaseError databaseError) {

             }
         });


      /*  databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                if(dataSnapshot.exists()) {
                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                        StoreNotice notice = ds.getValue(StoreNotice.class);

                        //arrayList.add(notice);
                        //notice.getSubject();
                        // notice.getNotice();
                        //Log.d("TAG", notice.getSubject() + " / " +
                        //notice.getSubject());

                        arrayList.add(new StoreNotice(notice.getSubject(), notice.getNotice()));



                    }
                    recyclerViewAdapter=new RecyclerViewAdapter(arrayList);
                    recyclerView.setAdapter(recyclerViewAdapter);

                    //recyclerViewAdapter.notifyDataSetChanged();
                    //String valueString=String.valueOf(notice);

                    // myArrayList.add(notice);
                }// myArrayAdapter.add(valueString);
                //myArrayAdapter.notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
               // myArrayAdapter.notifyDataSetChanged();
                //recyclerViewAdapter.notifyDataSetChanged();
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
        });*/
    }



}
