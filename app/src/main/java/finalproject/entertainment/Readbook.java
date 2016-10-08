package finalproject.entertainment;

import java.io.File;
import java.io.FilenameFilter;
import java.util.List;

import com.example.final_project.R;



import android.app.Activity;
import android.app.ListActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;

import android.widget.ListView;

public class Readbook extends Activity {

	String[] pdflist;
	File[] imagelist;
	private MediaPlayer mPlayer;
	 private int mStartID;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 setContentView(R.layout.book);
		/* mPlayer = MediaPlayer.create(this,R.raw.musicbox);

			if (null != mPlayer) {

				mPlayer.setLooping(true);
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

				}*/
		File images = Environment.getExternalStorageDirectory();
		imagelist = images.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return ((name.endsWith(".pdf")));
			}
		});
		pdflist = new String[imagelist.length];
		for (int i = 0; i < imagelist.length; i++) {
			pdflist[i] = imagelist[i].getName();
		}
		ListView v=(ListView)findViewById(R.id.listView1);
		v.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, pdflist));
		v.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				String path = imagelist[(int)arg3].getAbsolutePath();
				Log.d("path",path);
				openPdfIntent(path);				
			}
		});
	}
	
	
	/*
	=new onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		String path = imagelist[(int) id].getAbsolutePath();
		openPdfIntent(path);
	}*/

	/*@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		if (null != mPlayer) {

			mPlayer.stop();
			mPlayer.release();

		}*/
	
	
	private void openPdfIntent(String path) {
		Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(path));
		
		intent.setType("application/pdf");
		intent.setDataAndType(Uri.parse(path),"application/pdf");
		PackageManager pm = getPackageManager();
		List<ResolveInfo> activities = pm.queryIntentActivities(intent, 0);
		if (activities.size() > 0) {
		    startActivity(intent);
		//} else {
		    // Do something else here. Maybe pop up a Dialog or Toast
		//}
	}
}
}