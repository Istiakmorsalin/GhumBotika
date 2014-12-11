package finalproject.entertainment;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.example.final_project.R;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.MediaColumns;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class viewimage extends Activity {
    
	ImageView img,img1;
	int column_index;
	 private MediaPlayer mPlayer;
	 private int mStartID;
	  Intent intent=null;
	  Button bt;
	// Declare our Views, so we can access them later
	String logo,imagePath,Logo;
	Cursor cursor;
	//YOU CAN EDIT THIS TO WHATEVER YOU WANT
	private static final int SELECT_PICTURE = 1;

	 String selectedImagePath;
	//ADDED
	 String filemanagerstring;
	 @Override
		public void onActivityResult(int requestCode, int resultCode, Intent data) {
		    if (resultCode == Activity.RESULT_OK) {
		        if (requestCode == SELECT_PICTURE) {
		            Uri selectedImageUri = data.getData();

		            //OI FILE Manager
		            filemanagerstring = selectedImageUri.getPath();

		            //MEDIA GALLERY
		            selectedImagePath = getPath(selectedImageUri);


		            img.setImageURI(selectedImageUri);

		           imagePath.getBytes();
		           


		           Bitmap bm = BitmapFactory.decodeFile(imagePath);

		          // img1.setImageBitmap(bm);



		        }

		    }

		}
	 public String getPath(Uri uri) {
			String[] projection = { MediaColumns.DATA };
			Cursor cursor = managedQuery(uri, projection, null, null, null);
			column_index = cursor
			        .getColumnIndexOrThrow(MediaColumns.DATA);
			cursor.moveToFirst();
			 imagePath = cursor.getString(column_index);

			return cursor.getString(column_index);
			}


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.image);
		img= (ImageView)findViewById(R.id.gimg1);
		  img1=  (ImageView) findViewById(R.id.imageView1);
		 
			
				
		img1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				 Intent intent = new Intent();
		            intent.setType("image/*");
		            intent.setAction(Intent.ACTION_GET_CONTENT);
		            startActivityForResult(Intent.createChooser(intent,
		                    "Select Picture"), SELECT_PICTURE);
			}
		});
	}

	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	/*	if (null != mPlayer) {

			mPlayer.stop();
			mPlayer.release();

		}*/
	}
}
