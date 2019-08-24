package com.example.zcz.rail12306;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class DDsearch extends AppCompatActivity {
    ListView listView;
    DDmessageAdapter adapter;
    private List<DDmessage> ddmessageList = new ArrayList<>();
    Button yuding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ddsearch);
        yuding=(Button)findViewById(R.id.btn_yuding);


        adapter =new DDmessageAdapter(
                DDsearch.this,R.layout.ddmessage_item,ddmessageList);
        listView = (ListView) findViewById(R.id.list_ddsearch);
        listView.setAdapter(adapter);
        initdata();
        yuding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(DDsearch.this,chepiaoyuding.class);
                startActivity(intent);
            }
        });
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.hide();
        }
    }
    private  void initdata(){
        ddmessageList.clear();
        Bmob.initialize(this, "55964b86a01fe7e320f3d2e9009e0426");
        BmobQuery<DDmessage> query = new BmobQuery<DDmessage>();
        // query.addWhereEqualTo("flag",true);
        query.findObjects(new FindListener<DDmessage>() {
            @Override
            public void done(List<DDmessage> object, BmobException e) {
                if(e==null){

                    for (DDmessage i : object){
                        DDmessage p2 = new DDmessage();
                        p2.setDestination_2(i.getDestination_2());
                        p2.setTime_start(i.getTime_start());
                        p2.setCustomer(i.getCustomer());
                        p2.setDestination_1(i.getDestination_1());
                        p2.setObjectId(i.getObjectId());
                        p2.setDate(i.getCreatedAt());
                        p2.setSum(i.getSum());
                        ddmessageList.add(p2);
                        adapter.notifyDataSetChanged();
                    }
                }else{
                    Toast.makeText(DDsearch.this,"123456", Toast.LENGTH_SHORT).show();
                    //Log.i("bmob","失败："+e.getMessage()+","+e.getErrorCode());
                }
            }
        });
    }
}
