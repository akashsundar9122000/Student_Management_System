package com.studentmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;

public class MondayActivity extends AppCompatActivity {

    private CardView p1,p2,p3,p4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monday);

        p1=findViewById(R.id.period1);
        p2=findViewById(R.id.period2);
        p3=findViewById(R.id.period3);
        p4=findViewById(R.id.period4);

        p1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View hiddenView = p1.findViewById(R.id.Hidden1);
                hiddenView.setVisibility( hiddenView.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
            }
        });

        p2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View hiddenView = p2.findViewById(R.id.Hidden2);
                hiddenView.setVisibility( hiddenView.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
            }
        });

        p3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View hiddenView = p3.findViewById(R.id.Hidden3);
                hiddenView.setVisibility( hiddenView.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
            }
        });
        p4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View hiddenView = p4.findViewById(R.id.Hidden4);
                hiddenView.setVisibility( hiddenView.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
            }
        });
    }
}