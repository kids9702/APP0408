package com.example.app0408;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


// Activity의 LifeCycle 살펴보기
public class MainActivity extends Activity implements View.OnClickListener {
    // Member Variable

    private final int REQ_CODE_MES = 87;

    public TextView mHelloTXT;

    private static final String TAG = "MainActivity";
    private static final boolean DEBUG = true;

    // Member Method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate");
        mHelloTXT = (TextView) findViewById(R.id.helloTXT);
        mHelloTXT.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.helloTXT:
                Toast.makeText(this, "click", Toast.LENGTH_LONG).show();
                Intent msg = new Intent(this, MainActivity2.class);

                // 작성된 Intent 객체를 Android System에 전달
                //startActivity(msg);

                // 작성된 Intent 객체를 Android System에 전달하면서 결과 받기 요청
                startActivityForResult(msg, REQ_CODE_MES);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode){
            case REQ_CODE_MES:
                if(resultCode == RESULT_OK){
                    Log.i(TAG, "결과 : " + data.getStringExtra("Join"));
                    Toast.makeText(this, data.getStringExtra("Join"), Toast.LENGTH_LONG).show();
                }
                else {
                    Log.i(TAG, "유감...");
                }
            }
        }
}
