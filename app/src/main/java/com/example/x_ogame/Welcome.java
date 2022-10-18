package com.example.x_ogame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Welcome extends AppCompatActivity {
    TextView tv1,tv2;
    Button start;
    String p1,p2;
    public static final String PLAYER1_KEY="p1";
            public static final String PLAYER2_KEY="p2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        //inflate items
        tv1=findViewById(R.id.tv1);
        tv2=findViewById(R.id.tv2);
        start=findViewById(R.id.start);


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getBaseContext(),MainActivity.class);
                p1= tv1.getText().toString();
                p2= tv2.getText().toString();


                intent.putExtra(PLAYER1_KEY,p1);
                intent.putExtra(PLAYER2_KEY,p2);
                startActivity(intent);

            }
        });
    }
}