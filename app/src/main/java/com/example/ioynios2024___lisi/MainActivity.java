package com.example.ioynios2024___lisi;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //gia na valw ta onomata sto spinner
        StudentList stl = new StudentList(getAssets());
        Spinner sp = (Spinner)findViewById(R.id.spinner);   //meta to R.id. vazo to id tou spinner
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, stl.getStudentNames());
        sp.setAdapter(arrayAdapter);

        //gia na patame to koumpi kai na kanei energeies
        Button btn = (Button)findViewById(R.id.button);    //meta to R.id. vazo to id tou button
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String spValue = String.valueOf(sp.getSelectedItem());   //gia na pareo timiapo to spinner
                String apotelesma = stl.getAverage(spValue);
                Toast.makeText(getApplicationContext(), "Average of Student: " + apotelesma, Toast.LENGTH_LONG).show();
            }
        });



    }
}