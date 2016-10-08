package ghumbotika.sleepsilent;

import java.text.DateFormat;
import java.util.Date;

import com.example.final_project.R;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.util.Log;

public class AlarmLoggerReceiver extends BroadcastReceiver {
	
	private static final String TAG = "AlarmLoggerReceiver";
	AudioManager mode;
	AlarmManager alarm;
	
	@Override
	public void onReceive(Context context, Intent intent) {
		mode=  (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
		mode.setRingerMode(AudioManager.RINGER_MODE_NORMAL); 
		
		
		Log.i(TAG,"Logging alarm at:" + DateFormat.getDateTimeInstance().format(new Date()));
        
		alarm=(AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
		MediaPlayer mPlayer = MediaPlayer.create(context, R.raw.alarm_rooster);
		mPlayer.start();
		
		if (null != mPlayer) {

			mPlayer.setLooping(false);
		}
		
		if (null != mPlayer) {

			// ID for this start command
			//mStartID = startid;

			if (mPlayer.isPlaying()) {

				// Rewind to beginning of song
				mPlayer.seekTo(0);

			} else {

				// Start playing song
				mPlayer.start();

			}
		
	}
	
	
	}
}
