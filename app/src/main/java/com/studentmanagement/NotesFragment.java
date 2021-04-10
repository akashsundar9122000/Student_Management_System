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

import com.studentmanagement.Adapter.NotesAdapter;
import com.studentmanagement.Models.Notes;
import com.studentmanagement.Models.Student;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class NotesFragment extends Fragment {


    private RecyclerView Notes_list;


    private NotesAdapter notesAdapter;
    private List<Notes> notesList;
    private DatabaseReference mnotesDatabase, mUsersDatabase;

    private FirebaseUser mFirebaseUser;
    private String mCurrentUserId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notes, container, false);

        mFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        mCurrentUserId = mFirebaseUser.getUid();

        mUsersDatabase = FirebaseDatabase.getInstance().getReference("Student").child(mCurrentUserId);
        mUsersDatabase.keepSynced(true);

        Notes_list =  view.findViewById(R.id.note_list);
        Notes_list.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        mLayoutManager.setReverseLayout(true);
        mLayoutManager.setStackFromEnd(true);
        Notes_list.setLayoutManager(mLayoutManager);
        notesList = new ArrayList<> ();
        notesAdapter = new NotesAdapter(getContext(), notesList);
        Notes_list.setAdapter(notesAdapter);

        mUsersDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Student student = dataSnapshot.getValue(Student.class);
                mnotesDatabase = FirebaseDatabase.getInstance().getReference("Notes").child(student.getCreated_by());
                mnotesDatabase.keepSynced(true);

                readNotes();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });









        return view;
    }

    private void readNotes() {

        mnotesDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                notesList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Notes notes = snapshot.getValue(Notes.class);
                    notesList.add(notes);

                }
                Collections.reverse(notesList);
                notesAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}