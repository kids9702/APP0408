package com.example.mission2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MISSION2";
    private static final Boolean DEBUG = true;

    private Button msg;
    private Button add;
    private Button cancel;
    private TextView list;
    private EditText input;
    private TextView output;
    private String temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        msg = (Button) findViewById(R.id.msg);
        add = (Button) findViewById(R.id.add);
        cancel = (Button) findViewById(R.id.cancel);
        list = (TextView) findViewById(R.id.list);
        input = (EditText) findViewById(R.id.input);
        output = (TextView) findViewById(R.id.output);
        temp = "";
        msg.setOnClickListener(this);
        add.setOnClickListener(this);
        cancel.setOnClickListener(this);
        list.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.add:
                if (input.getText().toString().length() != 0) {
                    temp = temp +  input.getText().toString() + "\n";
                    output.setText(temp);
                }
                break;


            case R.id.cancel:
                output.setText("");
                temp = "";
                break;

            case R.id.list:
                Intent go = new Intent(this, SecondActivity.class);
                finish();
                startActivity(go);
                break;
        }
    }
}