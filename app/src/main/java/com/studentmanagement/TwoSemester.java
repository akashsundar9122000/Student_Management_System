package com.studentmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class TwoSemester extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_semester);

        ImageButton imageButton=(ImageButton)findViewById(R.id.resultcgpa);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText editText1=(EditText)findViewById(R.id.sem1cgpa);
                EditText editText2=(EditText)findViewById(R.id.sem2cgpa);
                String val1=editText1.getText().toString();
                String val2=editText2.getText().toString();
                if(!"".equals(val1) && !"".equals(val2)) {
                    double ans1 = Double.parseDouble(val1);
                    double ans2 = Double.parseDouble(val2);
                    double print = (ans1 + ans2) / 2.0;
                    String printString = String.format("%.2f", print);
                    Toast.makeText(TwoSemester.this, printString, Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(TwoSemester.this, "ENTER EVERY SEMESTER GRADES", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}