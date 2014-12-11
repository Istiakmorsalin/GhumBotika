package ghumbotika.sleepsilent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.media.AudioManager;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class CallerException extends BroadcastReceiver {

	private Context context;
	private String PhoneNumber;
	private int ringerMode=0;
	String state=null;
	Bundle bundle=null;

	@Override
	public void onReceive(Context context, Intent intent) {
	 AudioManager maudio=(AudioManager)context.getSystemService(context.AUDIO_SERVICE);
	  bundle = intent.getExtras();
	  this.context = context;

	  if(null == bundle)
	          return;
     String [] a= {"01731923404","01685006202"};
	  state = bundle.getString(TelephonyManager.EXTRA_STATE);

	  if(state.equalsIgnoreCase(TelephonyManager.EXTRA_STATE_RINGING))
	  {
	          check();
	          PhoneNumber = bundle.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
	          PhoneNumber=PhoneNumber.substring(Math.max(0, PhoneNumber.length()-11)); 
	          Toast.makeText(context, PhoneNumber, Toast.LENGTH_LONG).show();
	          //substring( PhoneNumber.length()-11);
	        //  (Math.max(0, input.length() - 6));
	          if(PhoneNumber.equalsIgnoreCase(a[0]) || PhoneNumber.equalsIgnoreCase(a[1]) ){
	          makeitNormal();
	          maudio.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
	          }
	  }
	  if(state.equalsIgnoreCase(TelephonyManager.EXTRA_STATE_OFFHOOK))
	  {
	      makeItSilent();
	  }

	  if(state.equalsIgnoreCase(TelephonyManager.EXTRA_STATE_IDLE))
	  {
	      makeItSilent();
	  }
	}

	private void check() {
	  // TODO Auto-generated method stub
	  AudioManager maudio=(AudioManager)context.getSystemService(context.AUDIO_SERVICE);
	  ringerMode=maudio.getRingerMode();

	}

	 private void makeitNormal() {
	 // TODO Auto-generated method stub

	   AudioManager maudio=(AudioManager)context.getSystemService(context.AUDIO_SERVICE);
	   maudio.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
	 }


	 private void makeItSilent() {
	 // TODO Auto-generated method stub
	 AudioManager maudio=(AudioManager)context.getSystemService(context.AUDIO_SERVICE);
	  int ringer=maudio.getRingerMode();
	  if (ringerMode==AudioManager.RINGER_MODE_SILENT){

	  maudio.setRingerMode(AudioManager.RINGER_MODE_SILENT);

	  }else if(ringerMode==AudioManager.RINGER_MODE_NORMAL){
	  maudio.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
	 }
	 else if(ringerMode==AudioManager.RINGER_MODE_VIBRATE){
	  maudio.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
	 }

	 }

	 public void onAccuracyChanged(Sensor arg0, int arg1) {
	 // TODO Auto-generated method stub

	}

	public void onSensorChanged(SensorEvent event) {
	 // TODO Auto-generated method stub
	} 
	
}


