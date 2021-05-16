package com.studentmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SemesterActivity extends AppCompatActivity {

    private CardView previous,current;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester);

        previous=findViewById(R.id.previoussemester);

        current=findViewById(R.id.currentsemester);

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gpa_intent = new Intent(SemesterActivity.this,PreviousSemesterActivity.class);
                startActivity(gpa_intent);
            }
        });

        current.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gpa_intent = new Intent(SemesterActivity.this,PreviousSemesterActivity.class);
                startActivity(gpa_intent);
            }
        });
    }
}