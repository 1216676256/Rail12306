package com.example.zcz.rail12306;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by lxd on 2017/12/16.
 */

public class checiAdapter extends ArrayAdapter<checi>{
    private SharedPreferences pref  =getContext().getSharedPreferences("data",MODE_PRIVATE);
    private SharedPreferences.Editor editor=getContext().getSharedPreferences("data",MODE_PRIVATE).edit();
    int flag_yiju1=pref.getInt("flag_yiju1",8);
    private int resourceId;
    public checiAdapter(Context context, int textViewResourseId, List<checi> objects){
        super(context,textViewResourseId,objects);
        resourceId =textViewResourseId;
    }

    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        checi checi1 =getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        TextView checiname = (TextView) view.findViewById(R.id.checi_name);
        TextView checichufa = (TextView) view.findViewById(R.id.checi_chufa);
        TextView checiyongshi = (TextView) view.findViewById(R.id.checi_yongshi);
        TextView checidaozhan = (TextView) view.findViewById(R.id.checi_daozhan);
        TextView checiruanwo = (TextView) view.findViewById(R.id.checi_ruanwo);
        TextView checiyingwo = (TextView) view.findViewById(R.id.checi_yingwo);
        TextView checiyingzuo = (TextView) view.findViewById(R.id.checi_yingzuo);
        TextView checiwuzuo = (TextView) view.findViewById(R.id.checi_wuzuo);
        TextView checifashi = (TextView) view.findViewById(R.id.checi_fashi);
        TextView checidaoshi = (TextView) view.findViewById(R.id.checi_daoshi);

        TextView add1=(TextView)view.findViewById(R.id.add1);
        TextView add2=(TextView)view.findViewById(R.id.add2);
        TextView t1=(TextView)view.findViewById(R.id.t1);
        TextView t2=(TextView)view.findViewById(R.id.t2);
        TextView t3=(TextView)view.findViewById(R.id.t3);
        TextView t4=(TextView)view.findViewById(R.id.t4);
        checiname.setText(checi1.getName());
        checichufa.setText(checi1.getChufa());
        checidaozhan.setText(checi1.getDaozhan());
        checiruanwo.setText(checi1.getRuanwo()+":");
        checiyingwo.setText(checi1.getYingwo()+":");
        checiyingzuo.setText(checi1.getYingzuo()+":");
        checiwuzuo.setText(checi1.getWuzuo()+":");
        checifashi.setText(checi1.getFashi());
        checidaoshi.setText(checi1.getDaoshi());
        String str="";
        int yongshi=checi1.getYongshi();
        int t=yongshi/60;
        if(t>0)
            str=String.valueOf(t)+"小时";
        t=yongshi%60;
        if(t>10)
            str=str+String.valueOf(t)+"分钟";
        else
            str=str+"0"+String.valueOf(t)+"分钟";
        checiyongshi.setText(str);
        add1.setText(checi1.getAdd1());
        add2.setText(checi1.getAdd2());
        if(flag_yiju1==8){
            t1.setText(String.valueOf(checi1.getT1())+"张");
            t2.setText(String.valueOf(checi1.getT2())+"张");
            t3.setText(String.valueOf(checi1.getT3())+"张");
            t4.setText(String.valueOf(checi1.getT4())+"张");
        }
        else{
            t1.setText("¥"+String.valueOf(checi1.getP1()));
            t2.setText("¥"+String.valueOf(checi1.getP2()));
            t3.setText("¥"+String.valueOf(checi1.getP3()));
            t4.setText("¥"+String.valueOf(checi1.getP4()));
        }


        if(checi1.getAdd1().equals("过"))
            add1.setBackgroundColor(Color.parseColor("#ce0099FF"));
        else add1.setBackgroundColor(Color.parseColor("#FFC125"));
        if(checi1.getAdd2().equals("过"))
            add2.setBackgroundColor(Color.parseColor("#ce0099FF"));
        else add2.setBackgroundColor(Color.parseColor("#00FF00"));
        return view;
    }
}


