package com.iotlock;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ToggleButton;
import okhttp3.*;

import java.io.IOException;
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
    public void onActivityCreated(Bundle savedInstanceState) {
        ToggleButton bar = (ToggleButton)v.findViewById(R.id.tb1);

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



        super.onActivityCreated(savedInstanceState);
        //Load Toggles


    }
}
