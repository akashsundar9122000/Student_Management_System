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
import com.studentmanagement.Adapter.ExtraCurricularAdapter;
import com.studentmanagement.Models.ExtraCurricular;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;




    public class ExtraCurricularActivity extends AppCompatActivity {
        private RecyclerView ExtraCurricular_List;
        private FloatingActionButton Add;

        private ExtraCurricularAdapter extraCurricularAdapter;
        private List<ExtraCurricular> extraCurricularList;
        private DatabaseReference mExtraCurricularDatabase;

        private FirebaseUser mFirebaseUser;
        private String mCurrentUserId;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_extra_curricular);


            mFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        mCurrentUserId = mFirebaseUser.getUid();

        mExtraCurricularDatabase = FirebaseDatabase.getInstance().getReference("Extracurricular").child(mCurrentUserId);
        mExtraCurricularDatabase.keepSynced(true);

        ExtraCurricular_List = findViewById(R.id.extracurricular_list);
        ExtraCurricular_List.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(ExtraCurricularActivity.this);
        mLayoutManager.setReverseLayout(true);
        mLayoutManager.setStackFromEnd(true);
        ExtraCurricular_List.setLayoutManager(mLayoutManager);
        extraCurricularList = new ArrayList<>();
        extraCurricularAdapter = new ExtraCurricularAdapter(ExtraCurricularActivity.this, extraCurricularList);
        ExtraCurricular_List.setAdapter(extraCurricularAdapter);

        readExtraCurricular();
        Add = findViewById(R.id.add);

        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent add_extracurricular=new Intent(ExtraCurricularActivity.this,NewExtraCurricularActivity.class);
                startActivity(add_extracurricular);
            }
        });



    }

    private void readExtraCurricular() {

        mExtraCurricularDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                extraCurricularList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    ExtraCurricular extraCurricular = snapshot.getValue(ExtraCurricular.class);
                    extraCurricularList.add(extraCurricular);

                }
                Collections.reverse(extraCurricularList);
                extraCurricularAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}