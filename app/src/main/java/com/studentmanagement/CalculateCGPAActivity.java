package com.studentmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

public class CalculateCGPAActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_c_g_p_a);

        Spinner staticSpinner1 = (Spinner) findViewById(R.id.sem);
        ImageButton result=(ImageButton)findViewById(R.id.result);

        ArrayAdapter<CharSequence> staticAdapter1 = ArrayAdapter
                .createFromResource(this, R.array.sem_array,
                        android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        staticAdapter1
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        staticSpinner1.setAdapter(staticAdapter1);

        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String res=staticSpinner1.getSelectedItem().toString();
                if(res.equals("0")){
                    Toast.makeText(CalculateCGPAActivity.this, "SELECT THE NO.OF SEMESTERS", Toast.LENGTH_SHORT).show();
                }
                else if(res.equals("1")){
                    Intent onesem = new Intent(CalculateCGPAActivity.this,OneSemester.class);
                    startActivity(onesem);
                }
                else if(res.equals("2")){
                    Intent twosem = new Intent(CalculateCGPAActivity.this,TwoSemester.class);
                    startActivity(twosem);
                }
                else if(res.equals("3")){
                    Intent threesem = new Intent(CalculateCGPAActivity.this,ThreeSemester.class);
                    startActivity(threesem);
                }
                else if(res.equals("4")){
                    Intent foursem = new Intent(CalculateCGPAActivity.this,FourSemester.class);
                    startActivity(foursem);
                }
                else if(res.equals("5")){
                    Intent fivesem = new Intent(CalculateCGPAActivity.this,FiveSemester.class);
                    startActivity(fivesem);
                }
                else if(res.equals("6")){
                    Intent sixsem = new Intent(CalculateCGPAActivity.this,SixSemester.class);
                    startActivity(sixsem);
                }
                else if(res.equals("7")){
                    Intent sevensem = new Intent(CalculateCGPAActivity.this,SevenSemester.class);
                    startActivity(sevensem);
                }
                else if(res.equals("8")){
                    Intent eightsem = new Intent(CalculateCGPAActivity.this,EightSemester.class);
                    startActivity(eightsem);
                }
            }
        });

    }
}