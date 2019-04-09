package com.example.sqliteexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    MyDbAdaptar myDbAdaptar;
    TextView pid, name, qty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        pid = (TextView) findViewById(R.id.textViewid);
        name = (TextView) findViewById(R.id.textViewname);
        qty = (TextView) findViewById(R.id.textViewqty);

        Intent i = getIntent();
        int position = i.getExtras().getInt("pos");
        myDbAdaptar = new MyDbAdaptar(this);
        int id = position + 1;
        System.out.println(position);
        Product product = myDbAdaptar.findProductById(id);
        System.out.println(product);
        pid.setText(String.valueOf(product.getId()));
        name.setText(String.valueOf(product.getProductName()));
        qty.setText(String.valueOf(product.getQuantity()));
    }
}
