package com.example.helal;

import android.app.Dialog;
import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Created by Mohamed on 11/12/2018.
 */
public class ash_add extends RecyclerView.Adapter<ash_add.ash> {
    Context con;
    List<productsql>ll;
    public ash_add(Context con, List<productsql> ll) {
        this.con = con;
        this.ll = ll;
    }

    @Override
    public ash onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(con).inflate(R.layout.ash_out,parent,false);
        ash as=new ash(v);

        return as;
    }

    @Override
    public void onBindViewHolder(ash holder, final int position) {
        holder.imm.setImageBitmap(ll.get(position).getBt());
        holder.bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dm=new Dialog(con);
                dm.setContentView(R.layout.dialog_fin);
               TextView tn= (TextView) dm.findViewById(R.id.tvm);
               TextView tn2= (TextView) dm.findViewById(R.id.tvm2);
               TextView tn3= (TextView) dm.findViewById(R.id.tvm3);
                ImageView immm= (ImageView) dm.findViewById(R.id.fiaa);
                immm.setImageBitmap(ll.get(position).getBt());
                tn.setText(ll.get(position).getName());
                tn2.setText(ll.get(position).getCount());
                tn3.setText(ll.get(position).getPieccount());
                dm.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return ll.size();
    }

    class ash extends RecyclerView.ViewHolder{
        ImageView imm;
        Button bn;
        public ash(View itemView) {
            super(itemView);
            imm= (ImageView) itemView.findViewById(R.id.wa);
            bn= (Button) itemView.findViewById(R.id.btmn);
        }
    }
}
