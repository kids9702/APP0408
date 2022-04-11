package com.example.app0411;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MemberJoinActivity extends AppCompatActivity {
    Button signBTN, cancelBTN;
    EditText nameETXT, emailETXT, idETXT, pwdETXT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_join);

        signBTN = (Button) findViewById(R.id.signBTN);
        cancelBTN = (Button) findViewById(R.id.cancelBTN);
        nameETXT = (EditText) findViewById(R.id.nameETXT);
        emailETXT = (EditText) findViewById(R.id.emailETXT);
        idETXT = (EditText) findViewById(R.id.idETXT);
        pwdETXT = (EditText) findViewById(R.id.pwdETXT);
    }

    public void click(View view) {
        switch (view.getId()){
            case R.id.signBTN:
                String name = nameETXT.getText().toString();
                String email = emailETXT.getText().toString();
                String id = idETXT.getText().toString();
                String pwd = pwdETXT.getText().toString();
                Intent inform = new Intent(this, MemberListActivity.class);
                inform.putExtra("name", name);
                inform.putExtra("email", email);
                inform.putExtra("id", id);
                inform.putExtra("pwd", pwd);
                setResult(RESULT_OK, inform);
                finish();
                break;

            case R.id.cancelBTN:
                setResult(RESULT_CANCELED);
                finish();
                break;
        }
    }
}