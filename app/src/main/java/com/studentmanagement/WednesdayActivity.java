package com.studentmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;

public class WednesdayActivity extends AppCompatActivity {

    private CardView p1,p2,p3,p4,p5,p6,p7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monday);

        p1=findViewById(R.id.period1);
        p2=findViewById(R.id.period2);
        p3=findViewById(R.id.period3);
        p4=findViewById(R.id.period4);
        p5=findViewById(R.id.period5);
        p6=findViewById(R.id.period6);
        p7=findViewById(R.id.period7);

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

        p5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View hiddenView = p5.findViewById(R.id.Hidden5);
                hiddenView.setVisibility( hiddenView.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
            }
        });

        p6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View hiddenView = p6.findViewById(R.id.Hidden6);
                hiddenView.setVisibility( hiddenView.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
            }
        });

        p7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View hiddenView = p7.findViewById(R.id.Hidden7);
                hiddenView.setVisibility( hiddenView.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
            }
        });
    }
}