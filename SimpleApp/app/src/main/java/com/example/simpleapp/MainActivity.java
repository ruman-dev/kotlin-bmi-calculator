package com.example.simpleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText  edName, edAge, edGen, edEmail;
    Button butt;
    TextView tvDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edName = findViewById(R.id.edName);
        edAge = findViewById(R.id.edAge);
        edGen = findViewById(R.id.edGen);
        edEmail = findViewById(R.id.edEmail);
        butt = findViewById(R.id.butt);
        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = edName.getText().toString();
                tvDisplay.setText("Hello "+user+"\n");
                //+"!!\nYour data is recorded.\nYour Age is "+edAge.getText().toString()+",Your Gender is "
                  //      +edGen.getText().toString()+"Your Email is "+edEmail.getText().toString()+"\nThanks for your cooperation.");
            }
        });

    }
}