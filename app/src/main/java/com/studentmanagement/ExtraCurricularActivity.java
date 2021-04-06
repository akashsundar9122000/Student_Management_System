package com.studentmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.tv.TvContract;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.studentmanagement.Models.Extra_curricular;

import java.util.ArrayList;
import java.util.List;

public class ExtraCurricularActivity extends AppCompatActivity {

    private RecyclerView Extra_Curricular_List;
    private Extra_curricular_Adapter programAdapter;
    private List<Extra_curricular> extraCurricularList;
    private DatabaseReference mExtracurricularDatabase;
    private FloatingActionButton add;
    private FirebaseUser mFirebaseUser;
    private String mCurrentUserId;
    private Uri mImageUri;
    private StorageTask mUploadTask;
    private StorageReference mProfileImageStorage;
    private DatabaseReference mExtraCurricularDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra_curricular);

        mFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        mCurrentUserId = mFirebaseUser.getUid();

        mExtraCurricularDatabase = FirebaseDatabase.getInstance().getReference("Extra_Curricular").child(mCurrentUserId);
        mExtraCurricularDatabase.keepSynced(true);

        Extra_Curricular_List =  findViewById(R.id.extra_curricular_list);
        Extra_Curricular_List.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(ExtraCurricularActivity.this);
        mLayoutManager.setReverseLayout(true);
        mLayoutManager.setStackFromEnd(true);
        Extra_Curricular_List.setLayoutManager(mLayoutManager);
        extraCurricularList = new ArrayList<>();
        programAdapter = new Extra_curricular_Adapter(ExtraCurricularActivity.this, extraCurricularList);
        Extra_Curricular_List.setAdapter(programAdapter);

        mExtracurricularDatabase = FirebaseDatabase.getInstance().getReference().child("Extra_Curricular").child(mCurrentUserId);
        mExtracurricularDatabase.keepSynced(true);
        readPrograms();
        add=findViewById(R.id.add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent add_extra_curricular=new Intent(ExtraCurricularActivity.this,NewExtraCurricularActivity.class);
                startActivity(add_extra_curricular);
            }
        });


    }
    private void readPrograms() {

        mExtracurricularDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                extraCurricularList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                     Extra_curricular  Extra_curricular = snapshot.getValue(Extra_curricular.class);
                    extraCurricularList.add(Extra_curricular);
                }
                programAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}