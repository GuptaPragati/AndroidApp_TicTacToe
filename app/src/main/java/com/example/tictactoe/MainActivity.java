package com.example.tictactoe;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {
    boolean gameActive=true;
    int activePlayer=0;
    int[] gameState={2,2,2,2,2,2,2,2,2};
    int[][] winPositions={
            {0,1,2},{3,4,5},{6,7,8},
            {0,3,6},{1,4,7},{2,5,8},
            {0,4,8},{2,4,6}
    };
    TextView winner;
    TextView status;
    /*
        player representation
        0 - X
        1 - O
        2- Null
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void playerTap(View view) {
        ImageView img=(ImageView) view;
        status= findViewById(R.id.status);
        winner= findViewById(R.id.winnerText);
        int getImageTag=Integer.parseInt(img.getTag().toString());
        if (!gameActive)
        {
            startAgain(view);
        }
        if (gameState[getImageTag]==2)
        {
            gameState[getImageTag]=activePlayer;
            if (activePlayer == 0)
            {
                img.setImageResource(R.drawable.x);
                activePlayer=1;
                        status.setText("O's Turn - Tap to play");
            }
            else
            {
                img.setImageResource(R.drawable.o);
                activePlayer=0;
                status.setText("X's Turn - Tap to play");
            }
            img.animate().setDuration(100);
        }
            for (int[] winPos:winPositions) {
                if (gameState[winPos[0]] == gameState[winPos[1]] && gameState[winPos[1]]==gameState[winPos[2]] &&
                        gameState[winPos[0]]!=2) {
                    String winnerStr;
                    if (gameState[winPos[0]]==0) {
                        Toast.makeText(this, "Game Over", Toast.LENGTH_SHORT).show();
                        winnerStr="X has won";
                        winner.setText(winnerStr);
                        break;
                    }
                    else {
                        Toast.makeText(this, "Game Over", Toast.LENGTH_SHORT).show();
                        winnerStr="O has won";
                        winner.setText(winnerStr);
                        break;
                    }
                }
            }
    }

    public void startAgain(View view) {
        gameActive=true;
        activePlayer=0;
        status= findViewById(R.id.status);
        winner= findViewById(R.id.winnerText);
        status.setText("");
        winner.setText("");
        for (int i=0;i<gameState.length;i++)
        {
            gameState[i]=2;
        }
        ((ImageView) findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView) findViewById(R.id.image7)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView9)).setImageResource(0);
    }

}
