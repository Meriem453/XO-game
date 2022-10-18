package com.example.x_ogame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,replay;
    String[][] grid;
    int score1,score2;
    String player;
    //TextView tscore1,tscore2;
         TextView   player1,player2;



    //initialize the game*
    void initialize() {
        //initialize the array
        player="x";
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                grid[i][j] = "";
            }
        //avtivate buttons
        click(true);

        //clear all buttons
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");

/*
        //initialize the scores
        tscore1.setText(score1);
        tscore2.setText(score2);*/
    }
    //activate/disactivate buttons
    void click(boolean clickable){
        btn1.setClickable(clickable);
        btn2.setClickable(clickable);
        btn3.setClickable(clickable);
        btn4.setClickable(clickable);
        btn5.setClickable(clickable);
        btn6.setClickable(clickable);
        btn7.setClickable(clickable);
        btn8.setClickable(clickable);
        btn7.setClickable(clickable);
    }
    //check if there is a winner
    void check(){
        boolean winner=false;

         //check horizontaly
        for(int i=0;i<3;i++) {
            if (grid[i][0].equals(grid[i][1]) && grid[i][1].equals(grid[i][2])&&(grid[i][2]!="")) {
                winner = true;
                break;
            }
        }
        //check verticaly
        for(int i=0;i<3;i++) {
            if (grid[0][i].equals(grid[1][i]) && grid[1][i].equals(grid[2][i])&&(grid[2][i]!="")) {
                winner = true;
                break;
            }
        }
        //check diagonaly
        if (grid[0][0].equals(grid[1][1]) && grid[1][1].equals(grid[2][2])&&(grid[2][2]!="")) {
            winner = true;

        }
        if (grid[0][2].equals(grid[1][1]) && grid[1][1].equals(grid[2][0])&&(grid[2][0]!="")) {
            winner = true;

        }
        //if there is a winner
        if(winner){
            click(false);

            if(player.equals("x")){
                score1++;
                Toast.makeText(this, "Player 1 wins", Toast.LENGTH_SHORT).show();
                //win.setText("Congrats player 1");
            }else{
                score2++;
                Toast.makeText(this, "Player 2 wins", Toast.LENGTH_SHORT).show();
                //win.setText("Congrats player 2");
            }

        }else{
            change();
        }

    }
    //to change the player*
    void change(){
        if (player.equals("x")) {
            player="o";
        }else{
            player="x";
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        //inflate items

        btn1=findViewById(R.id.btn);
        btn2=findViewById(R.id.btn1);
        btn3=findViewById(R.id.btn2);
        btn4=findViewById(R.id.btn3);
        btn5=findViewById(R.id.btn4);
        btn6=findViewById(R.id.btn5);
        btn7=findViewById(R.id.btn6);
        btn8=findViewById(R.id.btn7);
        btn9=findViewById(R.id.btn8);

        replay=findViewById(R.id.replay);


       // tscore1=findViewById(R.id.s1);
       //  tscore2=findViewById(R.id.s2);

         player1=findViewById(R.id.player1);
         player2=findViewById(R.id.player2);
         //diplay player's names
          Intent intent=getIntent();
          String n=intent.getStringExtra(Welcome.PLAYER1_KEY);
          player1.setText(intent.getStringExtra(Welcome.PLAYER1_KEY));
          player2.setText(intent.getStringExtra(Welcome.PLAYER2_KEY));


         //initialize data
        grid= new String[3][3];
        initialize();
        score1=0;
        score2=0;




        //manage listeners
        replay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initialize();
            }
        });


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn1.setText(player);
                grid[0][0]=player;

                check();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn2.setText(player);
                grid[0][1]=player;
                check();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn3.setText(player);
                grid[0][2]=player;

                check();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn4.setText(player);
                grid[1][0]=player;

                check();
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn5.setText(player);
                grid[1][1]=player;

                check();
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn6.setText(player);
                grid[1][2]=player;

               check();
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn7.setText(player);
                grid[2][0]=player;

                check();
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn8.setText(player);
                grid[2][1]=player;

                check();
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn9.setText(player);
                grid[2][2]=player;

                check();
            }
        });




    }

}