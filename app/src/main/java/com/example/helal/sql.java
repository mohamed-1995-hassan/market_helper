package com.example.helal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.BitmapFactory;

import java.util.ArrayList;
import java.util.List;


public class sql extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="mydata";
    public static final String TABLE_NAME="mytable";
    public static final String ID="id";
    public static final String PRODUCT_NAME="name";
    public static final String PRODUCT_IMAGE="image";
    public static final String PRODUCT_CARTON_COUNT ="count";
    public static final String PRODUCT_PIECES_SALARY ="salary";
    public static final String PRODUCT_PIECES_COUNT ="picecount";
    public static final String REMANING_CARTON_COUNT="rcc";
    public static final String REMANING_PIECES_COUNT="rpc";


    public sql(Context context) {
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table "+TABLE_NAME+" ("+ID+" integer primary key,"+PRODUCT_NAME+" text," +
                PRODUCT_IMAGE+" BLOB,"+ PRODUCT_CARTON_COUNT +" text,"+ PRODUCT_PIECES_SALARY
                +" text,"+PRODUCT_PIECES_COUNT+ " text,"+REMANING_CARTON_COUNT +" text,"+REMANING_PIECES_COUNT+" integer)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);

    }
    public boolean insert(String name,String count,String salary,byte[] image,String piccount)
    {
        SQLiteDatabase sq=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(PRODUCT_NAME,name);
        cv.put(PRODUCT_CARTON_COUNT,count);
        cv.put(PRODUCT_PIECES_SALARY,salary);
        cv.put(PRODUCT_IMAGE,image);
        cv.put(PRODUCT_PIECES_COUNT,piccount);


        long insert = sq.insert(TABLE_NAME, null, cv);
        return insert>0;

    }
    public List<productsql> allpro()
    {
        List<productsql> pro=new ArrayList();
        SQLiteDatabase rd = this.getReadableDatabase();
        Cursor cr=rd.rawQuery("select * from "+TABLE_NAME,null);
        cr.moveToFirst();
        while (cr.isAfterLast()==false)
        {


            if ( Integer.parseInt(cr.getString(cr.getColumnIndex(PRODUCT_CARTON_COUNT)))*Integer.parseInt(cr.getString(cr.getColumnIndex(PRODUCT_PIECES_COUNT)))!=cr.getInt(cr.getColumnIndex(REMANING_PIECES_COUNT)))
            {
                pro.add(new productsql(cr.getInt(cr.getColumnIndex(ID)), cr.getString(cr.getColumnIndex(PRODUCT_NAME)),
                        cr.getString(cr.getColumnIndex(PRODUCT_CARTON_COUNT)),
                        cr.getString(cr.getColumnIndex(PRODUCT_PIECES_SALARY))
                        , BitmapFactory.decodeByteArray(cr.getBlob(cr.getColumnIndex
                        (PRODUCT_IMAGE)), 0, cr.getBlob(cr.getColumnIndex(PRODUCT_IMAGE)).length), cr.getString(cr.getColumnIndex(PRODUCT_PIECES_COUNT)), cr.getString(cr.getColumnIndex(REMANING_CARTON_COUNT)), cr.getInt(cr.getColumnIndex(REMANING_PIECES_COUNT))));
            }
            cr.moveToNext();
        }


        return pro;
    }

    public List<productsql> allprr()
    {
        List<productsql> pro=new ArrayList();
        SQLiteDatabase rd = this.getReadableDatabase();
        Cursor cr=rd.rawQuery("select * from "+TABLE_NAME,null);
        cr.moveToFirst();
        while (cr.isAfterLast()==false)
        {


            if ( Integer.parseInt(cr.getString(cr.getColumnIndex(PRODUCT_CARTON_COUNT)))*Integer.parseInt(cr.getString(cr.getColumnIndex(PRODUCT_PIECES_COUNT)))==cr.getInt(cr.getColumnIndex(REMANING_PIECES_COUNT)))
            {
                pro.add(new productsql(cr.getInt(cr.getColumnIndex(ID)), cr.getString(cr.getColumnIndex(PRODUCT_NAME)),
                        cr.getString(cr.getColumnIndex(PRODUCT_CARTON_COUNT)),
                        cr.getString(cr.getColumnIndex(PRODUCT_PIECES_SALARY))
                        , BitmapFactory.decodeByteArray(cr.getBlob(cr.getColumnIndex
                        (PRODUCT_IMAGE)), 0, cr.getBlob(cr.getColumnIndex(PRODUCT_IMAGE)).length), cr.getString(cr.getColumnIndex(PRODUCT_PIECES_COUNT)), cr.getString(cr.getColumnIndex(REMANING_CARTON_COUNT)), cr.getInt(cr.getColumnIndex(REMANING_PIECES_COUNT))));
            }
            cr.moveToNext();
        }


        return pro;
    }

    public boolean updtedb(List<productsql> prosql)
    {
       SQLiteDatabase mdb= getWritableDatabase();
        ContentValues cv=new ContentValues();
        for(int i=0;i<prosql.size();i++)
        {
          cv.put(REMANING_PIECES_COUNT,prosql.get(i).remain_pieces_count);
          mdb.update(TABLE_NAME,cv,ID+" = ?",new String[]{Integer.toString(prosql.get(i).getId())});
        }
        return true;

    }


    public boolean dro(productsql p){

        SQLiteDatabase sqdb=getWritableDatabase();
        return  sqdb.delete(TABLE_NAME, ID + " = ?", new String[]{Integer.toString(p.getId())})>0;

    }
    public boolean updathh(productsql pl,int t)
    {
        SQLiteDatabase hdb= getWritableDatabase();
        ContentValues ch=new ContentValues();
        ch.put(PRODUCT_CARTON_COUNT,String.valueOf(Integer.parseInt(pl.getCount())+t));
        hdb.update(TABLE_NAME,ch,ID+" = ?",new String[]{Integer.toString(pl.getId())});
        return true;
    }

}