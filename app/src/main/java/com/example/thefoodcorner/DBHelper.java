package com.example.thefoodcorner;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.thefoodcorner.Modals.OrderModal;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    final static String DBName = "mydatabase.db";
    final static int version = 1;
    public DBHelper(@Nullable Context context) {
        super(context, DBName, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table orders" +
                        "(id integer primary key autoincrement ," +
                        "name text," +
                        "phone text ," +
                        "price int ," +
                        "image int,"+
                        "quantity int,"+
                        "description text ," +
                        "foodname text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP table if exists orders");
            onCreate(db);
    }

    public boolean insertOrder(String name , String phone , int price ,int image, int quantity , String desc ,String foodname){
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        /*
        id =0
        name = 1
        phone =2
        price = 3
        image= 4
        quantity = 5
        description = 6
        foodname = 7
         */
        values.put("name"  , name);
        values.put("phone" , phone);
        values.put("price" , price);
        values.put("image", image);
        values.put("quantity" , quantity);
        values.put("description" , desc);
        values.put("foodname" , foodname);
        long id = database.insert("orders" , null , values);
        if(id<=0){
            return false;
        }
        else return true;

    }

    public ArrayList<OrderModal> getOrder(){
        ArrayList<OrderModal> order = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("Select id,foodname,image,price from orders " , null);
        if(cursor.moveToFirst()){
            while (cursor.moveToNext()){
                OrderModal orderModal = new OrderModal();
                orderModal.setOrderNumber(cursor.getInt(0)+"");
                orderModal.setSoldItemName(cursor.getString(1)+"");
                orderModal.setOrderImg(cursor.getInt(2));
                orderModal.setPrice(cursor.getInt(3)+"");
                order.add(orderModal);
            }
        }
        cursor.close();
        database.close();
        return  order;
    }

    public Cursor getOrderById(int id){

        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("Select * from orders where id = "+id , null);

        if(cursor!=null)
            cursor.moveToFirst();


        return  cursor;
    }

    public boolean updateOrder(String name , String phone , int price ,int image, int quantity , String desc ,String foodname , int id){
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        /*
        id =0
        name = 1
        phone =2
        price = 3
        image= 4
        quantity = 5
        description = 6
        foodname = 7
         */
        values.put("name"  , name);
        values.put("phone" , phone);
        values.put("price" , price);
        values.put("image", image);
        values.put("quantity" , quantity);
        values.put("description" , desc);
        values.put("foodname" , foodname);
        long row = database.update("orders", values ,"id="+id,null);
        if(row<=0){
            return false;
        }
        else return true;

    }

    public  int deleteOrder(String id){
        SQLiteDatabase database = this.getWritableDatabase();
        return database.delete("orders", "id="+id,null);
    }
}
