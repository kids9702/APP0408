package com.example.app0411;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;

public class MemberListActivity extends AppCompatActivity {

    private final String TAG = "MemberListActivity";

    TextView newmemTXT;
    ListView listLV;
    private ArrayList<HashMap<String, String>> mPList;

    private ActivityResultLauncher<Intent> mLauncher;
    private SimpleAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_list);
        newmemTXT = (TextView) findViewById(R.id.newTXT);
        listLV = (ListView) findViewById(R.id.listLV) ;

        if (AppConstant.memList.size()>0) {
            listLV.setVisibility(View.VISIBLE);
            newmemTXT.setVisibility(View.GONE);
        }else {
            listLV.setVisibility(View.GONE);
            newmemTXT.setVisibility(View.VISIBLE);
        }

        mPList = new ArrayList<HashMap<String, String>>();

        if(AppConstant.memList.size()>0) {
            for (int idx=0; idx<AppConstant.memList.size(); idx++) {
                HashMap<String, String> p1 = new HashMap<>();
                p1.put(AppConstant.NAME, AppConstant.memList.get(idx).getName());
                p1.put(AppConstant.ID, AppConstant.memList.get(idx).getName());
                mPList.add(p1);
            }
        }

        mAdapter = new SimpleAdapter(this, mPList, android.R.layout.simple_list_item_2,
                new String[]{AppConstant.NAME, AppConstant.ID},
                new int[]{android.R.id.text1, android.R.id.text2});

        // ListView에 List 담기 설정하기
        listLV.setAdapter(mAdapter);

        mLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>(){
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

//    @Override
//    protected void onResume() {
//        super.onResume();
//        if(AppConstant.memList.size()>0) {
//            newmemTXT.setText("현재 등록 멤버 수 : " + AppConstant.memList.size());
//            int nums = AppConstant.memList.size();
//            String mems = "";
//            for (int idx = 0; idx < nums; idx++) {
//                if(idx == (nums-1)){
//                    mems += AppConstant.memList.get(idx).getName();
//                }
//                else{
//                    mems += AppConstant.memList.get(idx).getName() + "\n";
//                }
//                newmemTXT.setText(mems);
//            }
//        }
//        else{
//            newmemTXT.setText(R.string.no_member);
//        }
//    }

    public void join(View view) {
        mLauncher.launch(new Intent(this, MemberJoinActivity.class));
    }

}