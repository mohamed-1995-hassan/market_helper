package com.example.helal;

import android.graphics.Color;
import android.os.Bundle;

import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class arshf extends AppCompatActivity {
    List<productsql> lsq;
    sql sq;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arshf);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.texo);

        recyclerView= (RecyclerView) findViewById(R.id.recash);
        GridLayoutManager lnm=new GridLayoutManager(this,2, LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(lnm);
        sq=new sql(this);
        lsq=sq.allprr();
        if (lsq.size()==0)
        {
            View v=findViewById(android.R.id.content);

            Snackbar.make(v,"لا توجد بيانات محفوظه", Snackbar.LENGTH_LONG).setAction("CLOSE", new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            }).setActionTextColor(Color.argb(12,74,56,58)).show();
        }
        else {
            ash_add as = new ash_add(this, lsq);
            recyclerView.setAdapter(as);
        }





    }
}
