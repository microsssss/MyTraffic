package com.microsssss.nuttapon.mytraffic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by microsssss on 2/5/2017.
 */

public class MyAdapter extends BaseAdapter{   // สืบทอด Class ให้พิม Ex...

    //Explicit ประกาศตัวแปล
    private Context context;  // มำท่อส่งข้อมูล  ในท่อมี int และ string
    private int[] ints;    //สำหรับใส่รูป ICON
    private String[] titleStrings, detaStrings;  // สำหรับเก้บ Test
// กด Alt+insert  แล้วเลือกทั้งหมด
    public MyAdapter(Context context, int[] ints, String[] titleStrings, String[] detaStrings) {
        this.context = context;
        this.ints = ints;
        this.titleStrings = titleStrings;
        this.detaStrings = detaStrings;
    }

    @Override
    public int getCount() {
        return ints.length;   // คำสั่ง ints.length ให้ดึงรูปมาใส่
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //  สร้าง layout เสมือน
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE); // เปิด Service Layout
        View view = layoutInflater.inflate(R.layout.my_listview, parent, false);


        //Initial View  การผูก object รูปภาพ
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        TextView titleTextView = (TextView) view.findViewById(R.id.textView);
        TextView detailTextView = (TextView) view.findViewById(R.id.textView3);

        //Sho view
        imageView.setImageResource(ints[position]);
        titleTextView.setText(titleStrings[position]);
        detailTextView.setText(detaStrings[position]);


        return view;
    }
}   //Main Class
