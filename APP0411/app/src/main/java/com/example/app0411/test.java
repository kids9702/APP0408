package com.example.app0411;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;



public class test extends AppCompatActivity {
    ArrayList<String> nameList;
    ArrayList<String> phoneList;
    LayoutInflater layoutInflater;
    LinearLayout container;
    View view;
    Context context;

    private ImageView imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        context = this;

        imageview = (ImageView) findViewById(R.id.imageView);

        nameList = new ArrayList();phoneList = new ArrayList();
        nameList.add("일하영");phoneList.add("010-0000-0000");
        nameList.add("이하영");phoneList.add("010-1111-1111");
        nameList.add("삼하영");phoneList.add("010-2222-2222");
        nameList.add("사하영");phoneList.add("010-3333-3333");
        nameList.add("송하영");phoneList.add("010-4444-4444");

        container = findViewById(R.id.container );
        layoutInflater = LayoutInflater.from(this);

        for(int i = 0; i < (nameList.size()); i++) {
            view = layoutInflater.inflate(R.layout.test, null, false);
            //이름
            TextView nameText = view.findViewById(R.id.item_name);
            nameText.setText(nameList.get(i));
            Log.i("test", String.valueOf(nameText.getId()));
            //번호
            TextView phoneText = view.findViewById(R.id.item_phonenum);
            phoneText.setText(phoneList.get(i));
            container.addView(view);
        }

        Glide.with(this)
                .load("https://www.codingfactory.net/wp-content/uploads/abc.jpg")
                .into(imageview);
    }
}