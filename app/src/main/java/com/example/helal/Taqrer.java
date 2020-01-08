package com.example.helal;

import android.graphics.Color;
import android.os.Bundle;

import android.view.View;
import android.view.WindowManager;

import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class Taqrer extends AppCompatActivity {

    List<productsql> lsq;
    sql sq;
    RecyclerView recyclerView;
    tac_recycler tr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taqrer);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.texo);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        SearchView sx=findViewById(R.id.sx);
        sx.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                tr.getFilter().filter(query);

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                tr.getFilter().filter(newText);

                return false;
            }
        });

        recyclerView= (RecyclerView) findViewById(R.id.ron);
        LinearLayoutManager lnm=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(lnm);
        sq=new sql(this);
        lsq=sq.allpro();
        if (lsq.size()==0)
        {
            //Toast.makeText(this,"لا توجد ايه تقاربر",Toast.LENGTH_LONG).show();
            View v=findViewById(android.R.id.content);

            Snackbar.make(v,"لا توجد اي تقارير",Snackbar.LENGTH_LONG).setAction("CLOSE", new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            }).setActionTextColor(Color.argb(12,74,56,58)).show();
        }
        else {
            tr = new tac_recycler(this, lsq);
            recyclerView.setAdapter(tr);
        }

    }
    public void delete(productsql ps,int ii)
    {
          if (sq.dro(ps))
          {
              lsq.remove(ii);
              tr.notifyDataSetChanged();
              Toast.makeText(this,"تم الحذف بنجاح",Toast.LENGTH_LONG).show();

          }
    }
}
