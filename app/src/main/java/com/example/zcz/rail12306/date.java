package com.example.zcz.rail12306;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

public class date extends AppCompatActivity {
    DatePicker datePicker;
    Intent intent;
    //private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);
        editor =getSharedPreferences("data",MODE_PRIVATE).edit();
        //pref  =getSharedPreferences("data",MODE_PRIVATE);
        datePicker = (DatePicker)findViewById(R.id.date);
        Intent intent1=getIntent();
       final int flag=intent1.getIntExtra("page",0);
        datePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag==1) {
                    intent = new Intent(date.this, chepiaoyuding.class);
                }
                if(flag==2){
                    intent = new Intent(date.this, tickets.class);
                }
                int a = datePicker.getYear();
                String  a1=String.valueOf(a);
                int b=datePicker.getMonth();
                String b1=String.valueOf(b);
                int c=datePicker.getDayOfMonth();
                String c1=String.valueOf(c);
                String t=a1+"-"+b1+"-"+c1;
                editor.putString("cfrq",t);
                editor.apply();
                startActivity(intent);
            }
        });
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.hide();
        }
    }
}
