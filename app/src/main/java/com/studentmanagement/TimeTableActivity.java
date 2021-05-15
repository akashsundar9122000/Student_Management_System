package com.studentmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
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
import com.studentmanagement.Adapter.TimeTableAdapter;
import com.studentmanagement.Models.Student;
import com.studentmanagement.Models.TimeTable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TimeTableActivity extends AppCompatActivity {
//    private CardView classtimetable, examtimetable;

    private RecyclerView Time_Table_List;
    private TimeTableAdapter timeTableAdapter;
    private List<TimeTable> timeTableList;
    private DatabaseReference mTimeTableDatabase, mUsersDatabase;
    private FloatingActionButton add;
    private FirebaseUser mFirebaseUser;
    private String mCurrentUserId,day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);

//        classtimetable=findViewById(R.id.classtimetable);
//        examtimetable=findViewById(R.id.examtimetable);
//
//        classtimetable.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent gpa_intent = new Intent(TimeTableActivity.this,ClassTimeTableActivity.class);
//                startActivity(gpa_intent);
//            }
//        });

        Intent intent = getIntent();

        day=intent.getStringExtra("Day");

        mFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        mCurrentUserId = mFirebaseUser.getUid();

        mUsersDatabase = FirebaseDatabase.getInstance().getReference("Student").child(mCurrentUserId);
        mUsersDatabase.keepSynced(true);

        mUsersDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Student student = dataSnapshot.getValue(Student.class);
                mTimeTableDatabase = FirebaseDatabase.getInstance().getReference("TimeTable").child(student.getCreated_by());
                mTimeTableDatabase.keepSynced(true);

                readPrograms();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



        Time_Table_List =  findViewById(R.id.time_table_list);
        Time_Table_List.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(TimeTableActivity.this);
        mLayoutManager.setReverseLayout(true);
        mLayoutManager.setStackFromEnd(true);
        Time_Table_List.setLayoutManager(mLayoutManager);
        timeTableList = new ArrayList<>();
        timeTableAdapter = new TimeTableAdapter(TimeTableActivity.this, timeTableList);
        Time_Table_List.setAdapter(timeTableAdapter);




    }
    private void readPrograms() {

        mTimeTableDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                timeTableList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    TimeTable timeTable = snapshot.getValue(TimeTable.class);
                    if(timeTable.getDay().equals(day)){
                        timeTableList.add(timeTable);
                    }

                }
                Collections.reverse(timeTableList);
                timeTableAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}