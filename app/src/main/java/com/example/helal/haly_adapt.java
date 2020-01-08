package com.example.helal;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
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

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class haly_adapt extends RecyclerView.Adapter<haly_adapt.dd> implements Filterable {

    List<productsql>lpq;
    List<productsql>podfull;
    Context con;
    private ArrayList<productsql> filterpod;

    public haly_adapt(List<productsql>lpq,Context con)
    {
        this.lpq=lpq;
        this.con=con;
        podfull=new ArrayList<>(lpq);
    }


    @NonNull
    @Override
    public dd onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(con).inflate(R.layout.haly_xml,parent,false);
        dd vv=new dd(v);
        return vv;
    }

    @Override
    public void onBindViewHolder(@NonNull dd holder, final int position) {
        holder.im.setImageBitmap(lpq.get(position).getBt());
        holder.tv.setText(lpq.get(position).getName());
        holder.iq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog d=new Dialog(con);
                d.setContentView(R.layout.hal_dialog);
                final EditText eh=d.findViewById(R.id.he);


                Button a7=d.findViewById(R.id.a7);
                a7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        d.dismiss();
                    }
                });

                Button ak=d.findViewById(R.id.ak);
                ak.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try{
                            int s=Integer.parseInt(eh.getText().toString());
                            haly ha= (haly) con;
                          if ( ha.halupdate(lpq.get(position),s)) {
                              d.dismiss();
                              Toast.makeText(con, "تم الحفظ بنجاح", Toast.LENGTH_LONG).show();

                          }
                          else {
                              Toast.makeText(con,"حدث خطأ",Toast.LENGTH_LONG).show();

                          }



                        }catch (Exception e){
                        Toast.makeText(con,"ادخل القيمه صحيحه",Toast.LENGTH_LONG).show();

                        }
                    }
                });
d.show();

            }
        });


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
                lpq.clear();
                lpq.addAll((List)results.values);
                notifyDataSetChanged();

            }
        };
    }

    @Override
    public int getItemCount() {
        return lpq.size();
    }

    public class dd extends RecyclerView.ViewHolder{
    TextView tv;
    ImageView im,iq;
       public dd(@NonNull View itemView) {
           super(itemView);
           im= itemView.findViewById(R.id.kh);
           iq= itemView.findViewById(R.id.zz);
           tv=itemView.findViewById(R.id.bh);
       }
   }
}
