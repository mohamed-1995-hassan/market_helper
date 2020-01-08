package com.example.helal;


import android.app.Dialog;
import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class edafaa_adapter extends RecyclerView.Adapter<edafaa_adapter.vh> implements Filterable {


    List<productsql>filterpod;

    Context context;
    List<productsql>pod;
    List<productsql>podfull;


    public edafaa_adapter(Context context,List<productsql> pod)
    {
        this.context=context;
        this.pod=pod;
        podfull=new ArrayList<>(pod);
    }

    @Override
    public vh onCreateViewHolder(ViewGroup parent, int viewType) {
       View v= LayoutInflater.from(context).inflate(R.layout.imago,parent,false);
        vh vv=new vh(v);
        return vv;
    }

    @Override
    public void onBindViewHolder(vh holder, final int position) {
          holder.imageView.setImageBitmap(pod.get(position).getBt());
          holder.btn.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  selection(position);
              }
          });

    }

    private void selection(final int po) {

            final Dialog d = new Dialog(context);
            d.setContentView(R.layout.dialogead);
            ImageView imm = (ImageView) d.findViewById(R.id.idrn22);
            TextView ivv = (TextView) d.findViewById(R.id.txq1);
            TextView ivv2 = (TextView) d.findViewById(R.id.txq2);
            TextView ivv3 = (TextView) d.findViewById(R.id.txq3);
            final EditText edd= (EditText) d.findViewById(R.id.m22);

            imm.setImageBitmap(pod.get(po).getBt());
            ivv.setText(pod.get(po).getName());
            ivv2.setText(pod.get(po).getSalary());
            ivv3.setText((Integer.parseInt(pod.get(po).getCount())*Integer.parseInt(pod.get(po).getPieccount()))-pod.get(po).remain_pieces_count+" ");
            Button bv = (Button) d.findViewById(R.id.dis);
            bv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                d.dismiss();
            }
        });
            Button bb = (Button) d.findViewById(R.id.ss);
            bb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                    int inedd = Integer.parseInt(edd.getText().toString());
                    if (inedd<=(Integer.parseInt(pod.get(po).getCount())*Integer.parseInt(pod.get(po).getPieccount()))-pod.get(po).remain_pieces_count&&inedd>0) {
                        pee3 p3 = (pee3) context;
                        p3.callagain(pod.get(po), inedd);
                        d.dismiss();
                    }
                        else {
                        Toast.makeText(context,"لا توجد كميه كافيه",Toast.LENGTH_LONG).show();
                    }
                    }catch (Exception e)
                    {
                        Toast.makeText(context,"ادخل الرقم صحيح",Toast.LENGTH_LONG).show();
                    }
                }
            });
            d.show();
    }

    @Override
    public int getItemCount() {
        return pod.size();
    }

    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String klm=constraint.toString().toLowerCase().trim();
                filterpod=new ArrayList<>();
                if(klm.isEmpty())
                {
                    filterpod.addAll(podfull);
                }
                else{
                    for(int i=0;i<podfull.size();i++)
                    {
                        if(podfull.get(i).getName().toLowerCase().contains(klm))
                        {
                            filterpod.add(podfull.get(i));
                        }
                    }
                }
                FilterResults frr=new FilterResults();
                frr.values=filterpod;



              return frr;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
               pod.clear();
               pod.addAll((List)results.values);
                notifyDataSetChanged();

            }
        };
    }

    public static class vh extends RecyclerView.ViewHolder{
       ImageView imageView;
        Button btn;
        public vh(View view) {
            super(view);
           imageView= (ImageView) view.findViewById(R.id.ibnn);
           btn= (Button) view.findViewById(R.id.sd);

        }
    }

}
