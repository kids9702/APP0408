package com.example.membersystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MemberJoinActivity extends AppCompatActivity {

    private String TAG = "MemberJoinActivity";
    private Button signupBTN, cancelBTN;
    private EditText name, email, id, passwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mem_join);

        signupBTN = (Button) findViewById(R.id.signupBTN);
        cancelBTN = (Button) findViewById(R.id.cancelBTN);

        name = (EditText) findViewById(R.id.nameETXT);
        email = (EditText) findViewById(R.id.emailETXT);
        id = (EditText) findViewById(R.id.idETXT);
        passwd = (EditText) findViewById(R.id.passwdETXT);
    }

    public void clickFunc(View view) {
        switch(view.getId()) {
            case R.id.signupBTN:
                Log.i(TAG, "joinclick() - joinBTN (1)");

                if((name.getText().toString().trim().length() > 0) && id.getText().toString().trim().length() > 0) {
                    Log.i(TAG, "joinclick() - joinBTN (2)");
                    // 다른 Activity로 Member 객체 전달
                    Member member = new Member(name.getText().toString(), email.getText().toString(), id.getText().toString(), passwd.getText().toString());


                    Intent res = new Intent();

                    res.putExtra(AppConstant.NEW_MEM, member);

                    // MEMBER ArrayList에 추가하기
                    if(AppConstant.memList == null)
                    {
                        Log.i(TAG, "joinclick() - joinBTN- ADD MEMBER 실패");
                    } else {
                        AppConstant.memList.add(member);
                    }

                    /*
                    res.putExtra("name", name.getText().toString());
                    res.putExtra("email", email.getText().toString());
                    res.putExtra("id", id.getText().toString());
                    res.putExtra("passwd", passwd.getText().toString());
                     */

                    setResult(RESULT_OK, res);
                    finish();
                } else {
                    Toast.makeText(this, "모든 데이터를 입력해야지만 가입이 됩니다.", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.cancelBTN:
                Intent ccl = new Intent();
                name.setText("");
                email.setText("");
                id.setText("");
                passwd.setText("");
                setResult(RESULT_CANCELED, ccl);
                finish();
                break;
        }
    }

}