package com.example.allen.kcalendar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NotifyControl notify = new NotifyControl(this);
        notify.sendNotification("通知テスト", "通知タイトル", "通知出る？");

    }
}
