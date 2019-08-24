package com.example.zcz.rail12306;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DDtickets extends AppCompatActivity {
    TextView txt123456;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ddtickets);
        txt123456=(TextView)findViewById(R.id.txt123456);
        Intent intent=getIntent();
        txt123456.setText(intent.getStringExtra("checi"));
    }
}
