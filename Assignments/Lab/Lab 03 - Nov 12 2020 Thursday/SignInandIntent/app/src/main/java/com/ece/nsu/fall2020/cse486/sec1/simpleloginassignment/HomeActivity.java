/*
 * Created by Rifat Islam on 14/11/2020.
 */
package com.ece.nsu.fall2020.cse486.sec1.simpleloginassignment;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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

    public void Logout(View view)
    {
        finish();
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        Toast.makeText(getApplicationContext(), "User logged out!", Toast.LENGTH_SHORT).show();
    }
}