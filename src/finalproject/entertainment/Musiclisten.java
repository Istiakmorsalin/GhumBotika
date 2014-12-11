package finalproject.entertainment;

import java.io.IOException;

import com.example.final_project.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class Musiclisten extends Activity {
	ImageView imgs;
	 @Override
		protected void onActivityResult(int requestCode, int resultCode, Intent data) {
			// TODO Auto-generated method stub

      if(requestCode == RESULT_OK && requestCode == 10){
            Uri uriSound=data.getData();
            play(this, uriSound); 
      }
			
		}
	    

	private void play(Context context, Uri uri) {
		// TODO Auto-generated method stub
		try {
         MediaPlayer mp = new MediaPlayer();
         mp.setDataSource(context, uri);         
         mp.start();
       } catch (IllegalArgumentException e) {
       // TODO Auto-generated catch block
          e.printStackTrace();
       } catch (SecurityException e) {
       // TODO Auto-generated catch block
          e.printStackTrace();
       } catch (IllegalStateException e) {
       // TODO Auto-generated catch block
          e.printStackTrace();
       } catch (IOException e) {
       // TODO Auto-generated catch block
          e.printStackTrace();
       }
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.music);
		imgs = (ImageView) this.findViewById(R.id.imageView1);
	    imgs.setOnClickListener(new OnClickListener() {

	        @Override
	        public void onClick(View v) {
	           Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
	                startActivityForResult(intent, 10);
	        }
	    }); 
	    
	}

}
