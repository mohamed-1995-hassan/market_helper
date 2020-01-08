package com.example.helal;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.abas_home);

getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.texo);

    }

    public void def(View view) {
        Intent i=new Intent(this,select.class);
        startActivity(i);
    }

    public void pee(View view) {
        Intent ii=new Intent(this,pee3.class);
        startActivity(ii);
    }

    public void taq(View view) {
        Intent iii=new Intent(this,Taqrer.class);
        startActivity(iii);
    }

    public void ash(View view) {
        Intent iiii=new Intent(this,arshf.class);
        startActivity(iiii);
    }
}
