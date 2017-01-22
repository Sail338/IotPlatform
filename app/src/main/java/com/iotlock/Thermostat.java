package com.iotlock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import okhttp3.*;

import java.io.IOException;

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
        home = (EditText) findViewById(R.id.homeedit);
        away = (EditText) findViewById(R.id.editText4);
        home.setText(String.valueOf(totalofplus));
        away.setText(String.valueOf(totalofaway));
        makeRequest(totalofplus,totalofaway);
        //send request to webserver

    }
    public void plushome(View v){
        int scale = (int) Math.pow(10, 1);


        if(home != null){
            totalofplus = Double.parseDouble(home.getText().toString());
            totalofplus += 0.2;
            makeRequest(totalofplus,totalofaway);
            home.setText(String.format("%2f",totalofplus));
        }
    }
    public void minushome(View v){
        int scale = (int) Math.pow(10, 1);


        if(home != null){
            totalofplus = Double.parseDouble(home.getText().toString());
            totalofplus -= 0.2;
            makeRequest(totalofplus,totalofaway);
            home.setText(String.format("%2f",totalofplus));
        }
    }
    public void plusaway(View v){
        int scale = (int) Math.pow(10, 1);


        if(home != null){
            totalofaway = Double.parseDouble(away.getText().toString());
            totalofaway += 0.2;
            makeRequest(totalofplus,totalofaway);
            away.setText(String.format("%2f",totalofaway));
        }
    }
    public void minusaway(View v){
        int scale = (int) Math.pow(10, 1);


        if(home != null){
            totalofaway = Double.parseDouble(away.getText().toString());
            totalofaway -= 0.2;
            makeRequest(totalofplus,totalofaway);
            away.setText(String.format("%2f",totalofaway));
        }
    }

    public  void makeRequest(double vale,double vale2){
        OkHttpClient client = new OkHttpClient();

        double val_to_use = vale2;
        if(Constants.isLocked){
            val_to_use = vale2;
        } else if (Constants.isLocked == false){
            val_to_use = vale;
        }

        RequestBody formBody = new FormBody.Builder()
                .add("data", String.valueOf(val_to_use))
                .build();
        Request request = new Request.Builder()
                .url("http://68c65208.ngrok.io/hi")
                .post(formBody)
                .build();

        try {
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });

            // Do something with the response.
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
