package com.studentmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

public class Semester8 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester8);

        Spinner staticSpinner1 = (Spinner) findViewById(R.id.sub1);
        Spinner staticSpinner2 = (Spinner) findViewById(R.id.sub2);
        Spinner staticSpinner3 = (Spinner) findViewById(R.id.lab1);
        ImageButton result = (ImageButton) findViewById(R.id.result);


        // Create an ArrayAdapter using the string array and a default spinner
        ArrayAdapter<CharSequence> staticAdapter1 = ArrayAdapter
                .createFromResource(this, R.array.grade_array,
                        android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        staticAdapter1
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        staticSpinner1.setAdapter(staticAdapter1);

        ArrayAdapter<CharSequence> staticAdapter2 = ArrayAdapter
                .createFromResource(this, R.array.grade_array,
                        android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        staticAdapter2
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        staticSpinner2.setAdapter(staticAdapter2);

        ArrayAdapter<CharSequence> staticAdapter3 = ArrayAdapter
                .createFromResource(this, R.array.grade_array,
                        android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        staticAdapter3
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        staticSpinner3.setAdapter(staticAdapter3);


        result.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                int result = 0;
                String elective1_grade = staticSpinner1.getSelectedItem().toString();
                String elective2_grade = staticSpinner2.getSelectedItem().toString();
                String lab1_grade = staticSpinner3.getSelectedItem().toString();
                if (elective1_grade.equals("ENTER YOUR GRADE") || elective2_grade.equals("ENTER YOUR GRADE") || lab1_grade.equals("ENTER YOUR GRADE")) {
                    Toast.makeText(Semester8.this, "ENTER EVERY SUBJECT GRADE", Toast.LENGTH_SHORT).show();
                } else {

                    result = calculatetotal3credit(elective1_grade, result);
                    result = calculatetotal3credit(elective2_grade, result);
                    result = calculatetotal10credit(lab1_grade, result);
                    double gpa = result / 16.0;

                    Toast.makeText(Semester8.this, String.format("%.2f", gpa), Toast.LENGTH_SHORT).show();

                }
            }
        });


    }

    private int calculatetotal3credit(String sub, int result) {
        if (sub.equals("O")) {
            result += 30;
        } else if (sub.equals("A+")) {
            result += 27;
        } else if (sub.equals("A")) {
            result += 24;
        } else if (sub.equals("B+")) {
            result += 21;
        } else if (sub.equals("B")) {
            result += 18;
        } else if (sub.equals("RA")) {
            result += 0;
        }
        return result;

    }
    private int calculatetotal10credit(String sub, int result) {
        if (sub.equals("O")) {
            result += 100;
        } else if (sub.equals("A+")) {
            result += 90;
        } else if (sub.equals("A")) {
            result += 80;
        } else if (sub.equals("B+")) {
            result += 70;
        } else if (sub.equals("B")) {
            result += 60;
        } else if (sub.equals("RA")) {
            result += 0;
        }
        return result;

    }
}