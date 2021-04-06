package com.studentmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TimeTableActivity extends AppCompatActivity {
    private CardView classtimetable, examtimetable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);

        classtimetable=findViewById(R.id.classtimetable);
        examtimetable=findViewById(R.id.examtimetable);

        classtimetable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gpa_intent = new Intent(TimeTableActivity.this,ClassTimeTableActivity.class);
                startActivity(gpa_intent);
            }
        });
    }
}