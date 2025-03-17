package com.daclink.lifecycle_v2;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.daclink.lifecycle_v2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "LifeCycleDemo";
    //TODO: add button state code here

    ActivityMainBinding binding;
    Button button;
    TextView mTextView;
    boolean messageOne = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate(Bundle) called");
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        //TODO: if saved instance state code goes about here

        button = binding.button;
        mTextView = binding.textView;

        //TODO: we will add a call to getMessage here

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (messageOne){
                    mTextView.setText(R.string.message2);
                    messageOne = false;
                } else {
                    mTextView.setText(R.string.message1);
                    messageOne = true;
                }
            }
        });


    }

    //TODO: add getMessage() about here

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    //TODO: Override onSaveInstanceState here.


    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }
}