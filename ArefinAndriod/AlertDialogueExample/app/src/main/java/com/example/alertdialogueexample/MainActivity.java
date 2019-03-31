package com.example.alertdialogueexample;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.hitmenow);
    }

    public void open(View view) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Are you sure you want to Hit me?");
        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(MainActivity.this, "You hit me, so I will see you in right time", Toast.LENGTH_LONG).show();
            }
        });
        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public void pickColor(View view) {
        final CharSequence[] items = {"Red", "Green", "Blue"};
        final AlertDialog.Builder abuilder = new AlertDialog.Builder(this);
        abuilder.setMessage("Pick a Color");
        abuilder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, items[which], Toast.LENGTH_SHORT);

            }
        });
        AlertDialog alert = abuilder.create();
        alert.show();
    }

    public void showCustomDialog(View view){
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom);
        dialog.setTitle("Title.....");

        TextView text = (TextView) dialog.findViewById(R.id.text);
        text.setText("Android custom dialog example!");
        ImageView image = (ImageView) dialog.findViewById(R.id.image);
        image.setImageResource(R.mipmap.ic_launcher);

        Button dialogButton = (Button) dialog.findViewById(R.id.button);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
