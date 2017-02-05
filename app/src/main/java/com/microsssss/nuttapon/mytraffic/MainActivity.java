package com.microsssss.nuttapon.mytraffic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {


    // Explicit ประกาศตัวแปล
    ListView listView;   // Short Explicit
    private int[] ints = new int[]{R.drawable.traffic_01, R.drawable.traffic_02, R.drawable.traffic_03, R.drawable.traffic_04, R.drawable.traffic_05, R.drawable.traffic_06, R.drawable.traffic_07, R.drawable.traffic_08, R.drawable.traffic_09, R.drawable.traffic_10, R.drawable.traffic_11, R.drawable.traffic_12, R.drawable.traffic_13, R.drawable.traffic_14, R.drawable.traffic_15, R.drawable.traffic_16, R.drawable.traffic_17, R.drawable.traffic_18, R.drawable.traffic_19, R.drawable.traffic_20};

    private String[] titleStrings, detailStrings, shortdetailStrings;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Initial View
        listView = (ListView) findViewById(R.id.listTraffic);

        //Get Value
        titleStrings=getResources().getStringArray(R.array.title);
        detailStrings=getResources().getStringArray(R.array.detail);

         // sub string detail คือการตัดคำ
        shortdetailStrings=new String[detailStrings.length];  //จองหน่วยความจำ
        for (int i=0;i<detailStrings.length;i++) {   // ใหเ i เริ่มจาก 0 แล้ว วน
            shortdetailStrings[i]=detailStrings[i].substring(0,30)+ "...";  // ตัดคำตั้งแต่ 0-30 แล้วใส่ ... ต่อท้าย

        }  //for

        // Create Listview
        MyAdapter myAdapter=new MyAdapter(MainActivity.this, ints, titleStrings, shortdetailStrings);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(MainActivity.this,Detail.class);
                intent.putExtra("Title", titleStrings[position]);
                intent.putExtra("Detail", detailStrings[position]);
                intent.putExtra("Image", ints[position]);
                startActivity(intent);

            }
        });   //  เป้นการจับการ Click เพื่อส่งค่า





    }  // Main Method

}  // Main Class
