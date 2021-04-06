package com.studentmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

public class Semester5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester5);

        Spinner staticSpinner1 = (Spinner) findViewById(R.id.sub1);
        Spinner staticSpinner2=(Spinner)findViewById(R.id.sub2);
        Spinner staticSpinner3 = (Spinner) findViewById(R.id.sem);
        Spinner staticSpinner4=(Spinner)findViewById(R.id.sub4);
        Spinner staticSpinner5 = (Spinner) findViewById(R.id.sub5);
        Spinner staticSpinner6=(Spinner)findViewById(R.id.sub6);
        Spinner staticSpinner7=(Spinner)findViewById(R.id.lab1);
        Spinner staticSpinner8=(Spinner)findViewById(R.id.lab2);
        Spinner staticSpinner9=(Spinner)findViewById(R.id.lab3);
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


        ArrayAdapter<CharSequence> staticAdapter9 = ArrayAdapter
                .createFromResource(this, R.array.grade_array,
                        android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        staticAdapter9
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        staticSpinner9.setAdapter(staticAdapter9);


        result.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                int result=0;
                String ant_grade=staticSpinner1.getSelectedItem().toString();
                String cn_grade=staticSpinner2.getSelectedItem().toString();
                String mpmc_grade=staticSpinner3.getSelectedItem().toString();
                String toc_grade=staticSpinner4.getSelectedItem().toString();
                String ooad_grade=staticSpinner5.getSelectedItem().toString();
                String gis_grade=staticSpinner6.getSelectedItem().toString();
                String lab1_grade=staticSpinner7.getSelectedItem().toString();
                String lab2_grade=staticSpinner8.getSelectedItem().toString();
                String lab3_grade=staticSpinner9.getSelectedItem().toString();

                if(ant_grade.equals("ENTER YOUR GRADE") || cn_grade.equals("ENTER YOUR GRADE") || mpmc_grade.equals("ENTER YOUR GRADE") || toc_grade.equals("ENTER YOUR GRADE")
                        || ooad_grade.equals("ENTER YOUR GRADE") || gis_grade.equals("ENTER YOUR GRADE") || lab1_grade.equals("ENTER YOUR GRADE") || lab2_grade.equals("ENTER YOUR GRADE")
                        || lab3_grade.equals("ENTER YOUR GRADE")){
                    Toast.makeText(Semester5.this, "ENTER EVERY SUBJECT GRADE", Toast.LENGTH_SHORT).show();
                }
                else {
                    result = calculatetotal4credit(ant_grade, result);
                    result = calculatetotal3credit(cn_grade, result);
                    result = calculatetotal3credit(mpmc_grade, result);
                    result = calculatetotal3credit(toc_grade, result);
                    result = calculatetotal3credit(ooad_grade, result);
                    result = calculatetotal3credit(gis_grade, result);
                    result = calculatetotal2credit(lab1_grade, result);
                    result = calculatetotal2credit(lab2_grade, result);
                    result = calculatetotal2credit(lab3_grade, result);
                    double gpa = result / 25.0;

                    Toast.makeText(Semester5.this, String.format("%.2f", gpa), Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
    private int calculatetotal4credit(String sub,int result){
        if(sub.equals("O")){
            result+=40;
        }
        else if(sub.equals("A+")){
            result +=36;
        }
        else if(sub.equals("A")){
            result+=32;
        }
        else if(sub.equals("B+")){
            result +=28;
        }
        else if(sub.equals("B")){
            result +=24;
        }
        else if(sub.equals("RA")){
            result+=0;
        }
        return result;

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