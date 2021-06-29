package com.example.intro;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class MostViewedAdapter extends RecyclerView.Adapter<MostViewedAdapter.mostviewHolder> {

    ArrayList<MostViewedHelperClass> mostViewedLocations;

    public MostViewedAdapter(ArrayList<MostViewedHelperClass> mostViewedLocations) {
        this.mostViewedLocations = mostViewedLocations;
    }

    @NonNull
    @Override
    public mostviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.most_viewed_card_design,parent,false);
        MostViewedAdapter.mostviewHolder mostviewHolder=new MostViewedAdapter.mostviewHolder(view);
        return mostviewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull mostviewHolder holder, int position) {
        MostViewedHelperClass mostViewedHelperClass=mostViewedLocations.get(position);
        holder.image.setImageResource(mostViewedHelperClass.getImage());
        holder.title.setText(mostViewedHelperClass.getTitle());
        holder.desc.setText(mostViewedHelperClass.getDescription());
    }

    @Override
    public int getItemCount() {
        return mostViewedLocations.size();
    }

    public static class mostviewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView title,desc;

        public mostviewHolder(@NonNull View itemView) {
            super(itemView);

            //Hooks
            image=itemView.findViewById(R.id.mv_image);
            title=itemView.findViewById(R.id.mv_title);
            desc=itemView.findViewById(R.id.mv_desc);
        }
    }
}
