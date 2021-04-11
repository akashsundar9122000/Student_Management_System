package com.studentmanagement.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

import com.studentmanagement.R;
import com.studentmanagement.Models.ExtraCurricular;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class ExtraCurricularAdapter extends RecyclerView.Adapter<ExtraCurricularAdapter.ImageViewHolder> {

    private Context mContext;
    private List<ExtraCurricular> mExtraCurricular;
    private DatabaseReference mExtraCurricularDatabase;


    public ExtraCurricularAdapter(Context context, List<ExtraCurricular> extraCurriculars){
        mContext = context;
        mExtraCurricular = extraCurriculars;
    }


    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.single_extra_curricular_layout, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ImageViewHolder holder, final int position) {

        final ExtraCurricular extraCurricular = mExtraCurricular.get(position);


        holder.activity_name.setText(extraCurricular.getActivity());
        holder.organisation.setText(extraCurricular.getOrganisation());
        holder.Pdf_Layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setDataAndType(Uri.parse(extraCurricular.getUrl()), "application/pdf");
                mContext.startActivity(browserIntent);
            }
        });
        holder.Pdf_Name.setText(FirebaseStorage.getInstance().getReferenceFromUrl(extraCurricular.getUrl()).getName());

        mExtraCurricularDatabase = FirebaseDatabase.getInstance().getReference("Extracurricular").child(extraCurricular.getUser_id()).child(extraCurricular.getExtracurricular_key());


        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                AlertDialog.Builder builder1 = new AlertDialog.Builder(mContext);
                builder1.setMessage("Do you want to Delete?");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                mExtraCurricularDatabase.removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
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
        return mExtraCurricular.size();
    }


    public class ImageViewHolder extends RecyclerView.ViewHolder {

        public TextView activity_name, organisation, Pdf_Name;
        private RelativeLayout Pdf_Layout;


        public ImageViewHolder(View itemView) {
            super(itemView);

            activity_name = itemView.findViewById(R.id.activity_name);
            organisation = itemView.findViewById(R.id.organisation);
            Pdf_Name = itemView.findViewById(R.id.pdf_name);
            Pdf_Layout = itemView.findViewById(R.id.pdf_layout);
        }
    }



}