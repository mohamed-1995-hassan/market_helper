package com.example.helal;

import android.content.Context;
import android.content.DialogInterface;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mohamed on 11/12/2018.
 */
public class tac_recycler extends RecyclerView.Adapter<tac_recycler.tac> implements Filterable {
Context con;
List<productsql> pnn;
List<productsql> pnnn;
    private ArrayList<productsql> filterpod;

    public tac_recycler(Context con, List<productsql> pnn) {
        this.con = con;
        this.pnn = pnn;
        pnnn=new ArrayList<>(pnn);
    }




    @Override
    public tac onCreateViewHolder(ViewGroup parent, int viewType) {
       View vv= LayoutInflater.from(con).inflate(R.layout.tqrer_adapt,parent,false);
        tac tt=new tac(vv);
        return tt;
    }

    @Override
    public void onBindViewHolder(tac holder, final int position) {
        holder.t1.setText(pnn.get(position).getName());
        holder.t2.setText(pnn.get(position).getCount());
        holder.t3.setText(pnn.get(position).getPieccount());
        holder.t4.setText(String.valueOf(ppig(position)));
        holder.t5.setText(String.valueOf(pig(position)));
        holder.im1.setImageBitmap(pnn.get(position).getBt());
        holder.im2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder ab=new AlertDialog.Builder(con);
                ab.setMessage("هل تريد بالفعل مسح العنصر ؟")
                        .setPositiveButton("مسح", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Taqrer tt= (Taqrer) con;
                                tt.delete(pnn.get(position),position);
                            }
                        }).show();

            }
        });


    }

    @Override
    public int getItemCount() {
        return pnn.size();
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
                    filterpod.addAll(pnnn);
                }
                else{
                    for(int i=0;i<pnnn.size();i++)
                    {
                        if(pnnn.get(i).getName().toLowerCase().contains(klm))
                        {
                            filterpod.add(pnnn.get(i));
                        }
                    }
                }
                FilterResults frr=new FilterResults();
                frr.values=filterpod;



                return frr;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                pnn.clear();
                pnn.addAll((List)results.values);
                notifyDataSetChanged();

            }
        };
    }

    class tac extends RecyclerView.ViewHolder{

        TextView t1,t2,t3,t4,t5;
        ImageView im1,im2;
        public tac(View itemView) {
            super(itemView);
            t1= (TextView) itemView.findViewById(R.id.to1);
            t2= (TextView) itemView.findViewById(R.id.to2);
            t3= (TextView) itemView.findViewById(R.id.to3);
            t4= (TextView) itemView.findViewById(R.id.to4);
            t5= (TextView) itemView.findViewById(R.id.to5);
            im1= (ImageView) itemView.findViewById(R.id.defo);
            im2= (ImageView) itemView.findViewById(R.id.doll);
        }
    }

    public int pig(int nn)
    {
        int all=Integer.parseInt(pnn.get(nn).getCount())*Integer.parseInt(pnn.get(nn).getPieccount());
        int saf=all-pnn.get(nn).remain_pieces_count;
        return saf;
    }
    public int ppig(int n)
    {
        int flage=0;
       int pp= pig(n);
        for(int i=0;i<pp;i++)
        {
            if((i+1)%Integer.parseInt(pnn.get(n).getPieccount())==0)
            {

                flage++;
            }
        }
        return flage;
    }
}
