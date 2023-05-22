package com.example.businessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edbuy,edper;
    TextView tvDisplay;
    Button but;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edbuy = findViewById(R.id.edbuy);
        edper = findViewById(R.id.edper);
        tvDisplay = findViewById(R.id.tvDisplay);
        but = findViewById(R.id.but);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float buy, sell, per;

                String sbuy = edbuy.getText().toString();
                buy = Float.parseFloat(sbuy);

                String sper = edper.getText().toString();
                per = Float.parseFloat(sper);

                sell =  buy*(per/100)+buy;

                tvDisplay.setText("Your Selling Price : "+sell+"\n");
            }
        });

    }
}