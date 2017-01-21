package com.iotlock;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class LockList extends AppCompatActivity {
    private List<String> options;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    Adapter_Lists lists;
    private RecyclerView view;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<LockListThing>  li;
    int counter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        options = new ArrayList<String>();
        setContentView(R.layout.activity_main2);
        options.add("Configure New Lock");
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        mDrawerList = (ListView)findViewById(R.id.left_drawer);
        mDrawerList.setAdapter(new ArrayAdapter<String>(this,R.layout.drawer_list_item,options));
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        li = new ArrayList<>();

        view = (RecyclerView) findViewById(R.id.recycler_view2);
        mLayoutManager = new LinearLayoutManager(this);
        view.setLayoutManager(mLayoutManager);
         lists = new Adapter_Lists(li);

       view.setAdapter(lists);


    }
    /** Swaps fragments in the main content view */
    private void selectItem(int position) {
        Log.d("POS",Integer.toString(position));
            switch (position){
                case 0:
                    counter ++;
                    Log.d("CLICK", Integer.toString(counter));

                    lists.addItem(new LockListThing("Lock"+counter));
            }
        // Create a new fragment and specify the planet to show based on position


        // Insert the fragment by replacing any existing fragment


        // Highlight the selected item, update the title, and close the drawer
        mDrawerList.setItemChecked(position, false);

        mDrawerLayout.closeDrawer(mDrawerList);
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Log.d("CLICKED","clock");
            selectItem(position);
        }
    }


}

