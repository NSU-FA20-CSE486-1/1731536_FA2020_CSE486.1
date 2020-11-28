package com.ece.nsu.fall2020.cse486.sec1.findingstoreassignment;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    String[] buttonTitleList;
    Button[] btnIdList;
    ArrayList<String> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        buttonTitleList = getResources().getStringArray(R.array.itemlist);
        btnIdList = new Button[10];

        Intent intent = getIntent();
        if(intent!=null)
        {
            items = intent.getStringArrayListExtra("LIST");
        }

        for(int i=0;i<10;i++)
        {
            String buttonId= "itemBtn".concat(String.valueOf(i));
            int resID = getResources().getIdentifier(buttonId, "id", getPackageName());
            btnIdList[i] = findViewById(resID);
            btnIdList[i].setText(buttonTitleList[i]);
        }
    }
    public void AddItem(View view)
    {
        Button button = (Button)view;
        if(items==null)
        {
            items  = new ArrayList<>();
        }
        if(items.size()==10)
        {
            Toast.makeText(getApplicationContext(), "Cart list is full, cannot add any more items!", Toast.LENGTH_SHORT).show();
        }
        else {
            if(items.contains(button.getText().toString()))
            {
                Toast.makeText(getApplicationContext(), "Item already in the cart!", Toast.LENGTH_SHORT).show();
            }
            else
            {
                items.add(button.getText().toString());
                Toast.makeText(getApplicationContext(), "Item added in the cart!", Toast.LENGTH_SHORT).show();
            }
        }
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        intent.putStringArrayListExtra("LIST",items);
        startActivity(intent);
        finish();
    }

}
