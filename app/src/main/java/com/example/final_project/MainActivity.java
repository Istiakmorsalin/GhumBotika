package com.example.final_project;


import ghumbotika.sleepsilent.AlarmCreateActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {
	
	ImageView sleep, tips, entertainment, alarm,sleepsilent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        sleep=(ImageView) findViewById(R.id.AboutSleep);
        tips=(ImageView) findViewById(R.id.Tips);
        entertainment=(ImageView) findViewById(R.id.SleepGame);
        sleepsilent = (ImageView) findViewById(R.id.SleepAlarm);
        
        sleep.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i= new Intent(MainActivity.this,Sleep_about.class);
				startActivity(i);
				
			}
		});
        tips.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i= new Intent(MainActivity.this,Tips.class);
				startActivity(i);
				
			}
		});
        
        entertainment.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i= new Intent(MainActivity.this,Entertainment.class);
				startActivity(i);
				
			}
		});
sleepsilent.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i= new Intent(MainActivity.this,AlarmCreateActivity.class);
				startActivity(i);
				
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
