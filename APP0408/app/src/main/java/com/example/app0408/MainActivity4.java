package com.example.app0408;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity4 extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    public void backFunc(View view) {

        Log.i(TAG, "test");
        Intent backData = new Intent();
        backData.putExtra("result", "success");
        setResult(RESULT_OK, backData);
        finish();
    }
}