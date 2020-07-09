package my.awesome.schoolapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

//import com.example.schoolapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HomeWork_list extends AppCompatActivity {

    ListView listView;


    ArrayList<String> myArrayList=new ArrayList<>();
    ArrayList<String> keyList=new ArrayList<>();

    DatabaseReference databaseReference;

    AlertDialog.Builder alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_work_list);

        alert=new AlertDialog.Builder(this);

        Intent intent=getIntent();
        String Class=intent.getExtras().getString("Class");
        String Subject=intent.getExtras().getString("Subject");
        String Section=intent.getExtras().getString("Section");
        String Date=intent.getExtras().getString("Date");

        listView=findViewById(R.id.HomeWork_listView);

        final ArrayAdapter<String> myArrayAdapter =new ArrayAdapter<>(HomeWork_list.this,android.R.layout.simple_list_item_1,myArrayList);

        listView.setAdapter(myArrayAdapter);

        databaseReference= FirebaseDatabase.getInstance().getReference("HomeWork").child(Class).child(Section).child(Date);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot ds : dataSnapshot.getChildren()){
                    StoreHomeWork student =ds.getValue(StoreHomeWork.class);
                    keyList.add(ds.getKey());
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

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                // final StoreStudent item= (StoreStudent) parent.getAdapter().getItem(position);
                final String item = myArrayAdapter.getItem(position);
                //final String value=String.valueOf(item);
                //final String value=item.getRoll();


                alert.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {



                        myArrayList.remove(item);
                        myArrayAdapter.remove(item);
                        myArrayAdapter.notifyDataSetChanged();
                        databaseReference.child(keyList.get(position)).removeValue();
                        keyList.remove(position);
                       // myArrayAdapter.notifyDataSetChanged();

                        // finish();

                    }
                });
                alert.setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });



                AlertDialog dialog=alert.create();
                dialog.setMessage("are you sure want to delete");
                dialog.show();




            }

        });





    }
}
