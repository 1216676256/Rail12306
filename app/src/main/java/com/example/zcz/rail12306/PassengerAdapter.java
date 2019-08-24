package com.example.zcz.rail12306;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by ZCZ on 2017/12/29.
 */

public class PassengerAdapter extends ArrayAdapter<Passenger> {
    private int resourceId;

    public PassengerAdapter(Context context, int textViewResourseId, List<Passenger> objects) {
        super(context, textViewResourseId, objects);
        resourceId = textViewResourseId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Passenger passenger1 = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        CheckBox pass_name = (CheckBox) view.findViewById(R.id.pass_name);
        TextView pass_stu = (TextView) view.findViewById(R.id.pass_stu);
        TextView pass_identity = (TextView) view.findViewById(R.id.pass_identity);
        if(passenger1.isFlag())
            pass_name.setChecked(true);
        /*pass_stu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Buytickets.this,"hahaha",Toast.LENGTH_SHORT).show();
            }
        });*/
        pass_name.setText(passenger1.getName());
        pass_stu.setText(passenger1.getStu());
        pass_identity.setText(passenger1.getIdentity());
        return  view;

    }

}