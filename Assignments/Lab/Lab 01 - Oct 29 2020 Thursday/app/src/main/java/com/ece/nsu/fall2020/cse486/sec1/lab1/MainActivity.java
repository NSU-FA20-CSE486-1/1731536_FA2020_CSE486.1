package com.ece.nsu.fall2020.cse486.sec1.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    String TAG1= "ActivityName";
    String TAG2= "MainActivityLog";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG1, "onCreate: MainActivity");
        Log.d(TAG2, "Happy Birthday Omio!");
    }
}