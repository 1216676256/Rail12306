package com.example.zcz.rail12306;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.helper.NotificationCompat;
import cn.bmob.v3.listener.SaveListener;

public class register_pass extends AppCompatActivity {
    EditText id,name,flag;
    Button ok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_pass);
        Bmob.initialize(this, "55964b86a01fe7e320f3d2e9009e0426");
        id=(EditText)findViewById(R.id.register_pass_id);
        name=(EditText)findViewById(R.id.register_pass_name);
        flag=(EditText)findViewById(R.id.register_pass_flag);
        ok=(Button) findViewById(R.id.register_pass_register);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Passenger p2 = new Passenger();
                    p2.setName(name.getText().toString());
                    p2.setStu(flag.getText().toString());
                    p2.setIdentity(id.getText().toString());
                    p2.setFlag(false);
                    p2.save(new SaveListener<String>() {
                        @Override
                        public void done(String objectId,BmobException e) {
                            if (e == null) {
                                Toast.makeText(register_pass.this,"添加成功", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(register_pass.this,"添加失败", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                Intent intent =new Intent(register_pass.this,Buytickets.class);
                startActivity(intent);
            }
        });
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.hide();
        }
    }
}
