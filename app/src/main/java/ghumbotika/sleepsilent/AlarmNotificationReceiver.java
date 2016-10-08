package ghumbotika.sleepsilent;

import java.text.DateFormat;
import java.util.Date;
import com.example.final_project.R;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

public class AlarmNotificationReceiver extends BroadcastReceiver {
	
	

	
	private static final int MY_NOTIFICATION_ID = 1;

	AudioManager mode;
	
	private Intent mNotificationIntent;
	private PendingIntent mContentIntent;
	private final CharSequence tickerText = "এখন আপনার ঘুমাতে যাবার সময়";
	private final CharSequence contentTitle = "A Kind Reminder";
	private final CharSequence contentText = "Get back to studying!!";
	
	private long[] mVibratePattern = { 0, 200, 200, 300 };


	// Notification Sound and Vibration on Arrival
	

	@Override
	public void onReceive(Context context, Intent intent) {
         
		mode=  (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
		mode.setRingerMode(AudioManager.RINGER_MODE_SILENT); 		
      
		mNotificationIntent = new Intent(context, AlarmCreateActivity.class);
		mContentIntent = PendingIntent.getActivity(context, 0,
				mNotificationIntent, Intent.FLAG_ACTIVITY_NEW_TASK);

		
		/*Notification.Builder notificationBuilder = new Notification.Builder(
				context).setTicker(tickerText)
				.setSmallIcon(android.R.drawable.stat_sys_warning)
				.setAutoCancel(true).setContentTitle(contentTitle)
				.setContentText(contentText).setContentIntent(mContentIntent)
				.setVibrate(mVibratePattern);*/
		

		// Pass the Notification to the NotificationManager:
		NotificationManager mNotificationManager = (NotificationManager) context
				.getSystemService(Context.NOTIFICATION_SERVICE);
		/*mNotificationManager.notify(MY_NOTIFICATION_ID,
				notificationBuilder.build());*/
		
		//Log.i(TAG,"Sending notification at:" + DateFormat.getDateTimeInstance().format(new Date()));



	}
}
