package com.studentmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.studentmanagement.Adapter.MaterialsAdapter;

import com.studentmanagement.Models.Materials;
import com.studentmanagement.Models.Student;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MaterialsFragment extends Fragment {


    private RecyclerView Materials_List;


    private MaterialsAdapter materialsAdapter;
    private List<Materials> materialsList;
    private DatabaseReference mMaterialsDatabase, mUsersDatabase;

    private FirebaseUser mFirebaseUser;
    private String mCurrentUserId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_materials, container, false);

        mFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        mCurrentUserId = mFirebaseUser.getUid();

        mUsersDatabase = FirebaseDatabase.getInstance().getReference("Student").child(mCurrentUserId);
        mUsersDatabase.keepSynced(true);

        Materials_List =  view.findViewById(R.id.material_list);
        Materials_List.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        mLayoutManager.setReverseLayout(true);
        mLayoutManager.setStackFromEnd(true);
        Materials_List.setLayoutManager(mLayoutManager);
        materialsList = new ArrayList<>();
        materialsAdapter = new MaterialsAdapter(getContext(), materialsList);
        Materials_List.setAdapter(materialsAdapter);

        mUsersDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Student student = dataSnapshot.getValue(Student.class);
                mMaterialsDatabase = FirebaseDatabase.getInstance().getReference("Materials").child(student.getCreated_by());
                mMaterialsDatabase.keepSynced(true);

                readMaterials();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });









        return view;
    }

    private void readMaterials() {

        mMaterialsDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                materialsList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Materials materials = snapshot.getValue(Materials.class);
                    materialsList.add(materials);

                }
                Collections.reverse(materialsList);
                materialsAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}