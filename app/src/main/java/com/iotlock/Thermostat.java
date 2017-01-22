package com.iotlock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Thermostat extends AppCompatActivity {
   EditText home;
   EditText away;
   Button plushome;
   Button awayhome;
   double totalofplus = 70;
   double totalofaway = 68.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set default value for home

        setContentView(R.layout.activity_thermostat);
        home = (EditText)findViewById(R.id.homeedit);
        away = (EditText)findViewById(R.id.editText4);
        home.setText(String.valueOf(totalofplus));
        away.setText(String.valueOf(totalofaway));
    }

    public void plushome(View v){
        int scale = (int) Math.pow(10, 1);


        if(home != null){
            totalofplus = Double.parseDouble(home.getText().toString());
            totalofplus += 0.2;
            home.setText(String.format("%2f",totalofplus));
        }
    }
    public void minushome(View v){
        int scale = (int) Math.pow(10, 1);


        if(home != null){
            totalofplus = Double.parseDouble(home.getText().toString());
            totalofplus -= 0.2;
            home.setText(String.format("%2f",totalofplus));
        }
    }
    public void plusaway(View v){
        int scale = (int) Math.pow(10, 1);


        if(home != null){
            totalofaway = Double.parseDouble(away.getText().toString());
            totalofaway += 0.2;
            away.setText(String.format("%2f",totalofaway));
        }
    }
    public void minusaway(View v){
        int scale = (int) Math.pow(10, 1);


        if(home != null){
            totalofaway = Double.parseDouble(away.getText().toString());
            totalofaway -= 0.2;
            away.setText(String.format("%2f",totalofaway));
        }
    }
}
