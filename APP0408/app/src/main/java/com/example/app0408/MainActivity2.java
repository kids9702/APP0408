package com.example.app0408;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {

    private static final String TAG = "MainActivity2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.i(TAG, "MA2---------onCreate");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "MA2---------onDestroy");
    }

    public void click(View view) {

        // - 1. 다른 액티비티로 전환
//        Intent back = new Intent(this, MainActivity.class);
//        startActivity(back);
//        finish();

        // - 2. 결과를 요청하는 Activity
        Intent ret = new Intent();
        ret.putExtra("Join", "가입 완료");
        setResult(RESULT_OK, ret);
        finish();


    }
}