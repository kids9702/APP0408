package com.example.membersystem;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

// -----------------------------------------------------------
// MemberListActivity => 새회원가입 (MemberJoinActivity)
//                    <= 회원가입 결과 받기
// Activity 전환 후 결과 받아서 처리 => ActivityResultLauncher 사용
// -----------------------------------------------------------
public class MemberListActivity extends AppCompatActivity {
    // DEBGU ------------------------------------------------
    private final String TAG = "MemberListActivity";

    // Member Variable ----------------------------------------
    // UI Widget
    private TextView                        mMemberInfoTXT;
    private ListView                        mMemberLV;
    private ArrayList<HashMap<String, String>> mPList;

    // Feature
    private ActivityResultLauncher<Intent>  mLauncher;
    private SimpleAdapter                   mAdapter;

    // Member Method --------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // (1) 화면 설정
        setContentView(R.layout.member_list);

        // (2) UI Widget, Feature 관련 초기화
        mMemberInfoTXT = (TextView) findViewById(R.id.memberInfoTXT);
        mMemberLV = (ListView) findViewById(R.id.memLV);
        if (AppConstant.memList.size()>0) {
            mMemberLV.setVisibility(View.VISIBLE);
            mMemberInfoTXT.setVisibility(View.GONE);
        }
        else {
            mMemberLV.setVisibility(View.GONE);
            mMemberInfoTXT.setVisibility(View.VISIBLE);
        }

        // (3) 데이터 준비
        mPList = new ArrayList<HashMap<String, String>>();

        if(AppConstant.memList.size()>0) {
            for (int idx=0; idx<AppConstant.memList.size(); idx++) {
                HashMap<String, String> p1 = new HashMap<>();
                p1.put(AppConstant.NAME, AppConstant.memList.get(idx).getName());
                p1.put(AppConstant.ID, AppConstant.memList.get(idx).getName());
                mPList.add(p1);
            }
        }

        // 데이터, 데이터 표시해줄 layout.xml 파일 전달 ==> Adapter
        mAdapter = new SimpleAdapter(this, mPList, android.R.layout.simple_list_item_2,
                                     new String[]{AppConstant.NAME, AppConstant.ID},
                                     new int[]{android.R.id.text1, android.R.id.text2});

        // ListView에 List 담기 설정하기
        mMemberLV.setAdapter(mAdapter);

//
//        if (AppConstant.memList.size()>0) {
//            mMemberInfoTXT.setText("현재 등록 멤버 수 : " + AppConstant.memList.size());
//            int nums = AppConstant.memList.size();
//            String mems = "";
//
//                    for(int idx = 0; idx<nums; idx++)
//                    {
//                        if (idx == (nums-1))
//                            mems += AppConstant.memList.get(idx).getName();
//                        else
//                            mems += AppConstant.memList.get(idx).getName() + "\n";
//                        mMemberInfoTXT.setText(mems);
//                    }
//        }
//        else {
//            mMemberInfoTXT.setText(R.string.no_member);
//        }
//
//        // (3) Activity 전환 관련 Launcher 생성
        mLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode() == RESULT_OK) {
                            Log.i(TAG, "result : " + result);
                            Intent retData = result.getData();
                            Member new_mem = (Member) retData.getSerializableExtra(AppConstant.NEW_MEM);
                            Toast.makeText(MemberListActivity.this, "RECEIVE DATA" + new_mem.getName(), Toast.LENGTH_SHORT).show();
//                            Toast.makeText(MemberListActivity.this,"RECEIVE  DATA : " +
//                                           retData.getStringExtra(AppConstant.NAME),
//                                           Toast.LENGTH_SHORT).show();
                        }else if(result.getResultCode() == RESULT_CANCELED){
                            Log.e(TAG, "result : " + result);
                        }
                    }
                });
    }

    // Member Method - XML onClick attribute ---------------------------------
    public void clickList(View view) {
        if(view.getId() == R.id.addBTN)
        {
            Log.i(TAG, "goClick-> ");
            mLauncher.launch(new Intent(this, MemberJoinActivity.class));
        }
    }

}