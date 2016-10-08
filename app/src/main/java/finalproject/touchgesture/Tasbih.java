package finalproject.touchgesture;

import com.example.final_project.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Tasbih extends Activity {
	Button shake, flipp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tasbih);
		shake = (Button) findViewById(R.id.shake);
		flipp = (Button) findViewById(R.id.flipp);
		shake.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

			}
		});

		flipp.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Tasbih.this,Touch_flipp.class);
				startActivity(i);

			}
		});
		shake.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Tasbih.this,ShakeListenerTestActivity.class);
				startActivity(i);

			}
		});
	}

}
