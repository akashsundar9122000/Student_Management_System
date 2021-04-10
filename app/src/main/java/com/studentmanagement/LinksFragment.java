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
import com.studentmanagement.Adapter.LinkAdapter;
import com.studentmanagement.Adapter.MaterialsAdapter;

import com.studentmanagement.Models.Links;
import com.studentmanagement.Models.Student;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class LinksFragment extends Fragment {


    private RecyclerView Links_List;


    private LinkAdapter linkAdapter;
    private List<Links> linksList;
    private DatabaseReference mLinksDatabase, mUsersDatabase;

    private FirebaseUser mFirebaseUser;
    private String mCurrentUserId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_links, container, false);

        mFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        mCurrentUserId = mFirebaseUser.getUid();

        mUsersDatabase = FirebaseDatabase.getInstance().getReference("Student").child(mCurrentUserId);
        mUsersDatabase.keepSynced(true);

        Links_List =  view.findViewById(R.id.link_list);
        Links_List.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        mLayoutManager.setReverseLayout(true);
        mLayoutManager.setStackFromEnd(true);
        Links_List.setLayoutManager(mLayoutManager);
        linksList = new ArrayList<>();
        linkAdapter = new LinkAdapter(getContext(), linksList);
        Links_List.setAdapter(linkAdapter);

        mUsersDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Student student = dataSnapshot.getValue(Student.class);
                mLinksDatabase = FirebaseDatabase.getInstance().getReference("Links").child(student.getCreated_by());
                mLinksDatabase.keepSynced(true);

                readLinks();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });









        return view;
    }

    private void readLinks() {

        mLinksDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                linksList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Links materials = snapshot.getValue(Links.class);
                    linksList.add(materials);

                }
                Collections.reverse(linksList);
                linkAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}