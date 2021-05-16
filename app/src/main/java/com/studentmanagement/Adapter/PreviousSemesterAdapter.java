package com.studentmanagement.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.studentmanagement.Models.ExtraCurricular;
import com.studentmanagement.Models.PreviousSemester;
import com.studentmanagement.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

public class PreviousSemesterAdapter extends RecyclerView.Adapter<PreviousSemesterAdapter.ImageViewHolder> {

    private Context mContext;
    private List<PreviousSemester> mPreviousSemester;
    private DatabaseReference mPreviousSemesterDatabase;


    public PreviousSemesterAdapter(Context context, List<PreviousSemester> previousSemesters){
        mContext = context;
        mPreviousSemester = previousSemesters;
    }


    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.single_previous_semester_layout, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ImageViewHolder holder, final int position) {

        final PreviousSemester previousSemester = mPreviousSemester.get(position);


        holder.semester_name.setText(previousSemester.getSemester_name());
        Glide.with(mContext).load(previousSemester.getUrl()).into(holder.Image);

        holder.Image_Name.setText(FirebaseStorage.getInstance().getReferenceFromUrl(previousSemester.getUrl()).getName());




        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                mPreviousSemesterDatabase = FirebaseDatabase.getInstance().getReference("PreviousSemester").child(previousSemester.getUser_id()).child(previousSemester.getPrevioussemester_key());

                AlertDialog.Builder builder1 = new AlertDialog.Builder(mContext);
                builder1.setMessage("Do you want to Delete?");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                mPreviousSemesterDatabase.removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isComplete()){
                                            Toast.makeText(mContext, "Successfully Deleted.", Toast.LENGTH_SHORT).show();
                                            dialog.cancel();
                                        }
                                    }
                                });

                            }
                        });

                builder1.setNegativeButton(
                        "No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();
                return false;
            }
        });



}



    @Override
    public int getItemCount() {
        return mPreviousSemester.size();
    }


    public class ImageViewHolder extends RecyclerView.ViewHolder {

        public TextView semester_name, Image_Name;
        private RelativeLayout Image_Layout;
        private ImageView Image;


        public ImageViewHolder(View itemView) {
            super(itemView);

            semester_name = itemView.findViewById(R.id.semester_name);
            Image_Name = itemView.findViewById(R.id.image_name);
            Image_Layout = itemView.findViewById(R.id.image_layout);
            Image = itemView.findViewById(R.id.image);
        }
    }



}