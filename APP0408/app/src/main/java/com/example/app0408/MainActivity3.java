package com.example.app0408;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    Intent revData;
    TextView dataTXT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        revData = this.getIntent();
        dataTXT = findViewById(R.id.helloTXT);
        dataTXT.setText("name : " + revData.getStringExtra("name") + " | " + revData.getIntExtra("age", 0));
        dataTXT.setTextSize(20.0f);
    }
    public void click(View view) {
    }
}