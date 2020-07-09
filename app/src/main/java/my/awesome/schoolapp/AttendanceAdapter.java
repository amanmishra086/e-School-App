package my.awesome.schoolapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//import com.example.schoolapp.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class AttendanceAdapter extends RecyclerView.Adapter<AttendanceAdapter.MyViewHolder> {

   private String subject;
    private String day;
    private String month;
    private String year;
    private Context mcontext;
    private List<StoreStudent> arrayList;//StoreNotice=ListData,mdata=listData.
    DatabaseReference databaseReference;


    public AttendanceAdapter(Context mcontext, List<StoreStudent> arrayList, String subject, String day,String month,String year) {
        this.mcontext =  mcontext;
        this.arrayList = arrayList;
        this.subject=subject;
        this.day=day;
        this.month=month;
        this.year=year;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;   //=LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item,parent,false);
        LayoutInflater minflater=LayoutInflater.from(mcontext);
        view=minflater.inflate(R.layout.attendacerecyclerview_item,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        StoreStudent sn=arrayList.get(position);
        holder.tv_name.setText("Name:-"+sn.getName());
        holder.tv_Roll.setText("Roll:-"+sn.getRoll());

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mcontext, "linearlayout clicked", Toast.LENGTH_SHORT).show();

                //Intent intent=new Intent(mcontext,NoticeDetail.class);
                //intent.putExtra("Subject",arrayList.get(position).getSubject());
                //intent.putExtra("Notice",arrayList.get(position).getNotice());
               // mcontext.startActivity(intent);
            }
        });
        holder.present.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mcontext, "present clicked", Toast.LENGTH_SHORT).show();
                String Name=arrayList.get(position).getName();
                String Roll=arrayList.get(position).getRoll();
                String attend="present";

                String Class=arrayList.get(position).getClassname();
                String Section =arrayList.get(position).getSection();

                StoreAttendance storeAttendance=new StoreAttendance(Name,Roll,attend);

                databaseReference = FirebaseDatabase.getInstance().getReference("Attendance").child(Class).child(Section);


                databaseReference.child(year).child(month).child(day).child(Roll).setValue(storeAttendance);
            }
        });
        holder.absent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mcontext, "absent clicked", Toast.LENGTH_SHORT).show();
                String Name=arrayList.get(position).getName();
                String Roll=arrayList.get(position).getRoll();
                String attend="Absent";
                String Class=arrayList.get(position).getClassname();
                String Section =arrayList.get(position).getSection();
                databaseReference= FirebaseDatabase.getInstance().getReference("Attendance").child(Class).child(Section);

                StoreAttendance storeAttendance=new StoreAttendance(Name,Roll,attend);
                databaseReference.child(year).child(month).child(day).child(Roll).setValue(storeAttendance);
            }
        });
      /*  holder.submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //databaseReference=FirebaseDatabase.getInstance().getReference("Attendance").child("3rd").
                        //child("B").child("Math");

            }
        });*/

    }



    @Override
    public int getItemCount() {
        return arrayList.size();
    }



    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_name,tv_Roll;
       // Button submit_btn;
        RadioButton present,absent;
        LinearLayout linearLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_name=(TextView)itemView.findViewById(R.id.rv_Student_name);
            tv_Roll=(TextView)itemView.findViewById(R.id.rv_roll);
            present= (RadioButton) itemView.findViewById(R.id.Radio_present);
            absent= (RadioButton) itemView.findViewById(R.id.Radio_absent);
            linearLayout=(LinearLayout)itemView.findViewById(R.id.Attendance_linearLayout_id);
            //submit_btn=(Button)itemView.findViewById(R.id.Attendance_submit_btn);



        }
    }
}
