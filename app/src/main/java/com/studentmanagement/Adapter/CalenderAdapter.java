package com.studentmanagement.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.studentmanagement.CalenderActivity;
import com.studentmanagement.Models.Calender;
import com.studentmanagement.R;
import com.studentmanagement.TimeTableActivity;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CalenderAdapter extends RecyclerView.Adapter<CalenderAdapter.ImageViewHolder> {

    private Context mContext;
    private List<Calender> mUsers;


    CalenderActivity activity;


    public CalenderAdapter(CalenderActivity application, Context context, List<Calender> users){
        mContext = context;
        mUsers = users;
        activity = application;
    }


    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.single_calender_layout, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ImageViewHolder holder, final int position) {

        final Calender calender = mUsers.get(position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent add_time_table=new Intent(mContext, TimeTableActivity.class);
                add_time_table.putExtra("Day",calender.getDay());
                mContext.startActivity(add_time_table);
            }
        });



        holder.Day.setText(calender.getDay());



    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }


    public class ImageViewHolder extends RecyclerView.ViewHolder {

        public TextView Day;
        public LinearLayout Circle_Day;

        public ImageViewHolder(View itemView) {
            super(itemView);

            Day = itemView.findViewById(R.id.day);

            Circle_Day = itemView.findViewById(R.id.circle_date);
        }
    }



}