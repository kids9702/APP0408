package com.example.app0411;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MemberListActivity extends AppCompatActivity {

    TextView newTXT;
    private ActivityResultLauncher<Intent> mLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_list);
        newTXT = (TextView) findViewById(R.id.newTXT);
        mLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>(){
            @Override
            public void onActivityResult(ActivityResult result) {
                if(result.getResultCode() == RESULT_OK){
                    Intent dataINT = result.getData();
                    String name = dataINT.getStringExtra("name");
                    String email = dataINT.getStringExtra("email");
                    String id = dataINT.getStringExtra("id");
                    String pwd = dataINT.getStringExtra("pwd");
                    newTXT.setText("새로 가입한 " + name +"(" + id +  ") 님 반갑습니다.");
                }else if(result.getResultCode() == RESULT_CANCELED){
                    Log.i("sign", "유감...");
                }
            }
        });
    }

    public void join(View view) {
        mLauncher.launch(new Intent(this, MemberJoinActivity.class));
    }

}