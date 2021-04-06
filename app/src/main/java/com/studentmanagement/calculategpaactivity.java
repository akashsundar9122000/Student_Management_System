package com.studentmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class calculategpaactivity extends AppCompatActivity {
    private CardView sem1,sem2,sem3,sem4,sem5,sem6,sem7,sem8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculategpaactivity);
        sem1=findViewById(R.id.sem1);
        sem2=findViewById(R.id.sem2);
        sem3=findViewById(R.id.sem3);
        sem4=findViewById(R.id.sem4);
        sem5=findViewById(R.id.sem5);
        sem6=findViewById(R.id.sem6);
        sem7=findViewById(R.id.sem7);
        sem8=findViewById(R.id.sem8);

        sem1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent about_me_intent = new Intent(calculategpaactivity.this,Semester1.class);
                startActivity(about_me_intent);
            }
        });
        sem2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent about_me_intent = new Intent(calculategpaactivity.this,Semester2.class);
                startActivity(about_me_intent);
            }
        });

        sem3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent about_me_intent = new Intent(calculategpaactivity.this,Semester3.class);
                startActivity(about_me_intent);
            }
        });
        sem4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent about_me_intent = new Intent(calculategpaactivity.this,Semester4.class);
                startActivity(about_me_intent);
            }
        });
        sem5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent about_me_intent = new Intent(calculategpaactivity.this,Semester5.class);
                startActivity(about_me_intent);
            }
        });
        sem6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent about_me_intent = new Intent(calculategpaactivity.this,Semester6.class);
                startActivity(about_me_intent);
            }
        });
        sem7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent about_me_intent = new Intent(calculategpaactivity.this,Semester7.class);
                startActivity(about_me_intent);
            }
        });
        sem8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent about_me_intent = new Intent(calculategpaactivity.this,Semester8.class);
                startActivity(about_me_intent);
            }
        });
    }
}