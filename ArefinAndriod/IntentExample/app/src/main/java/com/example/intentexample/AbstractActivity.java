package com.example.intentexample;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AbstractActivity extends AppCompatActivity {
    TextView nm;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abstract);
        nm = (TextView) findViewById(R.id.textViewabstract);
        btn = (Button) findViewById(R.id.buttongo);

        Intent i = getIntent();
        String nam = i.getExtras().getString("nm");
        nm.setText(nam);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                Uri.parse("https://www.google.com/");
                startActivity(intent);
            }
        });
    }
}
