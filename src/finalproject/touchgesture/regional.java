package finalproject.touchgesture;

import com.example.final_project.R;

import finalproject.entertainment.viewimage;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class regional extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.regionactivity);
		Button bt1= (Button) findViewById(R.id.dualist);
		Button bt2= (Button) findViewById(R.id.tosbih);
		
		bt1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			 
				Intent i = new Intent(regional.this,dualist.class);
				startActivity(i);
			}
		});
       bt2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			 
				Intent i = new Intent(regional.this,Tasbih.class);
				startActivity(i);
			}
		});
	}
	

}
