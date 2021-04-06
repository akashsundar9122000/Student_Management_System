package com.studentmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class ThreeSemester extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_semester);

        ImageButton imageButton=(ImageButton)findViewById(R.id.resultcgpa);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText editText1=(EditText)findViewById(R.id.sem1cgpa);
                EditText editText2=(EditText)findViewById(R.id.sem2cgpa);
                EditText editText3=(EditText)findViewById(R.id.sem3cgpa);
                String val1=editText1.getText().toString();
                String val2=editText2.getText().toString();
                String val3=editText3.getText().toString();
                if(!"".equals(val1) && !"".equals(val2) && !"".equals(val3)) {
                    double ans1 = Double.parseDouble(val1);
                    double ans2 = Double.parseDouble(val2);
                    double ans3 = Double.parseDouble(val3);
                    double print = (ans1 + ans2 + ans3) / 3.0;
                    String printString = String.format("%.2f", print);
                    Toast.makeText(ThreeSemester.this, printString, Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(ThreeSemester.this, "ENTER GRADES FOR EVERY SEMESTER", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}