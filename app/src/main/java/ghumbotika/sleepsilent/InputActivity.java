package ghumbotika.sleepsilent;

import java.util.Calendar;
import com.example.final_project.R;


import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;

import android.content.Intent;

import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;

import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class InputActivity extends Activity {	
	
	 String input;   
    Button setAlarm; 
    Button startTime; 
    Button endTime; 
   
	
    private TextView startTimeDisplay;
    private TextView endTimeDisplay;
    protected int mHour;
    protected int mMinute;
	 protected int sHour;
	 protected int eHour;
	 protected int sMinute;
	 protected int eMinute;
    static final int TIME_DIALOG_ID0 = 0;
    static final int TIME_DIALOG_ID1 = 1;
	 protected static final String LOGTAG = "ovi";
    
    
 // the callback received when the user "sets" the time in the dialog
    
	private TimePickerDialog.OnTimeSetListener startTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
		public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
			sHour = hourOfDay;
		    sMinute = minute;
			updateDisplay1();
		}
	};
	
	private TimePickerDialog.OnTimeSetListener endTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
		public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
			eHour = hourOfDay;
		    eMinute = minute;
			updateDisplay2();
		}
	};
	protected String startInput;
	protected String endInput;
	
	
	 protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.set_alarm);
		
		
		setAlarm = (Button) findViewById(R.id.save);
		startTime= (Button) findViewById(R.id.start_time);
		endTime= (Button) findViewById(R.id.end_time);
	    
		startTimeDisplay= (TextView) findViewById(R.id.startView);
		endTimeDisplay= (TextView) findViewById(R.id.endView);
		
		
		startTime.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				showDialog(TIME_DIALOG_ID0);
			}
		});
		
		endTime.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				showDialog(TIME_DIALOG_ID1);
			}
		});
		
		final Calendar c = Calendar.getInstance();
		mHour = c.get(Calendar.HOUR_OF_DAY);
		mMinute = c.get(Calendar.MINUTE);
		
		updateDisplay1();
		updateDisplay2();
		
		setAlarm.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
                AlarmCreateActivity alarm = new AlarmCreateActivity();
               Intent i = new Intent(InputActivity.this,AlarmCreateActivity.class);
               i.putExtra("shour", sHour);
               i.putExtra("sminute", sMinute);
               i.putExtra("ehour", eHour); i.putExtra("eminute", eMinute);
               startActivity(i);
		       finish();  
		           
		        
		       
			}
		});
		

}
	 
	 private void updateDisplay1() {
			startTimeDisplay.setText(new StringBuilder().append(pad(sHour)).append(":")
					.append(pad(sMinute)));
		}
	 
	 private void updateDisplay2() {
			endTimeDisplay.setText(new StringBuilder().append(pad(eHour)).append(":")
					.append(pad(eMinute)));
		}

		private static String pad(int c) {
			if (c >= 10)
				return String.valueOf(c);
			else
				return "0" + String.valueOf(c);
		}

		@Override
		protected Dialog onCreateDialog(int id) {
			switch (id) {
			case TIME_DIALOG_ID0:
				return new TimePickerDialog(this, startTimeSetListener, mHour, mMinute,
						true);
				
			case TIME_DIALOG_ID1:
				return new TimePickerDialog(this, endTimeSetListener, mHour, mMinute, true);
			}
			return null;
		}
		
	
	
}
