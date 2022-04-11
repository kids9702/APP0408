package com.example.app0411;

import androidx.activity.result.ActivityResult;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MemberListActivity extends AppCompatActivity {

    Intent inform;
    private final int REQ_CODE_MES = 87;
    private ActivityResult data;
    TextView newTXT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_list);
        inform = this.getIntent();
        newTXT = (TextView) findViewById(R.id.newTXT);
    }

    public void join(View view) {
        Intent sign_in = new Intent(this, MemberJoinActivity.class);
        startActivityForResult(sign_in, REQ_CODE_MES);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode){
            case REQ_CODE_MES:
                if(resultCode == RESULT_OK){
                    String name = data.getStringExtra("name");
                    String email = data.getStringExtra("email");
                    String id = data.getStringExtra("id");
                    String pwd = data.getStringExtra("pwd");
                    newTXT.setText("새로 가입한 " + name + " 님 반갑습니다.");
                }
                else {
                    Log.i("sign", "유감...");
                }
        }
    }
}