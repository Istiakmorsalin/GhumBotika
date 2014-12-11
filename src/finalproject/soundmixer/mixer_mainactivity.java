package finalproject.soundmixer;
import com.example.final_project.R;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.HashMap;
import android.R.string;
import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class mixer_mainactivity extends Activity {

	public static final String OVI = null;
	MyCustomAdapter dataAdapter = null;
	private SeekBar volumeSeekbar = null;
	private AudioManager audioManager = null;
	SoundPool soundPool;

	int[] stop_id = new int[51];
	int[] a = new int[51];

	/*
	 * ,relax,monkchant,rain,creek,atmosphere,camphire,
	 * drum,erhu,thunder,heavyrain,guitar,dream,whalesong,cricket,frogs,piano,
	 * heartbeat
	 * ,whitenoise,storm,vacuumcleaner,airconditioer,watercrickets,seagulls
	 * ,catpurr,
	 * aquarium,coldwind,city,musicbox,noise,jinglebells,watermusic,cicada
	 * ,waterdripping,dishwasher,
	 * refrigerator,largefan,smallclock,chair,coqui,loons
	 * ,wolves,horse,foghorn,nature, stopwatch,owl;
	 */

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_soundmixer);
		setVolumeControlStream(AudioManager.STREAM_MUSIC);

		soundPool = new SoundPool(51, AudioManager.STREAM_MUSIC, 0);

		a[0] = soundPool.load(this, R.raw.ocean, 1);
		a[1] = soundPool.load(this, R.raw.birds, 1);
		a[2] = soundPool.load(this, R.raw.train, 1);
		a[3] = soundPool.load(this, R.raw.basstone, 1);
		a[4] = soundPool.load(this, R.raw.beach, 1);
		a[5] = soundPool.load(this, R.raw.relax, 1);
	
		
		a[6] = soundPool.load(this, R.raw.monkchant, 1);
		a[7] = soundPool.load(this, R.raw.rain, 1);
		a[8] = soundPool.load(this, R.raw.creek, 1);
		a[9] = soundPool.load(this, R.raw.athmospheric, 1);
		a[10] = soundPool.load(this, R.raw.campfire, 1);
		a[11] = soundPool.load(this, R.raw.drum, 1);
		a[12] = soundPool.load(this, R.raw.erhu, 1);
		a[13] = soundPool.load(this, R.raw.thunder, 1);
		a[14] = soundPool.load(this, R.raw.heavyrain, 1);
		

		// Generate list View from ArrayList
		
		
		a[15] = soundPool.load(this, R.raw.guitarsolo, 1);
		a[16] = soundPool.load(this, R.raw.dream, 1);
		a[17] = soundPool.load(this, R.raw.whalesong, 1);
		a[18] = soundPool.load(this, R.raw.cricket, 1);
		a[19] = soundPool.load(this, R.raw.frogs, 1);
		a[20] = soundPool.load(this, R.raw.piano, 1);
		a[21] = soundPool.load(this, R.raw.heartbeat, 1);
		a[22] = soundPool.load(this, R.raw.white, 1);
		a[23] = soundPool.load(this, R.raw.storm, 1);
		a[24] = soundPool.load(this, R.raw.vacuum, 1);
		a[25] = soundPool.load(this, R.raw.airconditioner, 1);
		a[26] = soundPool.load(this, R.raw.watercrickets, 1);
		a[27] = soundPool.load(this, R.raw.seagull, 1);
		a[28] = soundPool.load(this, R.raw.catpurr, 1);
		a[29] = soundPool.load(this, R.raw.aquarium, 1);
		a[30] = soundPool.load(this, R.raw.coldwind, 1);
		a[31] = soundPool.load(this, R.raw.city, 1);
		a[32] = soundPool.load(this, R.raw.musicbox, 1);
		a[33] = soundPool.load(this, R.raw.noise, 1);
		a[34] = soundPool.load(this, R.raw.jinglebells, 1);
		a[35] = soundPool.load(this, R.raw.watermusic, 1);
		a[36] = soundPool.load(this, R.raw.cicada, 1);
		a[37] = soundPool.load(this, R.raw.waterdripping, 1);
		a[38] = soundPool.load(this, R.raw.dishwasher, 1);
		a[39] = soundPool.load(this, R.raw.refrigerator, 1);
		a[40] = soundPool.load(this, R.raw.largefan, 1);
		a[41] = soundPool.load(this, R.raw.smallclock, 1);
		a[42] = soundPool.load(this, R.raw.chair, 1);
		a[43] = soundPool.load(this, R.raw.coqui, 1);
		a[44] = soundPool.load(this, R.raw.loons, 1);
		a[45] = soundPool.load(this, R.raw.wolves, 1);
		a[46] = soundPool.load(this, R.raw.horse, 1);
		a[47] = soundPool.load(this, R.raw.foghorn, 1);
		a[48] = soundPool.load(this, R.raw.nature, 1);
		a[49] = soundPool.load(this, R.raw.stopwatch, 1);
		a[50] = soundPool.load(this, R.raw.owl, 1);
		displayListView();
	}

	private void displayListView() {

		// Array list of countries
		ArrayList<States> stateList = new ArrayList<States>();

		HashMap initiate = demo();
		for (int i = 0; i < initiate.size(); i++) {
			
			States _states = new States((String) initiate.get(i), false);
			stateList.add(_states);

		}

		// create an ArrayAdaptar from the String Array
		dataAdapter = new MyCustomAdapter(this, R.layout.state_info, stateList,
				a);
		ListView listView = (ListView) findViewById(R.id.listView1);
		// Assign adapter to ListView
		listView.setAdapter(dataAdapter);

		listView.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// When clicked, show a toast with the TextView text
				States state = (States) parent.getItemAtPosition(position);

				Toast.makeText(getApplicationContext(),
						"Clicked on : " + state.getName(), Toast.LENGTH_LONG)
						.show();
			}
		});
	}

	private HashMap demo() {
		// TODO Auto-generated method stub
		HashMap soundPoolMap = new HashMap();
		soundPoolMap.put(Integer.valueOf(0), "OCEAN");
		soundPoolMap.put(Integer.valueOf(1), "BIRDS");
		soundPoolMap.put(Integer.valueOf(2), "TRAIN");
		soundPoolMap.put(Integer.valueOf(3), "BASSTONE");
		soundPoolMap.put(Integer.valueOf(4), "BEACH");
		soundPoolMap.put(Integer.valueOf(5), "RELAX");
		soundPoolMap.put(Integer.valueOf(6), "MONKCHANT");
		soundPoolMap.put(Integer.valueOf(7), "RAIN");
		soundPoolMap.put(Integer.valueOf(8), "CREEK");
		soundPoolMap.put(Integer.valueOf(9), "ATHMOSPHERE");
		soundPoolMap.put(Integer.valueOf(10), "CAMPFIRE");
		soundPoolMap.put(Integer.valueOf(11), "DRUM");
		soundPoolMap.put(Integer.valueOf(12), "ERHU");
		soundPoolMap.put(Integer.valueOf(13), "THUNDER");
		soundPoolMap.put(Integer.valueOf(14), "HEAVYRAIN");
		soundPoolMap.put(Integer.valueOf(15), "GUITAR");
		soundPoolMap.put(Integer.valueOf(16), "DREAM");
		soundPoolMap.put(Integer.valueOf(17), "WHALESONG");
		soundPoolMap.put(Integer.valueOf(18), "CRICKET");
		soundPoolMap.put(Integer.valueOf(19), "FROGS");
		soundPoolMap.put(Integer.valueOf(20), "PIANO");
		soundPoolMap.put(Integer.valueOf(21), "HEARTBEAT");
		  soundPoolMap.put(Integer.valueOf(22), "WHITENOISE");
		  soundPoolMap.put(Integer.valueOf(23), "STORM");
		  soundPoolMap.put(Integer.valueOf(24), "VACUUMCLEANER");
		  soundPoolMap.put(Integer.valueOf(25), "AIRCONDITIONER");
		  soundPoolMap.put(Integer.valueOf(26), "WATERCRICKETS");
		  soundPoolMap.put(Integer.valueOf(27), "SEAGULL");
		  soundPoolMap.put(Integer.valueOf(28), "CATPURR");
		  soundPoolMap.put(Integer.valueOf(29), "AQUARIUM");
		  soundPoolMap.put(Integer.valueOf(30), "COLDWIND");
		  soundPoolMap.put(Integer.valueOf(31), "CITY");
		  soundPoolMap.put(Integer.valueOf(32), "MUSICBOX");
		  soundPoolMap.put(Integer.valueOf(33), "NOISE");
		  soundPoolMap.put(Integer.valueOf(34), "JINGLEBELLS");
		  soundPoolMap.put(Integer.valueOf(35), "WATERMUSIC");
		  soundPoolMap.put(Integer.valueOf(36), "CICADA");
		  soundPoolMap.put(Integer.valueOf(37), "WATERDRIPPING");
		  soundPoolMap.put(Integer.valueOf(38), "DISHWASHER");
		  soundPoolMap.put(Integer.valueOf(39), "REFRIGERATOR");
		  soundPoolMap.put(Integer.valueOf(40), "LARGEFAN");
		  soundPoolMap.put(Integer.valueOf(41), "SMALLCLOCK");
		  soundPoolMap.put(Integer.valueOf(42), "CHAIR");
		  soundPoolMap.put(Integer.valueOf(43), "COQUI");
		  soundPoolMap.put(Integer.valueOf(44), "LOONS");
		  soundPoolMap.put(Integer.valueOf(45), "WOLVES");
		  soundPoolMap.put(Integer.valueOf(46), "HORSE");
		  soundPoolMap.put(Integer.valueOf(47), "FOGHORN");
		  soundPoolMap.put(Integer.valueOf(48), "NATURE");
		  soundPoolMap.put(Integer.valueOf(49), "STOPWATCH");
		  soundPoolMap.put(Integer.valueOf(50), "OWL"); 
		return soundPoolMap;
	}

	private class MyCustomAdapter extends ArrayAdapter<States> {

		private ArrayList<States> stateList;
		protected int[] a;

		public MyCustomAdapter(Context context, int textViewResourceId,

		ArrayList<States> stateList, int[] a) {
			super(context, textViewResourceId, stateList);
			this.stateList = new ArrayList<States>();
			this.stateList.addAll(stateList);
			this.a = a;
		}

		private class ViewHolder {
			TextView code;
			CheckBox name;
			SeekBar seek;
		}

		@Override
		public View getView(final int position, View convertView,
				ViewGroup parent) {

			final ViewHolder holder;

			Log.v("ConvertView", String.valueOf(position));

			if (true) {

				LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

				convertView = vi.inflate(R.layout.state_info, null);

				holder = new ViewHolder();
				holder.code = (TextView) convertView
						.findViewById(R.id.sound_text);
				holder.name = (CheckBox) convertView
						.findViewById(R.id.sound_check);

				convertView.setTag(holder);

				try {

					holder.name.setTag(position);

					States state = stateList.get(position);

					holder.name.setText(state.getName());
					holder.name.setChecked(state.isSelected());

					holder.name
							.setOnCheckedChangeListener(new OnCheckedChangeListener() {

								public void onCheckedChanged(
										CompoundButton button, boolean chk) {
									// TODO Auto-generated method stub
									// States state = (States)
									// holder.name.getTag();
									// state.setSelected(chk);

									int position = Integer.parseInt(button
											.getTag().toString());
									States state = stateList.get(position);
									state.setSelected(chk);
									if (chk) {

										// int soundId =
										// soundPool.load(MainActivity.this,
										// sounds[position], 1);

										try {

											// soundPool.stop(stop_id[position]);
										} catch (Exception e) {
										}
										int b = soundPool.play(a[position], 1,
												1, 0, -1, 1);
										stop_id[position] = b;

									}

									else
										soundPool.stop(stop_id[position]);

								}

							});
				} catch (Exception e) {
				}
			} else {
				holder = (ViewHolder) convertView.getTag();
			}

			// holder.name.setTag(state);

			return convertView;

		}

		private void initControls() {
			try {

				audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
				volumeSeekbar.setMax(audioManager
						.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
				volumeSeekbar.setProgress(audioManager
						.getStreamVolume(AudioManager.STREAM_MUSIC));

				volumeSeekbar
						.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
							@Override
							public void onStopTrackingTouch(SeekBar arg0) {
							}

							@Override
							public void onStartTrackingTouch(SeekBar arg0) {
							}

							@Override
							public void onProgressChanged(SeekBar arg0,
									int progress, boolean arg2) {
								audioManager.setStreamVolume(
										AudioManager.STREAM_MUSIC, progress, 0);
							}
						});
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		
		/* * private HashMap demo(){ HashMap soundPoolMap = new HashMap();
		 * soundPoolMap.put(Integer.valueOf(0), "OCEAN");
		 * soundPoolMap.put(Integer.valueOf(1), "BIRDS");
		 * soundPoolMap.put(Integer.valueOf(2), "TRAIN");
		 * soundPoolMap.put(Integer.valueOf(3), "BASSTONE");
		 * soundPoolMap.put(Integer.valueOf(4), "BEACH");
		 * soundPoolMap.put(Integer.valueOf(5), "RELAX");
		 * soundPoolMap.put(Integer.valueOf(6), "MONKCHANT");
		 * soundPoolMap.put(Integer.valueOf(7), "RAIN");
		 * soundPoolMap.put(Integer.valueOf(8), "CREEK");
		 * soundPoolMap.put(Integer.valueOf(9), "ATHMOSPHERE");
		 * soundPoolMap.put(Integer.valueOf(10), "CAMPFIRE");
		 * soundPoolMap.put(Integer.valueOf(11), "DRUM");
		 * soundPoolMap.put(Integer.valueOf(12), "ERHU");
		 * soundPoolMap.put(Integer.valueOf(13), "THUNDER");
		 * soundPoolMap.put(Integer.valueOf(14), "HEAVYRAIN");
		 * soundPoolMap.put(Integer.valueOf(15), "GUITAR");
		 * soundPoolMap.put(Integer.valueOf(16), "DREAM");
		 * soundPoolMap.put(Integer.valueOf(17), "WHALESONG");
		 * soundPoolMap.put(Integer.valueOf(18), "CRICKET");
		 * soundPoolMap.put(Integer.valueOf(19), "FROGS");
		 * soundPoolMap.put(Integer.valueOf(20), "PIANO");
		 * soundPoolMap.put(Integer.valueOf(21), "HEARTBEAT");
		 * soundPoolMap.put(Integer.valueOf(22), "WHITENOISE");
		 * soundPoolMap.put(Integer.valueOf(23), "STORM");
		 * soundPoolMap.put(Integer.valueOf(24), "VACUUMCLEANER");
		 * soundPoolMap.put(Integer.valueOf(25), "AIRCONDITIONER");
		 * soundPoolMap.put(Integer.valueOf(26), "WATERCRICKETS");
		 * soundPoolMap.put(Integer.valueOf(27), "SEAGULL");
		 * soundPoolMap.put(Integer.valueOf(28), "CATPURR");
		 * soundPoolMap.put(Integer.valueOf(29), "AQUARIUM");
		 * soundPoolMap.put(Integer.valueOf(30), "COLDWIND");
		 * soundPoolMap.put(Integer.valueOf(31), "CITY");
		 * soundPoolMap.put(Integer.valueOf(32), "MUSICBOX");
		 * soundPoolMap.put(Integer.valueOf(33), "NOISE");
		 * soundPoolMap.put(Integer.valueOf(34), "JINGLEBELLS");
		 * soundPoolMap.put(Integer.valueOf(35), "WATERMUSIC");
		 * soundPoolMap.put(Integer.valueOf(36), "CICADA");
		 * soundPoolMap.put(Integer.valueOf(37), "WATERDRIPPING");
		 * soundPoolMap.put(Integer.valueOf(38), "DISHWASHER");
		 * soundPoolMap.put(Integer.valueOf(39), "REFRIGERATOR");
		 * soundPoolMap.put(Integer.valueOf(40), "LARGEFAN");
		 * soundPoolMap.put(Integer.valueOf(41), "SMALLCLOCK");
		 * soundPoolMap.put(Integer.valueOf(42), "CHAIR");
		 * soundPoolMap.put(Integer.valueOf(43), "COQUI");
		 * soundPoolMap.put(Integer.valueOf(44), "LOONS");
		 * soundPoolMap.put(Integer.valueOf(45), "WOLVES");
		 * soundPoolMap.put(Integer.valueOf(46), "HORSE");
		 * soundPoolMap.put(Integer.valueOf(47), "FOGHORN");
		 * soundPoolMap.put(Integer.valueOf(48), "NATURE");
		 * soundPoolMap.put(Integer.valueOf(49), "STOPWATCH");
		 * soundPoolMap.put(Integer.valueOf(50), "OWL"); return soundPoolMap; }*/
		
		
		 

	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		for (int i = 0; i < a.length; i++) {
			soundPool.stop(stop_id[i]);
		}
	}
	
}
