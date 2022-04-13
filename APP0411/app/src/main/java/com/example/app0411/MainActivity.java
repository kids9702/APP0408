package com.example.app0411;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    LinearLayout intro;
    private final String TAG = "MainActivity";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intro = (LinearLayout) findViewById(R.id.intro);
        intro.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.i("Main", "Go List");
                startActivity(new Intent(MainActivity.this, MemberListActivity.class));
                return true;
            }
        });

        if(AppConstant.memList == null)
            AppConstant.memList = new ArrayList<Member>();
        else
            Log.i(TAG, "현재 등록 멤버수 : " + AppConstant.memList.size());
    }

}