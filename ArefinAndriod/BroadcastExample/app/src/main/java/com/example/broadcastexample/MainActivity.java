package com.example.broadcastexample;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button add, cancel;
    CheckBox chk;
    private AudioManager myAudioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add = (Button) findViewById(R.id.buttonadd);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAlerts();
            }
        });

        cancel = (Button) findViewById(R.id.buttoncancel);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelAlerts();
            }
        });

        chk = (CheckBox) findViewById(R.id.checkBox);

        chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    startAlerts();

                    //  Toast.makeText(MainActivity.this, "Android Checked", Toast.LENGTH_LONG).show();
                }
                else
                {

                    cancelAlerts();  // Toast.makeText(MainActivity.this, "Android Un-Checked", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    PendingIntent pendingIntent;
    public void startAlerts(){
        EditText text = (EditText) findViewById(R.id.editTexttime);
        int i = Integer.parseInt(text.getText().toString());
        Intent intent = new Intent(MainActivity.this, MyBroadcastReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(
                this.getApplicationContext(), 234324243, intent, PendingIntent.FLAG_CANCEL_CURRENT
        );
        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
        am.setRepeating(AlarmManager.RTC_WAKEUP, (i * 1000), (50 * 1000), pendingIntent);
        Toast.makeText(this, "Alarm set in " + i + " seconds", Toast.LENGTH_LONG).show();
    }

    public void cancelAlerts(){
        EditText text = (EditText) findViewById(R.id.editTexttime);
        int i = Integer.parseInt(text.getText().toString());
        Intent intent = new Intent(MainActivity.this, MyBroadcastReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(
                this.getApplicationContext(), 234324243, intent, PendingIntent.FLAG_CANCEL_CURRENT
        );
        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
        am.setRepeating(AlarmManager.RTC_WAKEUP, (i*1000),
                (50*1000),pendingIntent);
        Toast.makeText(this, "Alarm cancel",Toast.LENGTH_LONG).show();
    }
}
