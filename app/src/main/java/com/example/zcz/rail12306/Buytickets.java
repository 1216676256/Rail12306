package com.example.zcz.rail12306;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.security.spec.PSSParameterSpec;
import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.CountListener;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

public class Buytickets extends AppCompatActivity {
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    Button add;
    Button buy;
    ListView listView;
    PassengerAdapter adapter;
    private int which=-1;
    private List<Passenger> passengersList = new ArrayList<>();

    TextView aaa,bbb,carname;
    TextView seat1,seat2,seat3,seat4;
    TextView time_yongshi;
    TextView time_1,time_2;
   // private int  sum;
   // private int sum1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buytickets);
        //sum=0;
       // sum1=-1;
        Bmob.initialize(this, "55964b86a01fe7e320f3d2e9009e0426");
        editor =getSharedPreferences("data",MODE_PRIVATE).edit();
        pref  =getSharedPreferences("data",MODE_PRIVATE);
        final String checi=pref.getString("checi","");
        final String chufa=pref.getString("chufa","");
        final String daozhan=pref.getString("daozhan","");
        final int yongshi=pref.getInt("yongshi",-1);
        final String fashi=pref.getString("fashi","");
        final String daoshi=pref.getString("daoshi","");
        final String ruanwo=pref.getString("ruanwo","");
        final int t1=pref.getInt("t1",-1);
        final String ruanzuo=pref.getString("yingwo","");
        final int t2=pref.getInt("t2",-1);
        final String yingzuo=pref.getString("yingzuo","");
        final int t3=pref.getInt("t3",-1);
        final String wuzuo=pref.getString("wuzuo","");
        final int t4=pref.getInt("t4",-1);
        final float p1=pref.getFloat("p1",0);
        final float p2=pref.getFloat("p2",0);
        final float p3=pref.getFloat("p3",0);
        final float p4=pref.getFloat("p4",0);
        //Toast.makeText(Buytickets.this, "111111sum="+String.valueOf(sum), Toast.LENGTH_SHORT).show();
        adapter =new PassengerAdapter(
                Buytickets.this,R.layout.passenger_item,passengersList);
        listView = (ListView) findViewById(R.id.passenger);
        listView.setAdapter(adapter);
        //Toast.makeText(Buytickets.this, "333333sum="+String.valueOf(sum1)+"   "+String.valueOf(sum), Toast.LENGTH_SHORT).show();

        init_passenger();
       // Toast.makeText(Buytickets.this, "333333sum="+String.valueOf(sum1)+"   "+String.valueOf(sum), Toast.LENGTH_SHORT).show();
        seat1=(TextView)findViewById(R.id.seat1);
        seat2=(TextView)findViewById(R.id.seat2);
        seat3=(TextView)findViewById(R.id.seat3);
        seat4=(TextView)findViewById(R.id.seat4);

