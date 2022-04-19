package com.example.membersystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

// onTouchListener 설정 방법
// (1) Activity에 설정
// (2) 멤버변수로 onTouchListener객체 생성
// (3) onTouchListener 익명 클래스로 생성
public class MainActivity extends AppCompatActivity {
    // DEBGU ---------------------------------------------
    private static final String TAG = "MainActivity";

    // Member Variable ------------------------------------
    // UI Widget관련 ---------------------------------------
    private ConstraintLayout  mIntroLAY;

    // Member Method - AppCompatActivity's method ------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 화면 설정
        setContentView(R.layout.activity_main);

        // UI widget 초기화
        mIntroLAY = (ConstraintLayout) findViewById(R.id.introLAY);
        mIntroLAY.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                startActivity(new Intent(MainActivity.this, MemberListActivity.class));
                // true : 현재 Activity에서 터치이벤트 처리 완료의미, 시스템 X
                return true;
            }
        });

        // DATA 저장 관련 변수 초기화
        if (AppConstant.memList == null)
            AppConstant.memList = new ArrayList<Member>();
        else
            Log.i(TAG, "현재 등록 멤버수 : " + AppConstant.memList.size()); // 현재 몇개가 저장되어 있는지 알려줌
    }
}