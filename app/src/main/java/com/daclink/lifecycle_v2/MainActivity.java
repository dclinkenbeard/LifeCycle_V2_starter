package com.daclink.lifecycle_v2;


import android.content.Context;
import android.view.View.OnLongClickListener;
import androidx.annotation.NonNull;
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
  private static final String BUTTON_STATE = "ButtonState";

  ActivityMainBinding binding;

  Button button;
  TextView mTextView;
  boolean messageOne = true;

  static Intent intentFactory(Context applicationContext, boolean showMessage1Child) {
    Intent intent = new Intent(applicationContext, MainActivity.class);
    intent.putExtra(BUTTON_STATE, showMessage1Child);
    return intent;
  }


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Log.d(TAG, "onCreate(Bundle) called");
    binding = ActivityMainBinding.inflate(getLayoutInflater());

    setContentView(binding.getRoot());
    messageOne = getIntent().getBooleanExtra(BUTTON_STATE, false);

    if (savedInstanceState != null) {
        messageOne = savedInstanceState.getBoolean(BUTTON_STATE, false);
    }

    button = binding.button;
    mTextView = binding.textView;
    getMessage();

    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if (messageOne) {
          mTextView.setText(R.string.message2);
          messageOne = false;
        } else {
          mTextView.setText(R.string.message1);
          messageOne = true;
        }
      }
    });

    button.setOnLongClickListener(new OnLongClickListener() {
        @Override
        public boolean onLongClick(View view) {
            Intent intent = ChildActivity.intentFactory(getApplicationContext(),messageOne);
            startActivity(intent);
            return false;
        }
    });
  }

  private void getMessage() {
      if (messageOne) {
          mTextView.setText(R.string.message2);
          messageOne = false;
      } else {
          mTextView.setText(R.string.message1);
          messageOne = true;
      }
  }

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

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

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