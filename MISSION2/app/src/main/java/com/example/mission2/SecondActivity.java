package com.example.mission2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.List;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

    private EditText name;
    private ImageView image;

    private int[] titles;
    private int[] paintings;
    private int cnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery);

        name = (EditText) findViewById(R.id.name);
        image = (ImageView) findViewById(R.id.image);
        image.setOnClickListener(this);
        image.setOnLongClickListener(this);
        titles = new int[]{R.string.prr, R.string.mona, R.string.star};
        paintings = new int[]{R.drawable.prr, R.drawable.monariza, R.drawable.starrynight};
        cnt=0;

    }

    @Override
    public void onClick(View view) {
        name.setText(titles[cnt]);
        image.setImageResource(paintings[cnt]);
        cnt = cnt+1;
        if (cnt == titles.length){
            cnt = 0;
        }
    }

    @Override
    public boolean onLongClick(View view) {
        name.setText(titles[0]);
        image.setImageResource(paintings[0]);
        return true;
    }
}