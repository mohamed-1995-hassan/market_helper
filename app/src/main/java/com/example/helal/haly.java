package com.example.helal;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;


import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class haly extends AppCompatActivity {
RecyclerView rs;
sql sq;
haly_adapt had;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_haly);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.texo);
        rs=findViewById(R.id.halid);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        SearchView sc=findViewById(R.id.shs);
        sc.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                had.getFilter().filter(query);

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                had.getFilter().filter(newText);
                return false;
            }

        });
        sq=new sql(this);
        List<productsql> allpro = sq.allpro();
        LinearLayoutManager lnm=new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        rs.setLayoutManager(lnm);
        if(allpro.size()==0)
        {
            View v=findViewById(android.R.id.content);

            Snackbar.make(v,"لا توجد اي منتجات",Snackbar.LENGTH_LONG).setAction("CLOSE", new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            }).setActionTextColor(Color.argb(12,74,56,58)).show();
        }
        else {
            had = new haly_adapt(allpro, this);
            rs.setAdapter(had);
        }



    }
    public boolean halupdate(productsql pq,int r)
    {

        return sq.updathh(pq,r);

    }
}
