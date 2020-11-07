/*
 * Created by Rifat Islam on 07/11/2020.
 */
package com.ece.nsu.fall2020.cse486.sec1.simpleloginassignment;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    TextView userNameTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().setTitle("Home");
        userNameTv = findViewById(R.id.usernameTV);
        String username = getIntent().getStringExtra("username");
        userNameTv.setText(username.concat("!"));

    }
}