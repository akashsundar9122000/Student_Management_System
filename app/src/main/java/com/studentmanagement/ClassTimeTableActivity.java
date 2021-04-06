package com.studentmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ClassTimeTableActivity extends AppCompatActivity {
    private CardView mon,tue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_time_table);

        mon=findViewById(R.id.mon);
        tue=findViewById(R.id.tue);

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
    }
}