package com.example.helal;

import android.os.Bundle;
import android.view.View;

import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class pee3 extends AppCompatActivity {
 edafaa_adapter ln;
RecyclerView recnew;
sql sq;
List<productsql> allpro,allpn;
boolean flage=true;
TextView txto;
int  tot;
    adaptag ad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pee3);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        SearchView sc = findViewById(R.id.op);
        sc.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                ln.getFilter().filter(query);

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ln.getFilter().filter(newText);
                return false;
            }

        });


        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.texo);
        txto= (TextView) findViewById(R.id.txttot);
        RecyclerView ex= (RecyclerView) findViewById(R.id.rec);
        recnew= (RecyclerView) findViewById(R.id.r2);
        sq=new sql(this);
        allpro = sq.allpro();





        allpn=new ArrayList();
        LinearLayoutManager lnm = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        ex.setLayoutManager(lnm);
        ln=new edafaa_adapter(this,allpro);
        ex.setAdapter(ln);
    }

     public void callagain(productsql p,int ind)
     {
         flage=true;

         for (int ir=0;ir<allpn.size();ir++)
         {
             if (p.getId()==allpn.get(ir).getId()) {
                 flage = false;
                 allpn.get(ir).remain_pieces_count += ind;
             }
         }
         if (flage) {
             p.remain_pieces_count+=ind;
             allpn.add(p);
             LinearLayoutManager lnm = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
             recnew.setLayoutManager(lnm);
             ad = new adaptag(this, allpn);
             recnew.setAdapter(ad);
         }
         tot+=ind* Integer.parseInt(p.getSalary());
         if (allpn.size()!=0)
         {
             txto.setText(tot+" ");
         }
     }
    public void calctot(View view) {

   if (allpn.size()!=0)
   {
       if(sq.updtedb(allpn))
       {
           for(int t=0;t<allpn.size();t++)

           txto.setText("0.0");
           allpn=new ArrayList();
           ad=new adaptag(this,allpn);
           recnew.setAdapter(ad);
       }
   }
        else {
       Toast.makeText(this,"اختر المشتريات اولا",Toast.LENGTH_LONG).show();
   }
    }
}
