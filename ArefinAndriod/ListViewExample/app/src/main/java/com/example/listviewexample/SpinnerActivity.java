package com.example.listviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SpinnerActivity extends AppCompatActivity {
    Spinner spinner;
    List<String> cities = new ArrayList<>();
    TextView vCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        spinner = (Spinner) findViewById(R.id.spinner);
        cities.add("Dhaka");
        cities.add("Chittagong");
        cities.add("Khulna");
        cities.add("Rajshahi");
        cities.add("Sylhet");
        cities.add("Comilla");
        vCity = (TextView) findViewById(R.id.vCity);
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, cities);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                String[] cls = (String[]) cities.toArray();
                vCity.setText(cities.get(position));
                Toast.makeText(SpinnerActivity.this,"You selected: " + cities.get(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
