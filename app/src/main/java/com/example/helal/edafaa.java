package com.example.helal;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class edafaa extends AppCompatActivity {
EditText ed,ed2,ed3,ed4;
    Bitmap bb;
    ImageView im;
    sql sq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edafaa);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.texo);
        sq=new sql(this);
        ed= (EditText) findViewById(R.id.moni);
        ed2= (EditText) findViewById(R.id.moni2);
        ed3= (EditText) findViewById(R.id.moni3);
        im= (ImageView) findViewById(R.id.idrn);
        ed4= (EditText) findViewById(R.id.moni4);

    }

    public void chooseImage(View view) {

        Intent i=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(i,100);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==100&&resultCode==RESULT_OK)
        {
            try{

                bb=MediaStore.Images.Media.getBitmap(getContentResolver(),data.getData());
                im.setImageURI( data.getData());

            }catch (Exception e)
            {
                Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();

            }
        }

    }
    public byte[] convert_method()
    {
        ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
        bb.compress(Bitmap.CompressFormat.PNG,0,outputStream);
        return outputStream.toByteArray();
    }

    public void saveindb(View view) {
        try{

           String eds=ed.getText().toString();
           int edi= Integer.parseInt(ed2.getText().toString());
           double edi2= Integer.parseInt(ed3.getText().toString());
           int ed44= Integer.parseInt(ed4.getText().toString());


           if(sq.insert(eds,ed2.getText().toString(),ed3.getText().toString(),convert_method(),ed4.getText().toString()));
           {
               ed.setText("");
               ed2.setText("");
               ed3.setText("");
               ed4.setText("");
               im.setImageResource(R.drawable.pln);

               Toast.makeText(this,"تم الحفظ بنجاح",Toast.LENGTH_LONG).show();

           }


        }catch (Exception e)
        {
            Toast.makeText(this,"ادخل البيانات كامله وصحيحه",Toast.LENGTH_LONG).show();
        }
       List<productsql> allpro = sq.allpro();

    }
}
