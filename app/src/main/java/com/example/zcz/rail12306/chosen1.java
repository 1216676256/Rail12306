package com.example.zcz.rail12306;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zcz.rail12306.R;
import com.example.zcz.rail12306.chepiaoyuding;

public class chosen1 extends AppCompatActivity {
    EditText edit1;
    Button ok;
    TextView text1,text2,text3,text4,text5,text6,text7,text8;
    TextView text_back;
    private SharedPreferences.Editor editor;
    private  SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chosen1);
        editor =getSharedPreferences("data",MODE_PRIVATE).edit();
        pref  =getSharedPreferences("data",MODE_PRIVATE);
        edit1=(EditText)findViewById(R.id.edit1);
        text1=(TextView) findViewById(R.id.text1) ;
        text2=(TextView) findViewById(R.id.text2) ;
        text3=(TextView) findViewById(R.id.text3) ;
        text4=(TextView) findViewById(R.id.text4) ;
        text5=(TextView) findViewById(R.id.text5) ;
        text6=(TextView) findViewById(R.id.text6) ;
        text7=(TextView) findViewById(R.id.text7) ;
        text8=(TextView) findViewById(R.id.text8) ;
        text_back=(TextView)findViewById(R.id.text_back);
        ok=(Button)findViewById(R.id.btn_ok);
        final Intent intent=getIntent();
        final int a=intent.getIntExtra("flag",-1);
        final Intent intent1=new Intent(chosen1.this,chepiaoyuding.class);


        String s1=pref.getString("vector1",null);
        String s2=pref.getString("vector2",null);
        String s3=pref.getString("vector3",null);
        String s4=pref.getString("vector4",null);
        String s5=pref.getString("vector5",null);
        String s6=pref.getString("vector6",null);
        String s7=pref.getString("vector7",null);
        String s8=pref.getString("vector8",null);
        text1.setText(s1);
        text2.setText(s2);
        text3.setText(s3);
        text4.setText(s4);
        text5.setText(s5);
        text6.setText(s6);
        text7.setText(s7);
        text8.setText(s8);

        text_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent1);
            }
        });
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent1.putExtra("flag1",a);

                String str=edit1.getText().toString();
                // Toast.makeText(chosen1.this,str,Toast.LENGTH_SHORT).show();
                if(str.equals(""))
                    Toast.makeText(chosen1.this,"目的地不能为空",Toast.LENGTH_SHORT).show();
                else{
                    if(a==1){
                        if(str.equals(pref.getString("didian2_2","")))
                            Toast.makeText(chosen1.this,"不能与目的地一致！",Toast.LENGTH_SHORT).show();
                        else{
                            editor.putString("didian1_1",str);
                            editor.apply();
                            startActivity(intent1);
                        }
                    }
                    if(a==2){
                        if(str.equals(pref.getString("didian1_1",""))){
                            Toast.makeText(chosen1.this,"不能与出发一致！",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            editor.putString("didian2_2",str);
                            editor.apply();
                            startActivity(intent1);
                        }
                    }
                }

            }
        });
        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent1=new Intent(chosen1.this,MainActivity.class);
                intent1.putExtra("flag1",a);
                String str=text1.getText().toString();
                if(a==1){
                    if(str.equals(pref.getString("didian2_2",""))){
                        Toast.makeText(chosen1.this,"不能与目的地一致！",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        editor.putString("didian1_1",str);
                        editor.apply();
                        startActivity(intent1);
                    }
                }
                if(a==2){
                    if(str.equals(pref.getString("didian1_1",""))){
                        Toast.makeText(chosen1.this,"不能与出发地一致！",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        editor.putString("didian2_2",str);
                        editor.apply();
                        startActivity(intent1);
                    }
                }
            }
        });
        text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent1=new Intent(chosen1.this,MainActivity.class);
                intent1.putExtra("flag1",a);
                String str=text2.getText().toString();
                if(a==1){
                    if(str.equals(pref.getString("didian2_2",""))){
                        Toast.makeText(chosen1.this,"不能与目的地一致！",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        editor.putString("didian1_1",str);
                        editor.apply();
                        startActivity(intent1);
                    }
                }
                if(a==2){
                    if(str.equals(pref.getString("didian1_1",""))){
                        Toast.makeText(chosen1.this,"不能与出发地一致！",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        editor.putString("didian2_2",str);
                        editor.apply();
                        startActivity(intent1);
                    }
                }
            }
        });
        text3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent1=new Intent(chosen1.this,MainActivity.class);
                intent1.putExtra("flag1",a);
                String str=text3.getText().toString();
                if(a==1){
                    if(str.equals(pref.getString("didian2_2",""))){
                        Toast.makeText(chosen1.this,"不能与目的地一致！",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        editor.putString("didian1_1",str);
                        editor.apply();
                        startActivity(intent1);
                    }
                }
                if(a==2){
                    if(str.equals(pref.getString("didian1_1",""))){
                        Toast.makeText(chosen1.this,"不能与出发地一致！",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        editor.putString("didian2_2",str);
                        editor.apply();
                        startActivity(intent1);
                    }
                }
            }
        });
        text4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent1=new Intent(chosen1.this,MainActivity.class);
                intent1.putExtra("flag1",a);
                String str=text4.getText().toString();
                if(a==1){
                    if(str.equals(pref.getString("didian2_2",""))){
                        Toast.makeText(chosen1.this,"不能与目的地一致！",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        editor.putString("didian1_1",str);
                        editor.apply();
                        startActivity(intent1);
                    }
                }
                if(a==2){
                    if(str.equals(pref.getString("didian1_1",""))){
                        Toast.makeText(chosen1.this,"不能与出发地一致！",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        editor.putString("didian2_2",str);
                        editor.apply();
                        startActivity(intent1);
                    }
                }
            }
        });
        text5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent1=new Intent(chosen1.this,MainActivity.class);
                intent1.putExtra("flag1",a);
                String str=text5.getText().toString();
                if(a==1){
                    if(str.equals(pref.getString("didian2_2",""))){
                        Toast.makeText(chosen1.this,"不能与目的地一致！",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        editor.putString("didian1_1",str);
                        editor.apply();
                        startActivity(intent1);
                    }
                }
                if(a==2){
                    if(str.equals(pref.getString("didian1_1",""))){
                        Toast.makeText(chosen1.this,"不能与出发地一致！",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        editor.putString("didian2_2",str);
                        editor.apply();
                        startActivity(intent1);
                    }
                }
            }
        });
        text6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent1=new Intent(chosen1.this,MainActivity.class);
                intent1.putExtra("flag1",a);
                String str=text6.getText().toString();
                if(a==1){
                    if(str.equals(pref.getString("didian2_2",""))){
                        Toast.makeText(chosen1.this,"不能与目的地一致！",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        editor.putString("didian1_1",str);
                        editor.apply();
                        startActivity(intent1);
                    }
                }
                if(a==2){
                    if(str.equals(pref.getString("didian1_1",""))){
                        Toast.makeText(chosen1.this,"不能与出发地一致！",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        editor.putString("didian2_2",str);
                        editor.apply();
                        startActivity(intent1);
                    }
                }
            }
        });
        text7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent1=new Intent(chosen1.this,MainActivity.class);
                intent1.putExtra("flag1",a);
                String str=text7.getText().toString();
                if(a==1){
                    if(str.equals(pref.getString("didian2_2",""))){
                        Toast.makeText(chosen1.this,"不能与目的地一致！",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        editor.putString("didian1_1",str);
                        editor.apply();
                        startActivity(intent1);
                    }
                }
                if(a==2){
                    if(str.equals(pref.getString("didian1_1",""))){
                        Toast.makeText(chosen1.this,"不能与出发地一致！",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        editor.putString("didian2_2",str);
                        editor.apply();
                        startActivity(intent1);
                    }
                }
            }
        });
        text8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent1=new Intent(chosen1.this,MainActivity.class);
                intent1.putExtra("flag1",a);
                String str=text8.getText().toString();
                if(a==1){
                    if(str.equals(pref.getString("didian2_2",""))){
                        Toast.makeText(chosen1.this,"不能与目的地一致！",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        editor.putString("didian1_1",str);
                        editor.apply();
                        startActivity(intent1);
                    }
                }
                if(a==2){
                    if(str.equals(pref.getString("didian1_1",""))){
                        Toast.makeText(chosen1.this,"不能与出发地一致！",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        editor.putString("didian2_2",str);
                        editor.apply();
                        startActivity(intent1);
                    }
                }
            }
        });
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.hide();
        }
    }
}
