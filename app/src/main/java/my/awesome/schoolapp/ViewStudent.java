package my.awesome.schoolapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

//import com.example.schoolapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ViewStudent extends AppCompatActivity {

    Spinner Class,Section;
    Button View_student;

    ListView listView;

    ArrayList<String> myArrayList=new ArrayList<>();
    ArrayList<String> keyList=new ArrayList<>();

    DatabaseReference databaseReference;

    AlertDialog.Builder alert;
   // DatabaseReference databaseReference1;
    //DatabaseReference databaseReference2;
    //ArrayAdapter<String> myArrayAdapter;   //=new ArrayAdapter<String>(ViewStudent.this,android.R.layout.simple_list_item_1,myArrayList);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_student);
        alert=new AlertDialog.Builder(this);

        listView=findViewById(R.id.listView);
        Class=findViewById(R.id.View_Class);
        Section=findViewById(R.id.View_section);
        View_student=findViewById(R.id.ViewStudent_btn);

       final ArrayAdapter<String> myArrayAdapter =new ArrayAdapter<>(ViewStudent.this,android.R.layout.simple_list_item_1,myArrayList);

        listView.setAdapter(myArrayAdapter);

         View_student.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                  String Class_name=Class.getSelectedItem().toString().trim();
                  String Section_name=Section.getSelectedItem().toString().trim();

                 databaseReference= FirebaseDatabase.getInstance().getReference("STUDENTS").child(Class_name).child(Section_name);

                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        for(DataSnapshot ds : dataSnapshot.getChildren()){
                            StoreStudent student =ds.getValue(StoreStudent.class);
                            keyList.add(ds.getKey());
                            String name="Name:-"+student.getName()+"\n"+"Roll:-"+student.getRoll()+"  "+"Phone:-"+student.getPhone();
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
                         databaseReference.child(keyList.get(position)).removeValue();
                         keyList.remove(position);
                         myArrayAdapter.notifyDataSetChanged();

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
