package com.ece.nsu.fall2020.cse486.sec1.lab02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView countTextView;
    private Button toastBtn, countBtn;
    private int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setContentView(R.layout.activity_main_coding_challange);  //coding challange layout
        toastBtn = findViewById(R.id.toastBtn);
        countTextView = findViewById(R.id.countText);
        countBtn = findViewById(R.id.countBtn);

        toastBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), R.string.toastMessage,Toast.LENGTH_SHORT).show();
            }
        });

        countBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                countTextView.setText(String.valueOf(count));
            }
        });
    }
}