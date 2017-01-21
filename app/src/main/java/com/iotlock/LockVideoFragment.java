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
import android.widget.CompoundButton;
import android.widget.MediaController;
import android.widget.ToggleButton;
import android.widget.VideoView;
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
        ToggleButton bar = (ToggleButton)v.findViewById(R.id.tb1);
        WebView view = (WebView)v.findViewById(R.id.webview);
        view.getSettings().setJavaScriptEnabled(true);

        view.loadUrl("http://10.251.66.175:8080/videofeed");

        bar.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton toggleButton, boolean isChecked) {
                if (isChecked) {
                    //LOCK

                    OkHttpClient client = new OkHttpClient();

                    RequestBody formBody = new FormBody.Builder()
                            .add("message", "@")
                            .build();
                    Request request = new Request.Builder()
                            .url("http://www.foo.bar/index.php")
                            .post(formBody)
                            .build();

                    try {
                        Response response = client.newCall(request).execute();

                        // Do something with the response.
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                } else {
                    //LOCK

                    OkHttpClient client = new OkHttpClient();

                    RequestBody formBody = new FormBody.Builder()
                            .add("message", "!")
                            .build();
                    Request request = new Request.Builder()
                            .url("http://www.foo.bar/index.php")
                            .post(formBody)
                            .build();

                    try {
                        Response response = client.newCall(request).execute();

                        // Do something with the response.
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });



    }
}
