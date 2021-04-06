package com.studentmanagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.studentmanagement.Models.Extra_curricular;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Extra_curricular_Adapter extends RecyclerView.Adapter<Extra_curricular_Adapter.ImageViewHolder> {

    private Context mContext;
    private List<Extra_curricular> mFeature;




    public Extra_curricular_Adapter(Context context, List<Extra_curricular> features){
        mContext = context;
        mFeature = features;
    }


    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.single_extra_curricular_layout, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ImageViewHolder holder, final int position) {

        final Extra_curricular feature = mFeature.get(position);

        holder.Activity.setText(feature.getActivity());
        holder.Orgnaisation.setText(feature.getOrganisation());

    }

    @Override
    public int getItemCount() {
        return mFeature.size();
    }


    public class ImageViewHolder extends RecyclerView.ViewHolder {

        public TextView Activity,Orgnaisation;

        public ImageViewHolder(View itemView) {
            super(itemView);

            Activity = itemView.findViewById(R.id.activity);
            Orgnaisation = itemView.findViewById(R.id.organisation);
        }
    }
}