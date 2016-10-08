package finalproject.touchgesture;
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

public class Touch_flipp extends Activity {

	private ViewFlipper mFlipper;
 public TextView mTextView1, mTextView2,tv;
	private int mCurrentLayoutState, mCount = 0;
	private GestureDetector mGestureDetector;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		mCurrentLayoutState = 0;

		mFlipper = (ViewFlipper) findViewById(R.id.view_flipper);
		mTextView1 = (TextView) findViewById(R.id.textView1);
		mTextView2 = (TextView) findViewById(R.id.textView2);
		
		mTextView1.setText(String.valueOf(mCount));
		mGestureDetector = new GestureDetector(this,
				new GestureDetector.SimpleOnGestureListener() {
					@Override
					public boolean onFling(MotionEvent e1, MotionEvent e2,
							float velocityX, float velocityY) {
						if (velocityX < -10.0f) {
							mCurrentLayoutState = mCurrentLayoutState == 0 ? 1
									: 0;
							switchLayoutStateTo(mCurrentLayoutState);
						}
						return true;
					}
				});

	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		return mGestureDetector.onTouchEvent(event);
	}

	public void switchLayoutStateTo(int switchTo) {
		mCurrentLayoutState = switchTo;

		mFlipper.setInAnimation(inFromRightAnimation());
		mFlipper.setOutAnimation(outToLeftAnimation());

		mCount++;
		if (mCount == 100) {

			mCount = 0;
		}
		/*if(mCount<=33){
		//	Toast.makeText(getApplicationContext(), "সুবানাল্লাহ", Toast.LENGTH_SHORT).show();
			tv.setText("বলুন  সুবানাল্লাহ");
		}
		if (mCount>33 && mCount<=64) {
			//Toast.makeText(getApplicationContext(), "আলহামদুলিল্লাহ", Toast.LENGTH_SHORT).show();
			tv.setText("বলুন আলহামদুলিল্লাহ");
			
		}
		if (mCount>64 ) {
			//Toast.makeText(getApplicationContext(), "লা ইলাহা ইল্লালাহ ", Toast.LENGTH_SHORT).show();
			tv.setText("বলুন  লা ইলাহা ইল্লালাহ");
			
		}*/
		

		if (switchTo == 0) {
			mTextView1.setText(String.valueOf(mCount));
		} else {
			mTextView2.setText(String.valueOf(mCount));
		}

		mFlipper.showPrevious();
	}

	private Animation inFromRightAnimation() {
		Animation inFromRight = new TranslateAnimation(
				Animation.RELATIVE_TO_PARENT, +1.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f);
		inFromRight.setDuration(500);
		inFromRight.setInterpolator(new LinearInterpolator());
		return inFromRight;
	}

	private Animation outToLeftAnimation() {
		Animation outtoLeft = new TranslateAnimation(
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, -1.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f);
		outtoLeft.setDuration(500);
		outtoLeft.setInterpolator(new LinearInterpolator());
		return outtoLeft;
	}
}
