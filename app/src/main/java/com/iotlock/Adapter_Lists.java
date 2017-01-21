package com.iotlock;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by hari on 1/20/17.
 */
public class Adapter_Lists extends RecyclerView.Adapter<Adapter_Lists.IotViewHolder2> {
    List<LockListThing> thingList;
    public  Adapter_Lists (List<LockListThing> things){
        this.thingList = things;
    }
    @Override
    public IotViewHolder2 onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview2, parent, false);
        IotViewHolder2 holder = new IotViewHolder2(v);
        return  holder;
    }
    @Override
    public void onBindViewHolder(IotViewHolder2 holder, final int position) {
        holder.stockName.setText(thingList.get(position).name);


    }
    @Override
    public int getItemCount() {
        return thingList.size();
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
    public static class IotViewHolder2 extends RecyclerView.ViewHolder {
        CardView cv;
        TextView stockName;

        //

        IotViewHolder2(View itemView) {

            super(itemView);


            cv = (CardView)itemView.findViewById(R.id.cv2);
            stockName = (TextView)itemView.findViewById(R.id.item_name2);


        }
    }
    public void addItem(LockListThing plate)
    {
        thingList.add(plate);
        //notifyDataSetChanged();
        notifyItemInserted(thingList.size()-1);
    }
}
