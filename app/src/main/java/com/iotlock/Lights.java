package com.iotlock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import okhttp3.*;

import java.io.IOException;

public class Lights extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lights);
        Switch sw = (Switch)findViewById(R.id.light1switch);
        Switch sw2 = (Switch)findViewById(R.id.light2switch);
        Switch sw3 = (Switch)findViewById(R.id.light3switch);
        sw.setText("OFF");
        sw2.setText("OFF");
        sw3.setText("OFF");

        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {

                if(isChecked){
                    sw.setText("ON");
                    OkHttpClient client = new OkHttpClient();


                    Request request = new Request.Builder()
                            .url("http://10.251.90.136?message=^")
                            .build();



                    try {
                        client.newCall(request).enqueue(new Callback() {
                            @Override
                            public void onFailure(Call call, IOException e) {

                            }

                            @Override
                            public void onResponse(Call call, Response response) throws IOException {
                                if(response.isSuccessful()){

                                }
                            }
                        });

                        // Do something with the response.
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }

                else{
                    sw.setText("OFF");
                    OkHttpClient client = new OkHttpClient();


                    Request request = new Request.Builder()
                            .url("http://10.251.90.136?message=#")
                            .build();



                    try {
                        client.newCall(request).enqueue(new Callback() {
                            @Override
                            public void onFailure(Call call, IOException e) {

                            }

                            @Override
                            public void onResponse(Call call, Response response) throws IOException {
                                if(response.isSuccessful()){

                                }
                            }
                        });

                        // Do something with the response.
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        });


        sw2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {

                if(isChecked){
                    sw2.setText("ON");
                    OkHttpClient client = new OkHttpClient();


                    Request request = new Request.Builder()
                            .url("http://10.251.90.136?message=F")
                            .build();



                    try {
                        client.newCall(request).enqueue(new Callback() {
                            @Override
                            public void onFailure(Call call, IOException e) {

                            }

                            @Override
                            public void onResponse(Call call, Response response) throws IOException {
                                if(response.isSuccessful()){

                                }
                            }
                        });

                        // Do something with the response.
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }

                else{
                    sw2.setText("OFF");
                    OkHttpClient client = new OkHttpClient();


                    Request request = new Request.Builder()
                            .url("http://10.251.90.136?message=G")
                            .build();



                    try {
                        client.newCall(request).enqueue(new Callback() {
                            @Override
                            public void onFailure(Call call, IOException e) {

                            }

                            @Override
                            public void onResponse(Call call, Response response) throws IOException {
                                if(response.isSuccessful()){

                                }
                            }
                        });

                        // Do something with the response.
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        });


        sw3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {

                if(isChecked){
                    sw3.setText("ON");
                    OkHttpClient client = new OkHttpClient();


                    Request request = new Request.Builder()
                            .url("http://10.251.90.136?message=O")
                            .build();



                    try {
                        client.newCall(request).enqueue(new Callback() {
                            @Override
                            public void onFailure(Call call, IOException e) {

                            }

                            @Override
                            public void onResponse(Call call, Response response) throws IOException {
                                if(response.isSuccessful()){

                                }
                            }
                        });

                        // Do something with the response.
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }

                else{
                    sw3.setText("OFF");
                    OkHttpClient client = new OkHttpClient();


                    Request request = new Request.Builder()
                            .url("http://10.251.90.136?message=J")
                            .build();



                    try {
                        client.newCall(request).enqueue(new Callback() {
                            @Override
                            public void onFailure(Call call, IOException e) {

                            }

                            @Override
                            public void onResponse(Call call, Response response) throws IOException {
                                if(response.isSuccessful()){

                                }
                            }
                        });

                        // Do something with the response.
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        });
    }
}
