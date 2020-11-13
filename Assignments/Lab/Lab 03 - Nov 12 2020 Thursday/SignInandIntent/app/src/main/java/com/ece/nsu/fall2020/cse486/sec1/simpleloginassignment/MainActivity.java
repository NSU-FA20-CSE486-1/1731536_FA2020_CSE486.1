/*
 * Created by Rifat Islam on 14/11/2020.
 */
package com.ece.nsu.fall2020.cse486.sec1.simpleloginassignment;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    EditText usernameEt, passwordEt;
    Button loginBtn;
    boolean isPassHidden = true;
    ImageButton passwordVisibilityBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEt = findViewById(R.id.usernameET);
        passwordEt = findViewById(R.id.passwordET);
        loginBtn = findViewById(R.id.loginBtn);
        passwordVisibilityBtn = findViewById(R.id.password_visibility_toggle);

        //UI
        usernameEt.setOnFocusChangeListener((v, hasFocus) -> {
            if(hasFocus)
            {
                usernameEt.setBackground(getDrawable(R.drawable.edittext_onfocus_bg));
            }
            else
            {
                usernameEt.setBackground(getDrawable(R.drawable.edittext_bg_login));
            }
        });
        passwordEt.setOnFocusChangeListener((v, hasFocus) -> {
            if(hasFocus)
            {
                passwordEt.setBackground(getDrawable(R.drawable.edittext_onfocus_bg));
            }
            else
            {
                passwordEt.setBackground(getDrawable(R.drawable.edittext_bg_login));
            }
        });


        //Handling API and login functionality
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://52.87.177.106/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            Call<List<User>> call;
            @Override
            public void onClick(View v) {
                String username = usernameEt.getText().toString().trim();
                String password = passwordEt.getText().toString();
                EmptyError(passwordEt);
                EmptyError(usernameEt);

                if(!username.isEmpty() && !password.isEmpty())
                {
                    call = jsonPlaceHolderApi.getUserId(username,password);

                    call.enqueue(new Callback<List<User>>() {
                        @Override
                        public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                            if(!response.isSuccessful())
                            {
                                Toast.makeText(getApplicationContext(), "Error: ".concat(response.message()), Toast.LENGTH_SHORT).show();
                                return;
                            }
                            List<User> user = response.body();
                            if(user.get(0).getStatus().equals("ok"))
                            {
                                Toast.makeText(getApplicationContext(),"Success: User logged in!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                                intent.putExtra("username",username);
                                finish();
                                startActivity(intent);
                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(), "Error: Username and password do not match!", Toast.LENGTH_SHORT).show();
                            }
                        }
                        @Override
                        public void onFailure(Call<List<User>> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "Error: Check internet connection!", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }


    //UI method
    public void VisibilityToggle(View view)
    {
        if(isPassHidden)
        {
            passwordVisibilityBtn.setImageResource(R.drawable.ic_visibility_on);
            passwordEt.setTransformationMethod(null);
        }
        else
        {
            passwordVisibilityBtn.setImageResource(R.drawable.ic_visibility_off);
            passwordEt.setTransformationMethod(new PasswordTransformationMethod());
        }
        isPassHidden = !isPassHidden;
    }

    public void EmptyError(EditText textView)
    {
        if(textView.getText().length()==0)
        {
            textView.setError("Required");
        }
    }
}