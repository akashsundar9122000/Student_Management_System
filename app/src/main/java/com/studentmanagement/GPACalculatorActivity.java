package com.studentmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class GPACalculatorActivity extends AppCompatActivity {

    private CardView gpa,cgpa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g_p_a_calculator);
        gpa=findViewById(R.id.gpa);
        cgpa=findViewById(R.id.cgpa);
        gpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gpa_intent = new Intent(GPACalculatorActivity.this,calculategpaactivity.class);
                startActivity(gpa_intent);
            }
        });
        cgpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gpa_intent = new Intent(GPACalculatorActivity.this,CalculateCGPAActivity.class);
                startActivity(gpa_intent);
            }
        });
    }
}