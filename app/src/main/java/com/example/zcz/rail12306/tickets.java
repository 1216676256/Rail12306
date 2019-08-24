package com.example.zcz.rail12306;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class tickets extends AppCompatActivity {
    ListView listView;
    checiAdapter adapter;
    int flag_yiju;
    int flag_yiju1;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private List<checi> checiList = new ArrayList<>();//
    TextView back;
    TextView  txtpath;
    TextView tomorrow,yesterday,cfrqchaxun;
    Button fashi,lishi,daoshi,piaojia;
    String year,month,day;
    String cfrq;
    private  String str1,str2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tickets);
        editor =getSharedPreferences("data",MODE_PRIVATE).edit();
        pref  =getSharedPreferences("data",MODE_PRIVATE);


        str1=pref.getString("didian1_1","杭州");
         str2=pref.getString("didian2_2","上海");
        back=(TextView)findViewById(R.id.text_back);
        txtpath=(TextView)findViewById(R.id.txtpath);
        tomorrow=(TextView)findViewById(R.id.tomorrow);
        yesterday=(TextView)findViewById(R.id.yersterday);
        cfrqchaxun=(TextView)findViewById(R.id.cfrqchaxun);

        fashi=(Button)findViewById(R.id.btn_fashi);
        lishi=(Button)findViewById(R.id.btn_lishi);
        daoshi=(Button)findViewById(R.id.btn_daoshi);
        piaojia=(Button)findViewById(R.id.btn_piaojia);
        flag_yiju=pref.getInt("flag_yiju",1);
        flag_yiju1=pref.getInt("flag_yiju1",8);
        if(flag_yiju==1||flag_yiju==5){
            if(flag_yiju==1)
            fashi.setText("发时︿");
            else  fashi.setText("发时﹀");
            fashi.setTextColor(Color.parseColor("#ce0099ff"));
        }
        else if(flag_yiju==2||flag_yiju==6){
            if(flag_yiju==2)
            lishi.setText("历时︿");
            else lishi.setText("历时﹀");
            lishi.setTextColor(Color.parseColor("#ce0099ff"));
        }
        else if(flag_yiju==3||flag_yiju==7){
            if(flag_yiju==3)
                daoshi.setText("到时︿");
            else daoshi.setText("到时﹀");
            daoshi.setTextColor(Color.parseColor("#ce0099ff"));
        }
        if(flag_yiju1==4||flag_yiju1==8){
            if(flag_yiju1==4)
                piaojia.setText("票价");
            else piaojia.setText("余票");
            piaojia.setTextColor(Color.parseColor("#ce0099ff"));
        }
        //year = pref.getString("year","2017");
        // a=datePicker.getMonth();
        //month = pref.getString("month","1");
        //a=datePicker.getDayOfMonth();
       // day = pref.getString("day","1");

        //
        fashi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag_yiju==1)
                    flag_yiju=5;
                else
                    flag_yiju=1;
                editor.putInt("flag_yiju",flag_yiju);
                editor.apply();
                Intent intent =new Intent(tickets.this,tickets.class);
                startActivity(intent);
                //view.postInvalidate();
            }
        });
        lishi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag_yiju==2)
                    flag_yiju=6;
                else
                    flag_yiju=2;
                editor.putInt("flag_yiju",flag_yiju);
                editor.apply();
                Intent intent =new Intent(tickets.this,tickets.class);
                startActivity(intent);

            }
        });
        daoshi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag_yiju==3)
                    flag_yiju=7;
                else
                    flag_yiju=3;
                editor.putInt("flag_yiju",flag_yiju);
                editor.apply();
                Intent intent =new Intent(tickets.this,tickets.class);
                startActivity(intent);

            }
        });
        piaojia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag_yiju1==4)
                    flag_yiju1=8;
                else
                    flag_yiju1=4;
                editor.putInt("flag_yiju1",flag_yiju1);
                editor.apply();
                Intent intent =new Intent(tickets.this,tickets.class);
                startActivity(intent);

            }
        });
         adapter =new checiAdapter(
                tickets.this,R.layout.checi_item,checiList);
        listView = (ListView) findViewById(R.id.listcar);
        listView.setAdapter(adapter);//

        ///
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               // Toast.makeText(tickets.this, "请输入用户名!", Toast.LENGTH_SHORT).show();
                checi b=checiList.get(position);
                Intent intent=new Intent(tickets.this,Buytickets.class);
                editor.putString("checi",b.getName());
                editor.putString("chufa",b.getChufa());
                editor.putString("daozhan",b.getDaozhan());
                editor.putInt("yongshi",b.getYongshi());
                editor.putString("fashi",b.getFashi());
                editor.putString("daoshi",b.getDaoshi());
                editor.putString("ruanwo",b.getRuanwo());
                editor.putInt("t1",b.getT1());
                editor.putString("yingwo",b.getYingwo());
                editor.putInt("t2",b.getT2());
                editor.putString("yingzuo",b.getYingzuo());
                editor.putInt("t3",b.getT3());
                editor.putString("wuzuo",b.getWuzuo());
                editor.putInt("t4",b.getT4());
                editor.putFloat("p1",b.getP1());
                editor.putFloat("p2",b.getP2());
                editor.putFloat("p3",b.getP3());
                editor.putFloat("p4",b.getP4());
                editor.apply();
                startActivity(intent);

            }
        });


        ///
        cfrq=pref.getString("cfrq","2017-01-01");
        init();
        initcheci();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(tickets.this,chepiaoyuding.class);
                startActivity(intent);
            }
        });
        txtpath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String t=str1;
                str1=str2;
                str2=t;
                txtpath.setText(str1+"<>"+str2);
                editor.putString("didian1_1",str1);
                editor.putString("didian2_2",str2);
                editor.apply();
                Intent intent =new Intent(tickets.this,tickets.class);
                startActivity(intent);
            }
        });

        cfrqchaxun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(tickets.this,date.class);
                intent.putExtra("page",2);
                startActivity(intent);
            }
        });

        tomorrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try
                {
                    SimpleDateFormat sj = new SimpleDateFormat("yyyy-MM-dd");
                    Date d = sj.parse(cfrq);
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(d);
                    calendar.add(Calendar.DATE, 1);
                    cfrq=sj.format(calendar.getTime());
                    editor.putString("cfrq",cfrq);
                    editor.apply();
                    cfrqchaxun.setText(cfrq);
                }
                catch (ParseException e)
                {
                    System.out.println(e.getMessage());
                }
            }
        });
        yesterday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try
                {
                    SimpleDateFormat sj = new SimpleDateFormat("yyyy-MM-dd");
                    Date d = sj.parse(cfrq);
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(d);
                    calendar.add(Calendar.DATE, -1);
                    cfrq=sj.format(calendar.getTime());
                    editor.putString("cfrq",cfrq);
                    editor.apply();
                    cfrqchaxun.setText(cfrq);
                }
                catch (ParseException e)
                {
                    System.out.println(e.getMessage());
                }
            }
        });
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.hide();
        }
    }
    private void init(){
        txtpath.setText(str1+"<>"+str2);
        Toast.makeText(tickets.this,str1+str2,Toast.LENGTH_SHORT).show();
        cfrqchaxun.setText(cfrq);
    }



    private void initcheci(){
//    checi K1805 = new checi(checi,chufa,yongshi,daozhan,fashi,daoshi,ruanwo,youwu1,yingwo,youwu2,ruanzuo,youwu3,wuzuo,youwu4);
//    checiList.add(K1805);
        checiList.clear();
        checi k = new checi();
       // adapter.clear();
        Bmob.initialize(this, "55964b86a01fe7e320f3d2e9009e0426");
        BmobQuery<checi> query = new BmobQuery<checi>();
        if(flag_yiju==1){
            query.order("fashi");
        }
        else if(flag_yiju==5){
            query.order("-fashi");
        }
        else if(flag_yiju==2){
            query.order("yongshi");
        }
        else if(flag_yiju==6){
            query.order("-yongshi");
        }
        else if(flag_yiju==3){
            query.order("daoshi");
        }
        else if(flag_yiju==7){
            query.order("-daoshi");
        }
      /*  else if(flag_yiju==4){
            query.order("piaojia");
        }
        else if(flag_yiju==8){
            query.order("-piaojia");
        }*/
        query.addWhereEqualTo("chufa", str1);
        query.addWhereEqualTo("daozhan", str2);
        //Toast.makeText(tickets.this,str1+"----->"+str2, Toast.LENGTH_SHORT).show();
        query.setLimit(50);
        query.findObjects(new FindListener<checi>() {
            @Override
            public void done(List<checi> object, BmobException e) {

                if(e==null){
                    //toast("查询年龄6-29岁之间，姓名以'y'或者'e'结尾的人个数："+object.size());
            //Toast.makeText(tickets.this,String.valueOf(object.size()), Toast.LENGTH_SHORT).show();
                    for (checi i : object){
                       //Toast.makeText(tickets.this,i.getName(), Toast.LENGTH_SHORT).show();
                        checi p2 = new checi();
                        String Q=i.getName();
                        p2.setName(Q);
                        Q=i.getChufa();
                        p2.setChufa(Q);
                        Q=i.getFashi();
                        p2.setFashi(Q);
                        Q=i.getDaoshi();
                        p2.setDaoshi(Q);
                        p2.setYongshi(i.getYongshi());
                        p2.setDaozhan(i.getDaozhan());
                        p2.setRuanwo(i.getRuanwo());
                        p2.setYingwo(i.getYingwo());
                        p2.setYingzuo(i.getYingzuo());
                        p2.setWuzuo(i.getWuzuo());
                        p2.setT1(i.getT1());
                        p2.setT2(i.getT2());
                        p2.setT3(i.getT3());
                        p2.setT4(i.getT4());
                        p2.setAdd1(i.getAdd1());
                        p2.setAdd2(i.getAdd2());
                        p2.setP1(i.getP1());
                        p2.setP2(i.getP2());
                        p2.setP3(i.getP3());
                        p2.setP4(i.getP4());
                        checiList.add(p2);
                       // listView.deferNotifyDataSetChanged();
                       // myAdapter.notifyDataSetChanged();
                        adapter.notifyDataSetChanged();

                    }
                }else{
                    Toast.makeText(tickets.this,"123456", Toast.LENGTH_SHORT).show();
                    //Log.i("bmob","失败："+e.getMessage()+","+e.getErrorCode());
                }
            }
        });
    }


}
