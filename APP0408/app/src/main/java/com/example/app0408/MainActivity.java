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
public class MainActivity extends Activity {
    // Member Variable

    private final int REQ_CODE_MES = 87;

    public TextView mHelloTXT;

    private static final String TAG = "MainActivity";
    private static final boolean DEBUG = true;

    // Member Method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        Log.i(TAG, "onCreate");
    }
    public void clickFunc(View view) {

       switch(view.getId()){
           case R.id.simpleBTN:
               startActivity(new Intent(this, MainActivity1.class));
               break;

           case R.id.dataBTN:
               Intent data = new Intent(this, MainActivity3.class);
               data.putExtra("name", "박수현");
               data.putExtra("age", 24);
               startActivity(data);
               break;
           case R.id.resultBTN:
               startActivityForResult(new Intent(this, MainActivity2.class), REQ_CODE_MES);
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
