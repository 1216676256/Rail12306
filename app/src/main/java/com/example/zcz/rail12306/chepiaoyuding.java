package com.example.zcz.rail12306;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class chepiaoyuding extends AppCompatActivity {
    Button query;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    Button ddchaxun;
    boolean vis[]={false,false,false,false,false,false};
    int sum;
    ImageView huhuan;
    TextView  didian1,didian2;
    TextView cfsj,xb,cfrq;
    int yourChoice;
    //String year,month,day;
    String cfrq_1;
    String a1,a2,a3,a4,a5;
    String c1_1,c1_2;
    String c2_1,c2_2;
    String c3_1,c3_2;
    String c4_1,c4_2;
    String c5_1,c5_2;
    TextView new1,new2,new3,new4,new5;
   // DatePicker datePicker;
    //int a;
    TextView chosen0,chosen1,chosen2,chosen3,chosen4,chosen5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chepiaoyuding);

        editor =getSharedPreferences("data",MODE_PRIVATE).edit();
        pref  =getSharedPreferences("data",MODE_PRIVATE);
        query=(Button)findViewById(R.id.btn_Query);
         huhuan=(ImageView)findViewById(R.id.transfer);
         didian1=(TextView)findViewById(R.id.didian1);
         didian2=(TextView)findViewById(R.id.didian2);
        ddchaxun=(Button)findViewById(R.id.btn_ddchaxun);
        cfsj = (TextView)findViewById(R.id.textcfsj);
        xb= (TextView)findViewById(R.id.textxb);
        cfrq=(TextView)findViewById(R.id.textcfrq);
        chosen0=(TextView)findViewById(R.id.chosen0);
        chosen1=(TextView)findViewById(R.id.chosen1);
        chosen2=(TextView)findViewById(R.id.chosen2);
        chosen3=(TextView)findViewById(R.id.chosen3);
        chosen4=(TextView)findViewById(R.id.chosen4);
        chosen5=(TextView)findViewById(R.id.chosen5);


        new1=(TextView)findViewById(R.id.newdidian1);
        new2=(TextView)findViewById(R.id.newdidian2);
        new3=(TextView)findViewById(R.id.newdidian3);
        new4=(TextView)findViewById(R.id.newdidian4);
        new5=(TextView)findViewById(R.id.newdidian5);


        c1_1=pref.getString("name1_1","");
        c1_2=pref.getString("name1_2","");
        c2_1=pref.getString("name2_1","");
        c2_2=pref.getString("name2_2","");
        c3_1=pref.getString("name3_1","");
        c3_2=pref.getString("name3_2","");
        c4_1=pref.getString("name4_1","");
        c4_2=pref.getString("name4_2","");
        c5_1=pref.getString("name5_1","");
        c5_2=pref.getString("name5_2","");
        //String temp;
        a1=a2=a3=a4=a5="";
        if(!(c1_1==null||c1_1.equals(""))){
            a1=c1_1+"----->"+pref.getString("name1_2",null);
        }
        if(!(c2_1==null||c2_1.equals(""))){
            a2=c2_1+"----->"+pref.getString("name2_2",null);
        }
        if(!(c3_1==null||c3_1.equals(""))){
            a3=c3_1+"----->"+pref.getString("name3_2",null);
        }
        if(!(c4_1==null||c4_1.equals(""))){
            a4=c4_1+"----->"+pref.getString("name4_2",null);
        }
        if(!(c5_1==null||c5_1.equals(""))){
            a5=c5_1+"----->"+pref.getString("name5_2",null);
        }
        //Toast.makeText(chepiaoyuding.this,a1,Toast.LENGTH_SHORT).show();
        new1.setText(a1);
        new2.setText(a2);
        new3.setText(a3);
        new4.setText(a4);
        new5.setText(a5);
       // Toast.makeText(chepiaoyuding.this,a5,Toast.LENGTH_SHORT).show();


        Intent intent = getIntent();

        int a=intent.getIntExtra("flag1",-1);

        final String str=pref.getString("didian1_1","杭州");
       Toast.makeText(chepiaoyuding.this,str,Toast.LENGTH_SHORT).show();
        didian1.setText(str);
        final String str1=pref.getString("didian2_2","上海");
        Toast.makeText(chepiaoyuding.this,str1,Toast.LENGTH_SHORT).show();
        didian2.setText(str1);
        new1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                didian1.setText(c1_1);
                didian2.setText(c1_2);
            }
        });
        new2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                didian1.setText(c2_1);
                didian2.setText(c2_2);
            }
        });
        new3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                didian1.setText(c3_1);
                didian2.setText(c3_2);
            }
        });
        new4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                didian1.setText(c4_1);
                didian2.setText(c4_2);
            }
        });
        new5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                didian1.setText(c5_1);
                didian2.setText(c5_2);
            }
        });

        ddchaxun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(chepiaoyuding.this,DDsearch.class);
                startActivity(intent);
            }
        });
        query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=pref.getString("vector1","苍南");
                String s2=pref.getString("vector2","杭州东");
                String s3=pref.getString("vector3","温州");
                String s4=pref.getString("vector4","金华");
                String s5=pref.getString("vector5","鳌江");
                String s6=pref.getString("vector6","余杭");
                String s7=pref.getString("vector7","北京");
                String s8=pref.getString("vector8","上海");

               /* s8=s6;
                s7=s5;
                s6=s4;
                s5=s3;
                s4=s2;
                s3=s1;
                s2=str1;
                s1=str;*/
                String b=str;
                int flag=1;
                String tt="";
                if(flag==1){
                    if(s1.equals(str))
                        flag=0;
                    tt=s1;
                    s1=b;
                    b=tt;

                }
                if(flag==1){
                    if(s2.equals(str))
                        flag=0;
                    tt=s2;
                    s2=b;
                    b=tt;

                }
                if(flag==1){
                    if(s3.equals(str))
                        flag=0;
                    tt=s3;
                    s3=b;
                    b=tt;


                }
                if(flag==1){
                    if(s4.equals(str))
                        flag=0;
                    tt=s4;
                    s4=b;
                    b=tt;

                }
                if(flag==1){
                    if(s5.equals(str))
                        flag=0;
                    tt=s5;
                    s5=b;
                    b=tt;
                }
                if(flag==1){
                    if(s6.equals(str))
                        flag=0;
                    tt=s6;
                    s6=b;
                    b=tt;
                }
                if(flag==1){
                    if(s7.equals(str))
                        flag=0;
                    tt=s7;
                    s7=b;
                    b=tt;
                }
                if(flag==1){
                    if(s8.equals(str))
                        flag=0;
                    tt=s8;
                    s8=b;
                    b=tt;
                }





                b=str1;
                flag=1;
                tt="";
                if(flag==1){
                    if(s1.equals(str1))
                        flag=0;
                    tt=s1;
                    s1=b;
                    b=tt;

                }
                if(flag==1){
                    if(s2.equals(str1))
                        flag=0;
                    tt=s2;
                    s2=b;
                    b=tt;

                }
                if(flag==1){
                    if(s3.equals(str1))
                        flag=0;
                    tt=s3;
                    s3=b;
                    b=tt;


                }
                if(flag==1){
                    if(s4.equals(str1))
                        flag=0;
                    tt=s4;
                    s4=b;
                    b=tt;

                }
                if(flag==1){
                    if(s5.equals(str1))
                        flag=0;
                    tt=s5;
                    s5=b;
                    b=tt;
                }
                if(flag==1){
                    if(s6.equals(str1))
                        flag=0;
                    tt=s6;
                    s6=b;
                    b=tt;
                }
                if(flag==1){
                    if(s7.equals(str1))
                        flag=0;
                    tt=s7;
                    s7=b;
                    b=tt;
                }
                if(flag==1){
                    if(s8.equals(str1))
                        flag=0;
                    tt=s8;
                    s8=b;
                    b=tt;
                }
                editor.putString("vector1",s1);
                editor.putString("vector2",s2);
                editor.putString("vector3",s3);
                editor.putString("vector4",s4);
                editor.putString("vector5",s5);
                editor.putString("vector6",s6);
                editor.putString("vector7",s7);
                editor.putString("vector8",s8);
                editor.apply();



                String zz=didian1.getText().toString()+"----->"+didian2.getText().toString();
                //a1=pref.getString("name1","无");
                //a2=pref.getString("name2","无");
               // a3=pref.getString("name3","无");
                //a4=pref.getString("name4","无");
                //a5=pref.getString("name5","无");


                String b_1=didian1.getText().toString();
                String b_2=didian2.getText().toString();
                String t1,t2;
                 b=zz;
                flag=1;
                if(flag==1){
                    if(a1.equals(zz))
                        flag=0;
                    tt=a1;
                    a1=b;
                    b=tt;


                    t1=c1_1;
                    t2=c1_2;
                    c1_1=b_1;
                    c1_2=b_2;
                    b_1=t1;
                    b_2=t2;
                }
                if(flag==1){
                    if(a2.equals(zz))
                        flag=0;
                    tt=a2;
                    a2=b;
                    b=tt;

                    t1=c2_1;
                    t2=c2_2;
                    c2_1=b_1;
                    c2_2=b_2;
                    b_1=t1;
                    b_2=t2;
                }
                if(flag==1){
                    if(a3.equals(zz))
                        flag=0;
                    tt=a3;
                    a3=b;
                    b=tt;

                    t1=c3_1;
                    t2=c3_2;
                    c3_1=b_1;
                    c3_2=b_2;
                    b_1=t1;
                    b_2=t2;

                }
                if(flag==1){
                    if(a4.equals(zz))
                        flag=0;
                    tt=a4;
                    a4=b;
                    b=tt;

                    t1=c4_1;
                    t2=c4_2;
                    c4_1=b_1;
                    c4_2=b_2;
                    b_1=t1;
                    b_2=t2;
                }
                if(flag==1){
                    if(a5.equals(zz))
                        flag=0;
                    tt=a5;
                    a5=b;
                    b=tt;

                    t1=c5_1;
                    t2=c5_2;
                    c5_1=b_1;
                    c5_2=b_2;
                    b_1=t1;
                    b_2=t2;
                }
                editor.putString("didian1_1",b_1);
                editor.putString("didian2_2",b_2);


                editor.putString("name1_1",c1_1);
                editor.putString("name1_2",c1_2);
                editor.putString("name2_1",c2_1);
                editor.putString("name2_2",c2_2);
                editor.putString("name3_1",c3_1);
                editor.putString("name3_2",c3_2);
                editor.putString("name4_1",c4_1);
                editor.putString("name4_2",c4_2);
                editor.putString("name5_1",c5_1);
                editor.putString("name5_2",c5_2);


                editor.putInt("flag_yiju",1);

                editor.apply();
                new1.setText(a1);
                new2.setText(a2);
                new3.setText(a3);
                new4.setText(a4);
                new5.setText(a5);

                Intent intent=new Intent(chepiaoyuding.this,tickets.class);

                startActivity(intent);
            }
        });
        didian1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(chepiaoyuding.this,chosen1.class);
                intent1.putExtra("flag",1);
                startActivity(intent1);
            }
        });
        didian2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(chepiaoyuding.this,chosen1.class);
                intent2.putExtra("flag",2);
                startActivity(intent2);
            }
        });
       /* year = intent.getIntExtra("year",2017);
        month = intent.getIntExtra("month",01);
        day = intent.getIntExtra("day",01);
        */

      /* //  datePicker.getYear();
        year = pref.getString("year","2017");
       // a=datePicker.getMonth();
        month = pref.getString("month","1");
        //a=datePicker.getDayOfMonth();
        day = pref.getString("day","1");
*/
        cfrq_1=pref.getString("cfrq","2017-01-01");
        cfrq.setText(cfrq_1);
        sum=0;
        //换地点
         huhuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a=didian1.getText().toString();
                didian1.setText(didian2.getText().toString());
                didian2.setText(a);
            }
        });


        //出发日期
        cfrq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chepiaoyuding.this,date.class);
                startActivity(intent);
            }
        });
        //时间点
        cfsj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSingleChoiceDialogcfsj();
            }
        });


        //席别
        xb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSingleChoiceDialogxb();
            }
        });


        chosen0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vis[0]=true;
                chosen0.setBackgroundColor(Color.parseColor("#ce0099FF"));
                for(int i=1;i<=5;i++){
                    vis[i]=false;
                }
                sum=0;
                chosen1.setBackgroundColor(Color.parseColor("#FFFFFF"));
                chosen2.setBackgroundColor(Color.parseColor("#FFFFFF"));
                chosen3.setBackgroundColor(Color.parseColor("#FFFFFF"));
                chosen4.setBackgroundColor(Color.parseColor("#FFFFFF"));
                chosen5.setBackgroundColor(Color.parseColor("#FFFFFF"));
            }
        });


        chosen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vis[1]=!vis[1];
                if(!vis[1]) {
                    sum--;
                    chosen1.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    if(sum==0)
                        chosen0.setBackgroundColor(Color.parseColor("#ce0099FF"));

                }
                else{
                    sum++;
                    chosen1.setBackgroundColor(Color.parseColor("#ce0099FF"));
                    chosen0.setBackgroundColor(Color.parseColor("#FFFFFF"));
                }
            }
        });
        chosen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vis[2]=!vis[2];
                if(!vis[2]) {
                    sum--;
                    chosen2.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    if(sum==0)
                        chosen0.setBackgroundColor(Color.parseColor("#ce0099FF"));

                }
                else{
                    sum++;
                    chosen2.setBackgroundColor(Color.parseColor("#ce0099FF"));
                    chosen0.setBackgroundColor(Color.parseColor("#FFFFFF"));
                }
            }
        });
        chosen3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vis[3]=!vis[3];
                if(!vis[3]) {
                    sum--;
                    chosen3.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    if(sum==0)
                        chosen0.setBackgroundColor(Color.parseColor("#ce0099FF"));

                }
                else{
                    sum++;
                    chosen3.setBackgroundColor(Color.parseColor("#ce0099FF"));
                    chosen0.setBackgroundColor(Color.parseColor("#FFFFFF"));
                }
            }
        });
        chosen4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vis[4]=!vis[4];
                if(!vis[4]) {
                    sum--;
                    chosen4.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    if(sum==0)
                        chosen0.setBackgroundColor(Color.parseColor("#ce0099FF"));

                }
                else{
                    sum++;
                    chosen4.setBackgroundColor(Color.parseColor("#ce0099FF"));
                    chosen0.setBackgroundColor(Color.parseColor("#FFFFFF"));
                }
            }
        });
        chosen5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vis[5]=!vis[5];
                if(!vis[5]) {
                    sum--;
                    chosen5.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    if(sum==0)
                        chosen0.setBackgroundColor(Color.parseColor("#ce0099FF"));

                }
                else{
                    sum++;
                    chosen5.setBackgroundColor(Color.parseColor("#ce0099FF"));
                    chosen0.setBackgroundColor(Color.parseColor("#FFFFFF"));
                }
            }
        });
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.hide();
        }
    }


     //时间点
     private void showSingleChoiceDialogcfsj(){
         final String[] items = { "00:00--24:00","00:00--06:00","06:00--12:00","12:00--18:00" ,"18:00--24:00"};
         yourChoice = 0;
         AlertDialog.Builder singleChoiceDialog =
                 new AlertDialog.Builder(chepiaoyuding.this);

         // 第二个参数是默认选项，此处设置为0
         singleChoiceDialog.setSingleChoiceItems(items, 0,
                 new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {
                         yourChoice = which;
                     }
                 });
         singleChoiceDialog.setPositiveButton("确定",
                 new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {
                         cfsj.setText(items[yourChoice]);
                         cfsj.setTextColor(Color.parseColor("#ce0099FF"));
                         if(yourChoice==0)
                             cfsj.setTextColor(Color.parseColor("#000000"));
                     }
                 });
         singleChoiceDialog.show();
     }



    //席别
    private void showSingleChoiceDialogxb(){
        final String[] items = { "不限","商务座","一等座","二等座" ,"高级软卧","软卧","硬卧","软座","硬座"};
        yourChoice = 0;
        AlertDialog.Builder singleChoiceDialog =
                new AlertDialog.Builder(chepiaoyuding.this);

        // 第二个参数是默认选项，此处设置为0
        singleChoiceDialog.setSingleChoiceItems(items, 0,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        yourChoice = which;
                    }
                });
        singleChoiceDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                            xb.setText(items[yourChoice]);
                            xb.setTextColor(Color.parseColor("#ce0099FF"));
                        if(xb.getText().toString().equals("不限"))
                            xb.setTextColor(Color.parseColor("#000000"));
                    }
                });
        singleChoiceDialog.show();
    }
}