        buy=(Button)findViewById(R.id.btn_buy);
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* BmobQuery<checi> query = new BmobQuery<checi>();
                query.addWhereEqualTo("checi",checi);
                query.findObjects(new FindListener<checi>() {
                    @Override
                    public void done(List<checi> object, BmobException e) {

                        if(e==null){
                            for (checi i : object){
                                if(which==1){
                                    i.setValue("t1",i.getT1()-1);
                                    i.update(objectId, new UpdateListener() {

                                        @Override
                                        public void done(BmobException e) {
                                            if(e==null){
                                                //Log.i("bmob","更新成功");
                                            }else{
                                               // Log.i("bmob","更新失败："+e.getMessage()+","+e.getErrorCode());
                                            }
                                        }

                                    });
                                }
                                //Toast.makeText(tickets.this,i.getName(), Toast.LENGTH_SHORT).show();

                            }
                        }else{
                            Toast.makeText(Buytickets.this,"未找到相应车次", Toast.LENGTH_SHORT).show();
                            //Log.i("bmob","失败："+e.getMessage()+","+e.getErrorCode());
                        }
                    }
                });*/
                DDmessage p2=new DDmessage();
                p2.setCustomer("123456");
                p2.setDestination_1(chufa);
                p2.setDestination_2(daozhan);
                p2.setTime_start(fashi);
                p2.setSum(1);
                p2.save(new SaveListener<String>() {
                    @Override
                    public void done(String objectId,BmobException e) {
                        if(e==null){
                            // toast("添加数据成功，返回objectId为："+objectId);
                        }else{
                            // toast("创建数据失败：" + e.getMessage());
                        }
                    }
                });
                Intent intent=new Intent(Buytickets.this,purchase_succeed.class);
                startActivity(intent);
            }
        });
        add=(Button)findViewById(R.id.buy_add_passenger);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Buytickets.this,register_pass.class);
                startActivity(intent);
            }
        });
       // Toast.makeText(Buytickets.this, "1322sum="+String.valueOf(sum), Toast.LENGTH_SHORT).show();
        aaa=(TextView)findViewById(R.id.aaa);
        bbb=(TextView)findViewById(R.id.bbb);
        carname=(TextView)findViewById(R.id.carname);
        time_yongshi=(TextView)findViewById(R.id.time_yongshi);
        time_1=(TextView)findViewById(R.id.time_1);
        time_2=(TextView)findViewById(R.id.time_2);
        seat1.setText(ruanwo+"\n"+t1+"张\n"+"¥"+p1);
        seat2.setText(ruanzuo+"\n"+t2+"张\n"+"¥"+p2);
        seat3.setText(yingzuo+"\n"+t3+"张\n"+"¥"+p3);
        seat4.setText(wuzuo+"\n"+t4+"张\n"+"¥"+p4);
        aaa.setText(chufa);
        bbb.setText(daozhan);
        carname.setText(checi);



        seat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                which=1;
                seat1.setBackgroundColor(Color.parseColor("#ce0099FF"));
                seat2.setBackgroundColor(Color.parseColor("#FFFFFF"));
                seat3.setBackgroundColor(Color.parseColor("#FFFFFF"));
                seat4.setBackgroundColor(Color.parseColor("#FFFFFF"));
            }
        });
        seat2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                which=2;
                seat2.setBackgroundColor(Color.parseColor("#ce0099FF"));
                seat1.setBackgroundColor(Color.parseColor("#FFFFFF"));
                seat3.setBackgroundColor(Color.parseColor("#FFFFFF"));
                seat4.setBackgroundColor(Color.parseColor("#FFFFFF"));
            }
        });
        seat3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                which=3;
                seat3.setBackgroundColor(Color.parseColor("#ce0099FF"));
                seat2.setBackgroundColor(Color.parseColor("#FFFFFF"));
                seat1.setBackgroundColor(Color.parseColor("#FFFFFF"));
                seat4.setBackgroundColor(Color.parseColor("#FFFFFF"));
            }
        });
        seat4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                which=4;
                seat4.setBackgroundColor(Color.parseColor("#ce0099FF"));
                seat2.setBackgroundColor(Color.parseColor("#FFFFFF"));
                seat3.setBackgroundColor(Color.parseColor("#FFFFFF"));
                seat1.setBackgroundColor(Color.parseColor("#FFFFFF"));
            }
        });

      /*  if(which==1){
            seat1.setBackgroundColor(Color.parseColor("#ce0099Ff"));
        }
        if(which==2){
            seat2.setBackgroundColor(Color.parseColor("#ce0099Ff"));
        }
        if(which==3){
            seat3.setBackgroundColor(Color.parseColor("#ce0099Ff"));
        }
        if(which==4){
            seat4.setBackgroundColor(Color.parseColor("#ce0099Ff"));
        }*/
        String str="";
        int t=yongshi/60;
        if(t>0)
            str=String.valueOf(t)+"小时";
        t=yongshi%60;
        if(t>10)
            str=str+String.valueOf(t)+"分钟";
        else
            str=str+"0"+String.valueOf(t)+"分钟";
        time_yongshi.setText(str);
        time_1.setText(fashi);
        time_2.setText(daoshi);



        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.hide();
        }
    }
    private  void init_passenger(){
        //sum1=10086;
        //Toast.makeText(Buytickets.this, "2222222sum="+String.valueOf(sum1)+"   "+String.valueOf(sum), Toast.LENGTH_SHORT).show();
        passengersList.clear();
        Bmob.initialize(this, "55964b86a01fe7e320f3d2e9009e0426");
        BmobQuery<Passenger> query = new BmobQuery<Passenger>();
       // query.addWhereEqualTo("flag",true);
        query.findObjects(new FindListener<Passenger>() {
            @Override
            public void done(List<Passenger> object, BmobException e) {
                if(e==null){

                    for (Passenger i : object){
                     //   sum=9999;
                       // sum1=888;
                      //  Toast.makeText(Buytickets.this, "2222222sum="+String.valueOf(sum1)+"   "+String.valueOf(sum), Toast.LENGTH_SHORT).show();
                        Passenger p2 = new Passenger();
                        p2.setName(i.getName());
                        p2.setStu(i.getStu());
                        p2.setIdentity(i.getIdentity());
                        p2.setFlag(i.isFlag());
                        passengersList.add(p2);
                        adapter.notifyDataSetChanged();


                    }
                }else{
                    Toast.makeText(Buytickets.this,"123456", Toast.LENGTH_SHORT).show();
                    //Log.i("bmob","失败："+e.getMessage()+","+e.getErrorCode());
                }
            }
        });
    }

}
