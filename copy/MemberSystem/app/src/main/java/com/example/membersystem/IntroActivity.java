package com.example.membersystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class IntroActivity extends AppCompatActivity {

    private LinearLayout background;

    private final String TAG = "IntroActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro);
        Log.i(TAG, "Intro --- onCreate");
        background = (LinearLayout) findViewById(R.id.background);

        /*
        background.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                startActivity(new Intent(IntroActivity.this, MemberListActivity.class));
                return true;
            }
        });
         */

        // DATA 저장 관련 변수 초기화
        if(AppConstant.memList == null)
            AppConstant.memList = new ArrayList<Member>();
        else
            Log.i(TAG, "현재 등록 멤버수 : " + AppConstant.memList.size());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, " MA2 -- onDestory ");
    }

    public void clickFunc(View view) {
        switch(view.getId()) {
            case R.id.background:
                startActivity(new Intent(this, MemberListActivity.class));
                break;
        }
    }
}