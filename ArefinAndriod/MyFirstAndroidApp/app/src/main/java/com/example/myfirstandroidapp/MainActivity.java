package com.example.myfirstandroidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText ball, over;
    Button btn, reset;
    int balls = 0;
    int overs = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ball = (EditText) findViewById(R.id.ball);
        over = (EditText) findViewById(R.id.over);
        btn = (Button) findViewById(R.id.btncount);
        reset = (Button) findViewById(R.id.btnreset);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             balls++;
             ball.setText(String.valueOf(balls));

             if(balls == 6){
                 balls = 0;
                 overs++;
                 over.setText(String.valueOf(overs));
             }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                balls = 0;
                overs = 0;
                ball.setText(String.valueOf(0));
                over.setText(String.valueOf(0));
            }
        });
    }
}
