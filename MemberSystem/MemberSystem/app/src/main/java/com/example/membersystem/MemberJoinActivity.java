package com.example.membersystem;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MemberJoinActivity extends AppCompatActivity {
    // DEBGU ------------------------------------------------
    private final String TAG = "MemberJoinActivity";

    // Member Variable ----------------------------------------
    // UI Widget
    private EditText mName, mEmail, mId, mPass;

    // Member Method - AppCompactActivity's method ------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // (1) 화면 설정
        setContentView(R.layout.member_join);

        // (2) UI Widget 설정
        Log.i(TAG, "onCreate");
        mName=(EditText) findViewById(R.id.nameETXT);
        mEmail=(EditText) findViewById(R.id.emailETXT);
        mId=(EditText) findViewById(R.id.idETXT);
        mPass=(EditText) findViewById(R.id.pwETXT);
    }

    // Member Method - XML's onClick Attribute ---------------------
    public void joinclick(View view){
        int vID = view.getId();

        if(vID == R.id.joinBTN) {
            // setResult(RESULT_OK);    // No DATA
            Log.i(TAG, "joinclick() - joinBTN (1)");
            // 입력된 문자에서 공백(문자열의 앞뒤) 제거 후 길이 계산
            if((mName.getText().toString().trim().length() >0) && (mId.getText().toString().trim().length() >0)) {
                Log.i(TAG, "joinclick() - joinBTN (2) ");

                Member member = new Member(mName.getText().toString(),
                                            mEmail.getText().toString(),
                                            mId.getText().toString(),
                                            mPass.getText().toString());

                Intent retInt = new Intent();

                retInt.putExtra(AppConstant.NEW_MEM, member);
                // Member ArrayList에 추가하기
                if (AppConstant.memList == null) {
                    Log.i(TAG, "joinclick() - JOINBTN - ADD MEMBER 실패");
                }
                else {
                    AppConstant.memList.add(member);
                }
                // retInt.putExtra(AppConstant.ID, mId.getText().toString().trim());
                setResult(RESULT_OK, retInt);
                finish();
            }else{
                Toast.makeText(this, "모든 데이터를 입력해야지만 가입이 됩니다.", Toast.LENGTH_SHORT).show();
            }
        }else if(vID == R.id.cancelBTN){
            Log.i(TAG, "joinclick() - cancelBTN");
            setResult(RESULT_CANCELED);
            finish();
        }
    }
}