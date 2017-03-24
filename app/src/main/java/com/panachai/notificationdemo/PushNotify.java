package com.panachai.notificationdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PushNotify extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push_notify);

        //รับค่าข้อความแจ้งเตือนที่ส่งมา
        Bundle bundle = getIntent().getExtras();
        //อ่านข้อความที่ส่งมา
        String message = bundle.getString("message");
        //แสดงข้อความบน TextView
        TextView txtNotify = (TextView)findViewById(R.id.txtNotify);
        txtNotify.setText(message);
    }
}
