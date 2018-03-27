package com.example.hardika.imagegallery;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by hardika on 4/5/17.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyViewHolder> {
    ArrayList<Album> arrayList=new ArrayList<>();
    Activity activity;
    public  RecycleAdapter(ArrayList<Album> arrayList, Context context)
    {
        this.arrayList=arrayList;
        activity=(Activity)context;
    }


    public RecycleAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecycleAdapter.MyViewHolder holder, int position)
    {
        holder.title.setText(arrayList.get(position).getTitle());
        String path=config.img_path+arrayList.get(position).getId()+".jpg";
        Glide.with(activity).load(path).into(holder.ImageView1);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        ImageView ImageView1;
        TextView title;
        public MyViewHolder(View itemView)
        {
            super(itemView);
            ImageView1=(ImageView)itemView.findViewById(R.id.imageView);
            title=(TextView)itemView.findViewById(R.id.text);

        }
    }
}
