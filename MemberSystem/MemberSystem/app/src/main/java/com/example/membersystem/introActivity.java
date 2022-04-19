package com.example.membersystem;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

public class introActivity extends AppCompatActivity implements View.OnTouchListener {

    private static final String TAG = "introActivity";
    private Boolean DEBUG           = true;

    private ActivityResultLauncher<Intent> mLauncher;

    LinearLayout batang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro); //intro layout

        batang = (LinearLayout) findViewById(R.id.batang);
        batang.setOnTouchListener(this);

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (view.getId()) {
            case R.id.batang:
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    Intent go = new Intent(this, MemberListActivity.class);
                    startActivity(go);
                    break;
                }
        }

        return true;
    }
}