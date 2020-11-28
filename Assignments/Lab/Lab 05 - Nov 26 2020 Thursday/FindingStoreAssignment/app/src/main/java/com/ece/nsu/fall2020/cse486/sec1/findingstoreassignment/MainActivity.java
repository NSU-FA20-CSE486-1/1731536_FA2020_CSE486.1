package com.ece.nsu.fall2020.cse486.sec1.findingstoreassignment;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> items;
    TextView[] tvIdList;
    EditText searchEt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchEt = findViewById(R.id.searchET);
        items = new ArrayList<>();
        tvIdList = new TextView[10];
        for(int i=0;i<10;i++)
        {
            String textViewId= "tv".concat(String.valueOf(i));
            int resID = getResources().getIdentifier(textViewId, "id", getPackageName());
            tvIdList[i] = findViewById(resID);
        }

        Intent intent= getIntent();
        if(intent!=null)
        {

            try {
                items = intent.getStringArrayListExtra("LIST");
                if(!items.isEmpty()) {findViewById(R.id.emptyTv).setVisibility(View.INVISIBLE);}
                for(int i = 0; i<items.size(); i++)
                {
                    tvIdList[i].setText(String.valueOf(i+1).concat(". ").concat(items.get(i)));
                    tvIdList[i].setVisibility(View.VISIBLE);
                }
            }catch (Exception e){}
        }
    }

    public void StartSecondActivity(View view)
    {
        Intent intent = new Intent(getApplicationContext(),SecondActivity.class);
        intent.putStringArrayListExtra("LIST",items);
        startActivity(intent);
        finish();
    }

    public void SearchStore(View view)
    {
        String location = searchEt.getText().toString();
        Uri addressUri = Uri.parse("geo:0,0?q=" + location);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(this, "Failed to create intent!", Toast.LENGTH_SHORT).show();
        }
    }
}