package com.example.helal;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class select extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.texo);

    }

    public void csel(View view) {
        Intent ii=new Intent(this,edafaa.class);
        startActivity(ii);

    }

    public void hal(View view) {
        Intent ii=new Intent(this,haly.class);
        startActivity(ii);
    }

}
