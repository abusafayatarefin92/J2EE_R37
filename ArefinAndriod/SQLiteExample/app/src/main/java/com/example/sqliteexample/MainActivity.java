package com.example.sqliteexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
EditText id, name, qty;
MyDbAdaptar myDbHelper;
ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id = (EditText) findViewById(R.id.editTextid);
        name = (EditText) findViewById(R.id.editTextproductname);
        qty = (EditText) findViewById(R.id.editTextproductquantity);
        myDbHelper = new MyDbAdaptar(this);
        listView = (ListView) findViewById(R.id.listview);
        List<Product> p = myDbHelper.getList();
        ProductAdapter adapter = new ProductAdapter(this, p);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("pos", position);
                startActivity(intent);
                //Toast.makeText(MainActivity.this, "ID: " + position, Toast.LENGTH_SHORT).show();
            }
        });

    }



    public void saveProduct(View view){
        Product product = new Product(name.getText().toString(), Integer.parseInt(qty.getText().toString()));
        long i = myDbHelper.insertData(product);

        if(i < 0){
            Message.message(this, "Unsuccessfull");
        }else {
            getProductList();
            Message.message(this, "Successfull");
        }
    }

    public void updateProduct(View view){
        Product product = new Product(Integer.parseInt(id.getText().toString()), name.getText().toString(), Integer.parseInt(qty.getText().toString()));
        long i = myDbHelper.updateData(product);

        if(i < 0){
            Message.message(this, "Update Unsuccessfull");
        }else {
            getProductList();
            Message.message(this, "Update Successfull");
        }
    }

    public void getProductByProductId(View view){
        int pid = Integer.parseInt(id.getText().toString().trim());
        Product p = myDbHelper.findProductById(pid);
        if(p != null){
            name.setText(p.getProductName());
            qty.setText(String.valueOf(p.getQuantity()));
        }else {
            Toast.makeText(this, "No Data exists", Toast.LENGTH_SHORT).show();
        }
    }

    public void deleteProductByProductId(View view){
        int pid = Integer.parseInt(id.getText().toString().trim());
        myDbHelper.deleteProduct(pid);
        getProductList();
        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
    }

    public void getProductList(){
        listView = (ListView) findViewById(R.id.listview);
        List<Product> p = myDbHelper.getList();
        ProductAdapter adapter = new ProductAdapter(this, p);
        listView.setAdapter(adapter);
    }
}
