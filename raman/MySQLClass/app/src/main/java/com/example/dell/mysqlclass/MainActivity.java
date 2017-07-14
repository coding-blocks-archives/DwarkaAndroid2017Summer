package com.example.dell.mysqlclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
TextView textView;
    ArrayList<DataHelper> priceArrayList=new DataHelper();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DataHelper dataHelper=new DataHelper(this);
        textView=(TextView)findViewById(R.id.text);
        dataHelper.insertData("pencil","HB","2","5");
        dataHelper.insertData("eraser","non-dust","1","3");
        dataHelper.insertData("pen","NATRAJ","0","10");
        dataHelper.insertData("sharpner","HB","5","4");
        dataHelper.insertData("scale","HB","1","2");
        for(int i=0;i<=4;i++)
        {
            dataHelper.updateData(priceArrayList.get[i]);
        }
        //TIME WAS LESS SO I WASNT ABLE TO CREATE ARRAY LIST MEANT TO IMPLY UPDATE AND DELETE BUT METHODS OF THEM ARE IN DATAHELPER CLASS


    }
}
