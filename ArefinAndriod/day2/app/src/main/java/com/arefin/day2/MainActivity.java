package com.arefin.day2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name, pass;
    Button login, goAnother, linear, relative, table;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.editTextusername);
        pass = (EditText) findViewById(R.id.editTextpassword);
        login = (Button) findViewById(R.id.buttonlogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder sb = new StringBuilder();
                sb.append("User Name: " + name.getText().toString() + "\n");
                sb.append("Password: " + pass.getText().toString());
                Toast toast = Toast.makeText(getApplicationContext() ,sb.toString(), Toast.LENGTH_LONG);
                toast.show();
            }
        });

        goAnother = (Button) findViewById(R.id.buttonanother);
        goAnother.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AnotherActivity.class);
                startActivity(intent);
            }
        });

        linear = (Button) findViewById(R.id.buttonlenier);
        linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LenierLayout.class);
                startActivity(intent);
            }
        });

        relative = (Button) findViewById(R.id.buttonrelative);
        relative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RelativeLayout.class);
                startActivity(intent);
            }
        });

        table = (Button) findViewById(R.id.buttontable);
        table.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TableLayout.class);
                startActivity(intent);
            }
        });
    }
}
