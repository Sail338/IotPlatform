package com.iotlock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView view;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<IotThing> persons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view = (RecyclerView) findViewById(R.id.recycler_view);
        mLayoutManager = new LinearLayoutManager(this);
        view.setLayoutManager(mLayoutManager);
        init();
        initAdapter();
    }
    private void init(){
        persons = new ArrayList<>();
        persons.add(new IotThing("Lock",R.drawable.images));

    }
    private void initAdapter(){
        Adapter adapter = new Adapter(persons);
        view.setAdapter(adapter);
    }

}
