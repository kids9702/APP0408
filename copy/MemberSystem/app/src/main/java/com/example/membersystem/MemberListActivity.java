package com.example.membersystem;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;


public class MemberListActivity extends AppCompatActivity {

    private final String TAG = "MemberListActivity";
    private final int REQ_CODE_MES  = 1000;

    // UI Widget
    private Button newMemBTN;
    private TextView resultTXT;
    private ListView memLV;

    // Feature
    private ActivityResultLauncher<Intent> mLauncher;
    private SimpleAdapter adapter;
    private ArrayList<HashMap<String, String>> PList;

    @Override
    protected void onResume() {
        super.onResume();

        /*
        if(AppConstant.memList.size() > 0) {
            resultTXT.setText("현재 등록 멤버 수 : " + AppConstant.memList.size());

            int nums = AppConstant.memList.size();
            String mems = "";
            for(int idx=0; idx<nums; idx++)
            {
                if(idx==(nums-1))
                    mems += AppConstant.memList.get(idx).getName();
                else
                    mems += AppConstant.memList.get(idx).getName() + "\n";
            }
            resultTXT.setText(mems);

        } else {
            resultTXT.setText(R.string.no_member);
        }
         */

        if(AppConstant.memList.size() > 0) {
            Log.i(TAG, "LISTVIEW VISIBLE");
            memLV.setVisibility(View.VISIBLE);
            resultTXT.setVisibility(View.GONE);
        } else {
            resultTXT.setText(R.string.no_member);
            Log.i(TAG, "LISTVIEW GONE");
            memLV.setVisibility(View.GONE);
            resultTXT.setVisibility(View.VISIBLE);
        }

        // 데이터 준비
        PList = new ArrayList<HashMap<String, String>>();

        for(int idx = 0; idx<AppConstant.memList.size(); idx++)
        {
            HashMap<String, String> p1 = new HashMap<>();
            p1.put(AppConstant.NAME, AppConstant.memList.get(idx).getName());
            p1.put(AppConstant.ID, AppConstant.memList.get(idx).getId());
            PList.add(p1);
        }


        // 데이터, 데이터 표시해줄 layout.xml 파일 전달 => adapter
        adapter = new SimpleAdapter(this,
                PList,
                android.R.layout.simple_list_item_2,
                new String[]{AppConstant.NAME, AppConstant.ID},
                new int[]{android.R.id.text1, android.R.id.text2}
        );


        memLV.setAdapter(adapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // (1) 화면 설정
        setContentView(R.layout.mem_list);


        // (2) UI widget, Feature 관련 초기화
        resultTXT = (TextView) findViewById(R.id.resultTXT);
        memLV = (ListView) findViewById(R.id.memLV);


        // (3) 데이터 준비
        mLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>(){
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode()==RESULT_OK) {
                            // 결과 + 데이터가 온 경우 => Intent 객체를 꺼내기
                            Intent data = result.getData();

                            Member new_mem = (Member) data.getSerializableExtra(AppConstant.NEW_MEM);
                            Toast.makeText(MemberListActivity.this, "RECEIVE DATA : " + new_mem.getName(), Toast.LENGTH_SHORT).show();

                            /*
                            Log.i(TAG, "NAME = " + data.getStringExtra("name"));
                            // Intent로 전달 받은 데이터 가져오기
                            resultTXT = (TextView) findViewById(R.id.resultTXT);
                            resultTXT.setText("새로 가입한 " + data.getStringExtra("name") +"님 반갑습니다!");
                            resultTXT.setTextSize(20.0f);
                            resultTXT.setVisibility(TextView.VISIBLE);
                             */


                        } else if(result.getResultCode()==RESULT_CANCELED) {
                            Log.i(TAG, "CANCELED");
                            /*
                            resultTXT = (TextView) findViewById(R.id.resultTXT);
                            resultTXT.setText("");
                            resultTXT.setTextSize(20.0f);
                            resultTXT.setVisibility(TextView.INVISIBLE);
                             */
                        }
                    }
                });
    }

    public void clickFunc(View view) {
        switch(view.getId()) {
            case R.id.newMemBTN:
                //startActivityForResult( new Intent(this, MemberJoinActivity.class), REQ_CODE_MES );
                mLauncher.launch(new Intent(this, MemberJoinActivity.class));
                break;
        }
    }
}