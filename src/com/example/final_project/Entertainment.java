package com.example.final_project;

import finalproject.entertainment.MusicService;
import finalproject.entertainment.Musiclisten;
import finalproject.entertainment.Readbook;
import finalproject.entertainment.viewimage;
import finalproject.soundmixer.mixer_mainactivity;
import finalproject.touchgesture.Touch_flipp;
import finalproject.touchgesture.regional;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class Entertainment extends Activity {
	

	Button readbook, imageview, musiclisten, tasbih, startService, endService;
	CheckBox chk;
  

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.entertainment);
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		 final Intent musicServiceIntent = new Intent(getApplicationContext(),
				MusicService.class);

		readbook = (Button) findViewById(R.id.button1);
		imageview = (Button) findViewById(R.id.button2);
		musiclisten = (Button) findViewById(R.id.button3);
		tasbih= (Button) findViewById(R.id.button4);
		startService = (Button) findViewById(R.id.button_service);
		chk = (CheckBox) findViewById(R.id.checkBox1);
		
		readbook.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Entertainment.this, Readbook.class);
				startActivity(i);

			}
		});
		imageview.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Entertainment.this, viewimage.class);
				startActivity(i);

			}
		});
		musiclisten.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Entertainment.this, Musiclisten.class);
				startActivity(i);

			}
		});
		tasbih.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Entertainment.this,regional.class);
				startActivity(i);

			}
		});
		startService.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent i = new Intent(Entertainment.this, mixer_mainactivity.class);
				startActivity(i);
			}
		});
		
       chk.setOnCheckedChangeListener(new OnCheckedChangeListener() {
		
		public void onCheckedChanged(CompoundButton arg0, boolean bool) {
			// TODO Auto-generated method stub
			if(bool)
				startService(musicServiceIntent);
			else
				stopService(musicServiceIntent);
		}
	});
     
       
	}
	
	 

}
