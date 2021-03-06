package com.iotlock;

import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.*;
import okhttp3.*;


import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

/**
 * Created by hari on 1/21/17.
 */
public class LockVideoFragment extends Fragment {
    View v;
    @Override

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view =    inflater.inflate(R.layout.lockvideo,container,false);
        v = view;
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        Switch bar = (Switch)v.findViewById(R.id.tb1);
        WebView view = (WebView)v.findViewById(R.id.webview);
        view.getSettings().setJavaScriptEnabled(true);

        view.loadUrl("http://10.251.66.175:8080/videofeed");
        bar.setText("LOCKED");
        bar.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton toggleButton, boolean isChecked) {
                if (isChecked) {
                    //UNLOCKED
                    bar.setText("UNLOCKED");
                    OkHttpClient client = new OkHttpClient();

                    Constants.isLocked = false;
                    Request request = new Request.Builder()
                            .url("http://10.251.90.136?message=!")
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


                } else {
                    //LOCKED
                    bar.setText("LOCKED");
                    OkHttpClient client = new OkHttpClient();
                    Constants.isLocked = true;
                    RequestBody formBody = new FormBody.Builder()
                            .add("message", "@")
                            .build();
                    Request request = new Request.Builder()
                            .url("http://10.251.90.136/?message=@")
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
