package com.example.taxcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    EditText asset;
    TextView tvDisplay;
    Button but;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        asset = findViewById(R.id.asset);
        tvDisplay = findViewById(R.id.tvDisplay);
        but = findViewById(R.id.Button);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String asset1 = asset.getText().toString();
                Double tax = Double.parseDouble(asset1);

                if(tax<=300000){
                    Double taxpay = 0.0;
                }
                else if(tax<=400000){
                    Double taxpay = (400000 - tax)*0.05;
                }
                else if(tax<=700000){
                    Double ran = tax-300000.0;
                    if(ran<=100000){
                        Double taxpay = ran*0.05;
                    }
                    else{
                        Double taxpay = 100000*0.05;
                        ran = ran - 100000;
                        taxpay +=  ran*0.1;
                    }
                }
                else if(tax<=1100000){
                    Double ran = tax-300000.0;
                    if(ran<=100000){
                        Double taxpay = ran*0.05;
                    }
                    else if(ran<=300000){
                        Double taxpay = 100000*0.05;
                        ran = ran - 100000;
                        taxpay +=  ran*0.1;
                    }
                    else{
                        Double taxpay = 100000*0.05;
                        taxpay +=  300000*0.1;
                        ran -= 400000.0;
                        taxpay += ran*0.15;
                    }
                }
                else if(tax<=1600000){
                    Double ran = tax-300000.0;
                    if(ran<=100000){
                        Double taxpay = ran*0.05;
                    }
                    else if(ran<=300000){
                        Double taxpay = 100000*0.05;
                        ran = ran - 100000;
                        taxpay +=  ran*0.1;
                    }
                    else if(ran<=400000){
                        Double taxpay = 100000*0.05;
                        taxpay +=  300000*0.1;
                        ran -= 400000.0;
                        taxpay += ran*0.15;
                    }
                    else{
                        Double taxpay = 100000*0.05;
                        taxpay +=  300000*0.1;
                        taxpay += 400000*0.15;
                        ran -= 400000;
                    }
                }
            }
        });


    }
}