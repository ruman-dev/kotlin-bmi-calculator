package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Calculate extends AppCompatActivity {

    EditText edweight,edfeet,edinch;
    Button but;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);

        edweight = findViewById(R.id.edweight);
        edfeet = findViewById(R.id.edfeet);
        edinch = findViewById(R.id.edinch);
        but = findViewById(R.id.button);
        result = findViewById(R.id.result);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String weight1 = edweight.getText().toString();
                String feet1 = edfeet.getText().toString();
                String inch1 = edinch.getText().toString();

                Float weight = Float.parseFloat(weight1);
                Float feet = Float.parseFloat(feet1);
                Float inch = Float.parseFloat(inch1);

                Double height = feet*0.3048 + inch*0.0254;

                Double bmi = weight/ (height*height);
                if(weight<1 || feet<1 || inch<1){
                        Toast.makeText(Calculate.this,"Enter a valid number",Toast.LENGTH_LONG).show();
                }

                else {
                    if (feet > 6) {
                        Toast.makeText(Calculate.this, "Please input a number of 0-6 in Feet", Toast.LENGTH_LONG).show();
                    } else if (inch > 12) {
                        Toast.makeText(Calculate.this, "Please input a number of 0-12 in Inch", Toast.LENGTH_LONG).show();
                    } else {
                        if (bmi < 18) {
                            result.setText("Your BMI Index is : " + bmi + "\n\n\nYour are UnderWeight.\n\nNote: Please be " +
                                    "careful about your health.\n\nThank You.");
                        } else if (bmi < 24.9) {
                            result.setText("Your BMI Index is : " + bmi + "\n\n\nYour are in Normal " +
                                    "Weight.\n\nNote: Please take " +
                                    "healthy food and take care of your health.\n\nSome tips for improving you BMI Index - \nA balanced, calorie-controlled diet is the ticket to a healthy BMI – the safe way.\n\n 1. Don’t bother with crash diets\n2. Look out for hidden sugar\n3. Get your heart pumping\n4. Simply move more\n5. Get the right support.\n\nEat a well-balanced, calorie-dense diet and exercise often to bring your BMI \ninto the range of normal.Please take care of your health.\n\nThank You.");
                        } else if (bmi < 29.9) {
                            result.setText("Your BMI Index is : " + bmi + "\n\n\nYour are in OverWeight.\n\nNote: Please take " +
                                    "healthy food and go exercise daily.\n\nSome tips for improving you BMI Index - \nA balanced, calorie-controlled diet is the ticket to a healthy BMI – the safe way.\n\n 1. Don’t bother with crash diets\n2. Look out for hidden sugar\n3. Get your heart pumping\n4. Simply move more\n5. Get the right support.\n\nEat a well-balanced, calorie-dense diet and exercise often to bring your BMI into the range of normal.Please take care of your health.\n\nThank You.");
                        } else if (bmi < 34.9) {
                            result.setText("Your BMI Index is : " + bmi + "\n\n\nYour are Obese.\n\nNote: Please be" +
                                    " more careful about your health.Take healthy food and go exercise daily.\n\nSome tips for improving you BMI Index - \nA balanced, calorie-controlled diet is the ticket to a healthy BMI – the safe way.\n\n 1. Don’t bother with crash diets\n2. Look out for hidden sugar\n3. Get your heart pumping\n4. Simply move more\n5. Get the right support.\n\nEat a well-balanced, calorie-dense diet and exercise often to bring your BMI into the range of normal.Please " +
                                    "take care of your health.\n\nEat a well-balanced, calorie-dense diet and exercise " +
                                    "often to bring your BMI into the range of normal.\n\nThank You.");
                        } else {
                            result.setText("Your BMI Index is : " + bmi + "\n\n\nYour are Extremely Obese.\n\nYou are in Risk.\n\nNote: Please be" +
                                    " more careful about your health.Take healthy food and go \nexercise daily.\n\nSome tips for improving you BMI Index - \nA balanced, calorie-controlled diet is the \nticket to a healthy BMI – the safe way.\n\n 1. Don’t bother with crash diets\n2. Look out for hidden sugar\n3. Get your heart pumping\n4. Simply move more\n5. Get the right support.\n\nEat a well-balanced, calorie-dense diet and exercise often to bring your BMI into the \nrange of normal.Please " +
                                    "take care of your health.\n\nEat a well-balanced, calorie-dense diet " +
                                    "and exercise often to bring your BMI into the range of normal.\n\nThank You.");
                        }
                    }
                }
            }
        });

    }
}