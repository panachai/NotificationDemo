package com.panachai.notificationdemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    //สร้างตัวแปรเก็บข้อความ Notify
    String title = "ComSci ไงจะใครล่ะ";
    String message = "เฉลยแล้วหน้ากากอีกาคือใคร";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //สร้าง method รองรับเมื่อผู้ใช้คลิกที่ปุ่ม send notification

    }

    public void SendNotification(View v) {
        //pedingIntent จัดการข้อความและการแจ้งเตือน
        Intent intent = new Intent(this, PushNotify.class);
        intent.putExtra("message", message);
        TaskStackBuilder stack = TaskStackBuilder.create(this);

        //กำหนด stack ให้ส่งข้อความไปที่ใด
        stack.addParentStack(PushNotify.class);
        stack.addNextIntent(intent);
        PendingIntent pendingIntent = stack.getPendingIntent(0,
                PendingIntent.FLAG_UPDATE_CURRENT);

        //สร้าง Notify ด้วยคลาส Notification
        Notification notify = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher) //กำหนด icon
                .setContentTitle(title)//กำหนดชื่อ notify
                .setContentText(message)//กำหนดข้อความ notify
                .setAutoCancel(true)//กำหนดให้ยกเลิกได้อัตโนมัติ
                .build();//สั่งให้สร้าง notify ตามที่กำหนด

        //เรียกใช้ notification service ของระบบ
        NotificationManager notifyMng = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);

        notifyMng.notify(1000, notify); //สั่งให้แสดง notify บนหน้าจอ
    }


}

