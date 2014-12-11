package ghumbotika.sleepsilent;

import java.util.Calendar;
import com.example.final_project.R;




import android.R.string;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class AlarmCreateActivity extends Activity {

	private AlarmManager mAlarmManager;
	private Intent mNotificationReceiverIntent, mLoggerReceiverIntent;
	private PendingIntent mNotificationReceiverPendingIntent,
			mLoggerReceiverPendingIntent;
	private static long START_ALARM_DELAY;
	private static long END_ALARM_DELAY; 
	
	 private Intent MNotificationreceiver;
	 private PendingIntent mNotificationReceiverPending;


	 private int sHour;
	 private int eHour;
     private int sMinute;
     private int eMinute;
     
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.alarm_main);
		
		

		// Get the AlarmManager Service
		mAlarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

		// Create PendingIntent to start the AlarmNotificationReceiver
		mNotificationReceiverIntent = new Intent(AlarmCreateActivity.this,
				AlarmNotificationReceiver.class);
		mNotificationReceiverPendingIntent = PendingIntent.getBroadcast(
				AlarmCreateActivity.this, 0, mNotificationReceiverIntent, 0);

		// Create PendingIntent to start the AlarmLoggerReceiver
		mLoggerReceiverIntent = new Intent(AlarmCreateActivity.this,
				AlarmLoggerReceiver.class);
		mLoggerReceiverPendingIntent = PendingIntent.getBroadcast(
				AlarmCreateActivity.this, 0, mLoggerReceiverIntent, 0);
		
		MNotificationreceiver = new Intent(AlarmCreateActivity.this, NotificationReceiver.class);
		mNotificationReceiverPending = PendingIntent.getBroadcast(AlarmCreateActivity.this, 0, MNotificationreceiver, 0);


		
		

		
		// Repeating Alarm Button
		final Button repeatingAlarmButton = (Button) findViewById(R.id.launch_service);

		repeatingAlarmButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				
				try {
					Intent inty = getIntent();
					Bundle bundle = inty.getExtras();
					
					int starthour= bundle.getInt("shour");
					
					int startminute= bundle.getInt("sminute");
					
					int endhour= bundle.getInt("ehour");
					
					int endminute= bundle.getInt("eminute");
					
					Calendar start = Calendar.getInstance();

					start.set(start.HOUR_OF_DAY, starthour);
					start.set(start.MINUTE, startminute);
					start.set(start.SECOND, 0);
					Calendar end = Calendar.getInstance();
					end.set(end.HOUR_OF_DAY, endhour);
					end.set(end.MINUTE, endminute);
					end.set(end.SECOND, 0);
					Calendar current = Calendar.getInstance();
					current.getTime();
					start.getTime();
					int compareValue=start.compareTo(current);
					/*if(compareValue== -1)
						start.add(start.DAY_OF_MONTH, 1);
					
					compareValue=end.compareTo(current);
					if(compareValue== -1)
						end.add(end.DAY_OF_MONTH, 1);*/
					START_ALARM_DELAY = start.getTimeInMillis() - current.getTimeInMillis();
					END_ALARM_DELAY = end.getTimeInMillis() - current.getTimeInMillis();
					String a = String.valueOf(START_ALARM_DELAY);
					String b = String.valueOf(END_ALARM_DELAY);
					String c = String.valueOf(END_ALARM_DELAY-START_ALARM_DELAY);
					Toast.makeText(getApplicationContext(), a + " " +b+" "+c,
							Toast.LENGTH_LONG).show();
					
					mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+START_ALARM_DELAY, AlarmManager.INTERVAL_DAY, mNotificationReceiverPendingIntent);
					mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+END_ALARM_DELAY, AlarmManager.INTERVAL_DAY, mLoggerReceiverPendingIntent);
					mAlarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+START_ALARM_DELAY-2000L,mNotificationReceiverPending);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});

		 Button sleepCycleSetButton = (Button) findViewById(R.id.set_sleep_cycle);
		sleepCycleSetButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), InputActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		

		// Cancel Repeating Alarm Button
		final Button cancelRepeatingAlarmButton = (Button) findViewById(R.id.stop_service);
		cancelRepeatingAlarmButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				mAlarmManager.cancel(mNotificationReceiverPendingIntent);
				mAlarmManager.cancel(mLoggerReceiverPendingIntent);

				Toast.makeText(getApplicationContext(),
						"Repeating Alarms Cancelled", Toast.LENGTH_LONG).show();
			}
		});

	}
	

	
}