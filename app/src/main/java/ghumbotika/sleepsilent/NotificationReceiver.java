package ghumbotika.sleepsilent;

import java.text.DateFormat;
import java.util.Date;

import com.example.final_project.R;


import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.net.Uri;
import android.util.Log;

@SuppressLint("NewApi")
public class NotificationReceiver extends BroadcastReceiver {
	private static final int MY_NOTIFICATION_ID = 1;
	private static final String TAG = "AlarmNotificationReceiver";
	
	private final CharSequence tickerText = "এখন আপনার ঘুমাতে যাওয়ার সময়";
	private final CharSequence contentTitle = "এখন আপনার ঘুমাতে যাওয়ার সময়";
	private final CharSequence contentText = "এখন আপনার ঘুমাতে যাওয়ার সময়!";
	AudioManager mode;
	
	// Notification Action Elements
	private Intent mNotificationIntent;
	private PendingIntent mContentIntent;
	private Uri soundURI = Uri
			.parse("android.resource://com.example.final_project/"
					+ R.raw.notify);
	private long[] mVibratePattern = { 0, 200, 200, 300 };
	
	
	
	@SuppressLint("NewApi")
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		mNotificationIntent = new Intent(context, AlarmCreateActivity.class);
		mContentIntent = PendingIntent.getActivity(context, 0,
				mNotificationIntent, Intent.FLAG_ACTIVITY_NEW_TASK);

		Notification.Builder notificationBuilder = new Notification.Builder(
				context).setTicker(tickerText)
				.setSmallIcon(android.R.drawable.stat_sys_warning)
				.setAutoCancel(true).setContentTitle(contentTitle)
				.setContentText(contentText).setContentIntent(mContentIntent)
				.setSound(soundURI).setVibrate(mVibratePattern);

		 
		NotificationManager mNotificationManager = (NotificationManager) context
				.getSystemService(Context.NOTIFICATION_SERVICE);
		mNotificationManager.notify(MY_NOTIFICATION_ID,
				notificationBuilder.build());
		
		Log.i(TAG,"Sending notification at:" + DateFormat.getDateTimeInstance().format(new Date()));
	}

}
