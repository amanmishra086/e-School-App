package my.awesome.schoolapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//import com.example.schoolapp.R;


import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {


    private Context mcontext;
    private List<StoreNotice> arrayList;//StoreNotice=ListData,mdata=listData.

    public RecyclerViewAdapter(Context mcontext,List<StoreNotice> arrayList) {
        this.mcontext =  mcontext;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;   //=LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item,parent,false);
        LayoutInflater minflater=LayoutInflater.from(mcontext);
        view=minflater.inflate(R.layout.recyclerview_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        StoreNotice sn=arrayList.get(position);
        holder.tv_Subject.setText(sn.getSubject());

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mcontext,NoticeDetail.class);
                intent.putExtra("Subject",arrayList.get(position).getSubject());
               intent.putExtra("Notice",arrayList.get(position).getNotice());
                mcontext.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_Subject;
        //TextView tv_Notice;
        LinearLayout linearLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_Subject=(TextView)itemView.findViewById(R.id.rv_subject);
            linearLayout=(LinearLayout)itemView.findViewById(R.id.linearLayout_id);



        }
    }


}
