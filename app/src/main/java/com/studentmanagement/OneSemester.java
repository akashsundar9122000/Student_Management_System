package com.studentmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class OneSemester extends AppCompatActivity {
   // double ans1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_semester);



       ImageButton imageButton=(ImageButton)findViewById(R.id.resultcgpa);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText editText=(EditText)findViewById(R.id.sem1cgpa);
                String val=editText.getText().toString();
                if(!"".equals(val)) {
                    double ans = Double.parseDouble(val);
                    double print = ans / 1;
                    String printString = Double.toString(print);
                    Toast.makeText(OneSemester.this, printString, Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(OneSemester.this, "ENTER THE GRADE", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}