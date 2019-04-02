package com.example.sqliteexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
EditText id, name, qty;
MyDbAdaptar myDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id = (EditText) findViewById(R.id.editTextid);
        name = (EditText) findViewById(R.id.editTextproductname);
        qty = (EditText) findViewById(R.id.editTextproductquantity);
        myDbHelper = new MyDbAdaptar(this);
    }

    public void saveProduct(View view){
        Product product = new Product(name.getText().toString(), Integer.parseInt(qty.getText().toString()));
        long i = myDbHelper.insertData(product);

        if(i < 0){
            Message.message(this, "Unsuccessfull");
        }else {
            Message.message(this, "Successfull");
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
        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
    }

    public void getProductList(){
        List<Product> p = myDbHelper.getList();
        System.out.println(p.size());
    }
}
