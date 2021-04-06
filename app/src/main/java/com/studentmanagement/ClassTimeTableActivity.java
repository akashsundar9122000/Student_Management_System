package com.studentmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ClassTimeTableActivity extends AppCompatActivity {
    private CardView mon,tue,wed,thu,fri,sat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_time_table);

        mon=findViewById(R.id.mon);
        tue=findViewById(R.id.tue);
        wed=findViewById(R.id.wed);
        thu=findViewById(R.id.thu);
        fri=findViewById(R.id.fri);
        sat=findViewById(R.id.sat);

        mon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gpa_intent = new Intent(ClassTimeTableActivity.this,MondayActivity.class);
                startActivity(gpa_intent);
            }
        });

        tue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gpa_intent = new Intent(ClassTimeTableActivity.this,TuesdayActivity.class);
                startActivity(gpa_intent);
            }
        });

        wed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gpa_intent = new Intent(ClassTimeTableActivity.this,WednesdayActivity.class);
                startActivity(gpa_intent);
            }
        });

        thu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gpa_intent = new Intent(ClassTimeTableActivity.this,ThursdayActivity.class);
                startActivity(gpa_intent);
            }
        });

        fri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gpa_intent = new Intent(ClassTimeTableActivity.this,FridayActivity.class);
                startActivity(gpa_intent);
            }
        });

        sat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gpa_intent = new Intent(ClassTimeTableActivity.this,SaturdayActivity.class);
                startActivity(gpa_intent);
            }
        });
    }
}