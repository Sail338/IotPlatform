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
public class Adapter extends RecyclerView.Adapter<Adapter.IotViewHolder> {
    List<IotThing> thingList;
    public  Adapter (List<IotThing> things){
        this.thingList = things;
    }
    @Override
    public IotViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        IotViewHolder holder = new IotViewHolder(v);
        return  holder;
    }
    @Override
    public void onBindViewHolder(IotViewHolder holder, final int position) {
        holder.stockName.setText(thingList.get(position).name);
      holder.stockPhoto.setImageResource(thingList.get(position).photoid);
      holder.cv.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              switch (position){
                  //OPEN LOCK FRAGMENT
                  case 0:
                        view.getContext().startActivity(new Intent(view.getContext(),LockList.class));
                        break;
                  case 2:
                      view.getContext().startActivity(new Intent(view.getContext(),Thermostat.class));
                      break;

              }

          }
      });
    }
    @Override
    public int getItemCount() {
        return thingList.size();
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
    public static class IotViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView stockName;
        ImageView stockPhoto;
        //

        IotViewHolder(View itemView) {

            super(itemView);


            cv = (CardView)itemView.findViewById(R.id.cv);
            stockName = (TextView)itemView.findViewById(R.id.item_name);

            stockPhoto = (ImageView)itemView.findViewById(R.id.person_photo);
        }
    }

}
