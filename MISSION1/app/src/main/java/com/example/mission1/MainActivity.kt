package com.example.mission1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log;
import android.os.PersistableBundle



class MainActivity : AppCompatActivity() {

    // Member Variable --------------------------------
    private static final String TAG = "MainActivity";
    private Boolean DEBUG           = true;
    // Override Method --------------------------------

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.intro)
        if(DEBUG) Log.i(TAG, msg: "onCreate");
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}