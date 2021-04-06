package com.studentmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

public class Semester7 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester7);

        Spinner staticSpinner1 = (Spinner) findViewById(R.id.sub1);
        Spinner staticSpinner2=(Spinner)findViewById(R.id.sub2);
        Spinner staticSpinner3 = (Spinner) findViewById(R.id.sem);
        Spinner staticSpinner4=(Spinner)findViewById(R.id.sub4);
        Spinner staticSpinner5 = (Spinner) findViewById(R.id.sub5);
        Spinner staticSpinner6=(Spinner)findViewById(R.id.sub6);
        Spinner staticSpinner7=(Spinner)findViewById(R.id.lab1);
        Spinner staticSpinner8=(Spinner)findViewById(R.id.lab2);
        ImageButton result=(ImageButton) findViewById(R.id.result);


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

        ArrayAdapter<CharSequence> staticAdapter4 = ArrayAdapter
                .createFromResource(this, R.array.grade_array,
                        android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        staticAdapter4
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        staticSpinner4.setAdapter(staticAdapter4);

        ArrayAdapter<CharSequence> staticAdapter5 = ArrayAdapter
                .createFromResource(this, R.array.grade_array,
                        android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        staticAdapter5
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        staticSpinner5.setAdapter(staticAdapter5);

        ArrayAdapter<CharSequence> staticAdapter6 = ArrayAdapter
                .createFromResource(this, R.array.grade_array,
                        android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        staticAdapter6
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        staticSpinner6.setAdapter(staticAdapter6);

        ArrayAdapter<CharSequence> staticAdapter7 = ArrayAdapter
                .createFromResource(this, R.array.grade_array,
                        android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        staticAdapter7
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        staticSpinner7.setAdapter(staticAdapter7);


        ArrayAdapter<CharSequence> staticAdapter8 = ArrayAdapter
                .createFromResource(this, R.array.grade_array,
                        android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        staticAdapter8
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        staticSpinner8.setAdapter(staticAdapter8);



        result.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                int result = 0;
                String pom_grade = staticSpinner1.getSelectedItem().toString();
                String cnc_grade = staticSpinner2.getSelectedItem().toString();
                String cc_grade = staticSpinner3.getSelectedItem().toString();
                String elective1_grade = staticSpinner4.getSelectedItem().toString();
                String elective2_grade = staticSpinner5.getSelectedItem().toString();
                String elective3_grade = staticSpinner6.getSelectedItem().toString();
                String lab1_grade = staticSpinner7.getSelectedItem().toString();
                String lab2_grade = staticSpinner8.getSelectedItem().toString();
                if (pom_grade.equals("ENTER YOUR GRADE") || cnc_grade.equals("ENTER YOUR GRADE") || cc_grade.equals("ENTER YOUR GRADE") || elective1_grade.equals("ENTER YOUR GRADE")
                        || elective2_grade.equals("ENTER YOUR GRADE") || elective3_grade.equals("ENTER YOUR GRADE") || lab1_grade.equals("ENTER YOUR GRADE") || lab2_grade.equals("ENTER YOUR GRADE")
                ) {
                    Toast.makeText(Semester7.this, "ENTER EVERY SUBJECT GRADE", Toast.LENGTH_SHORT).show();
                } else {
                    result = calculatetotal3credit(pom_grade, result);
                    result = calculatetotal3credit(cnc_grade, result);
                    result = calculatetotal3credit(cc_grade, result);
                    result = calculatetotal3credit(elective1_grade, result);
                    result = calculatetotal3credit(elective2_grade, result);
                    result = calculatetotal3credit(elective3_grade, result);
                    result = calculatetotal2credit(lab1_grade, result);
                    result = calculatetotal2credit(lab2_grade, result);
                    double gpa = result / 22.0;

                    Toast.makeText(Semester7.this, String.format("%.2f", gpa), Toast.LENGTH_SHORT).show();

                }
            }
        });


    }

    private int calculatetotal3credit(String sub,int result){
        if(sub.equals("O")){
            result+=30;
        }
        else if(sub.equals("A+")){
            result +=27;
        }
        else if(sub.equals("A")){
            result+=24;
        }
        else if(sub.equals("B+")){
            result +=21;
        }
        else if(sub.equals("B")){
            result +=18;
        }
        else if(sub.equals("RA")){
            result+=0;
        }
        return result;

    }
    private int calculatetotal2credit(String sub,int result){
        if(sub.equals("O")){
            result+=20;
        }
        else if(sub.equals("A+")){
            result +=18;
        }
        else if(sub.equals("A")){
            result+=16;
        }
        else if(sub.equals("B+")){
            result +=14;
        }
        else if(sub.equals("B")){
            result +=12;
        }
        else if(sub.equals("RA")){
            result+=0;
        }
        return result;

    }
}