package com.example.helal;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Created by Mohamed on 10/12/2018.
 */
public class adaptag  extends RecyclerView.Adapter<adaptag.vin> {
    Context context;
    List<productsql> pod;

    public adaptag(Context context,List<productsql> pod)
    {
        this.context=context;
        this.pod=pod;
    }


    @Override
    public vin onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.imna,parent,false);
        vin vv=new vin(v);
        return vv;
    }

    @Override
    public void onBindViewHolder(vin holder, int position) {
        holder.imageView.setImageBitmap(pod.get(position).getBt());
    }



    @Override
    public int getItemCount() {
        return pod.size();
    }

    public static class vin extends RecyclerView.ViewHolder{
        ImageView imageView;

        public vin(View view) {
            super(view);
            imageView= (ImageView) view.findViewById(R.id.emo);


        }
    }
}
