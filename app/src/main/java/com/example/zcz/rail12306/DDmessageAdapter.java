package com.example.zcz.rail12306;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by ZCZ on 2017/12/29.
 */

public class DDmessageAdapter extends ArrayAdapter<DDmessage> {
    private int resourceId;
    public DDmessageAdapter(Context context, int textViewResourseId, List<DDmessage> objects) {
        super(context, textViewResourseId, objects);
        resourceId = textViewResourseId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DDmessage ddmessage = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        TextView dd_dingdanhao=(TextView)view.findViewById(R.id.dd_dingdanhao);
        TextView dd_chengke=(TextView)view.findViewById(R.id.dd_chengke);
        TextView dd_xinxi=(TextView)view.findViewById(R.id.dd_xinxi);
        TextView dd_time=(TextView)view.findViewById(R.id.dd_time);
        TextView dd_sum=(TextView)view.findViewById(R.id.dd_sum);
        dd_dingdanhao.setText(ddmessage.getObjectId());
        int sum=ddmessage.getSum();
        if(sum==1)
            dd_chengke.setText(ddmessage.getCustomer());
        else dd_chengke.setText(ddmessage.getCustomer()+" 等"+sum+"人");
        dd_xinxi.setText(ddmessage.getTime_start()+"开 "+ddmessage.getDestination_1()+"--"+ddmessage.getDestination_2());
        dd_sum.setText(String.valueOf(ddmessage.getSum()));






        dd_time.setText(ddmessage.getDate());

        return view;
    }

}