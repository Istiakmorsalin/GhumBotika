package finalproject.touchgesture;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.final_project.ExpandableListAdapter;
import com.example.final_project.R;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;

public class dualist extends Activity {

	ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sleepabout);
		 this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		 
		 expListView = (ExpandableListView) findViewById(R.id.lvExp);
		 
	        // preparing list data
	        prepareListData();
	 
	        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
	 
	        // setting list adapter
	        expListView.setAdapter(listAdapter);
	        expListView.setOnGroupClickListener(new OnGroupClickListener() {
	        	 
	            @Override
	            public boolean onGroupClick(ExpandableListView parent, View v,
	                    int groupPosition, long id) {
	                // Toast.makeText(getApplicationContext(),
	                // "Group Clicked " + listDataHeader.get(groupPosition),
	                // Toast.LENGTH_SHORT).show();
	                return false;
	            }
	        });
	        expListView.setOnGroupExpandListener(new OnGroupExpandListener() {
	        	 
	            @Override
	            public void onGroupExpand(int groupPosition) {
	                /*Toast.makeText(getApplicationContext(),
	                        listDataHeader.get(groupPosition) + " Expanded",
	                        Toast.LENGTH_SHORT).show();*/
	            }
	        });
	 
	        // Listview Group collasped listener
	        expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {
	 
	            @Override
	            public void onGroupCollapse(int groupPosition) {
	               /* Toast.makeText(getApplicationContext(),
	                        listDataHeader.get(groupPosition) + " Collapsed",
	                        Toast.LENGTH_SHORT).show();*/
	 
	            }
	        });
	 
	        // Listview on child click listener
	        expListView.setOnChildClickListener(new OnChildClickListener() {
	 
	            @Override
	            public boolean onChildClick(ExpandableListView parent, View v,
	                    int groupPosition, int childPosition, long id) {
	                // TODO Auto-generated method stub
	                Toast.makeText(
	                        getApplicationContext(),
	                        listDataHeader.get(groupPosition)
	                                + " : "
	                                + listDataChild.get(
	                                        listDataHeader.get(groupPosition)).get(
	                                        childPosition), Toast.LENGTH_SHORT)
	                        .show();
	                return false;
	            }
	        });
	}
	private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();
 
        // Adding child data
        listDataHeader.add("ঘুমাতে যাওয়ার সময় দোয়া");
        
        listDataHeader.add("ঘুম থেকে উঠার পরে দোয়া");
        listDataHeader.add("মাতা-পিতার জন্য সন্তানের দোয়া");
        listDataHeader.add("গুনাহ্‌ মাফের দোয়া");
        listDataHeader.add("ক্ষমা ও রহমতের দোয়া");
        listDataHeader.add("অস্থিরতায় পাঠ করার দোয়া  ");
        // Adding child data
        List<String> top250 = new ArrayList<String>();
        top250.add("আসতাগফিরুল লাহাল লাজি লা ইলাহা ইল্লা হুয়াল হাই'য়ুল কাই'ইয়ু'মু ওয়া আতুবু ইলাহ");
        		
       
        List<String> nowShowing = new ArrayList<String>();
        nowShowing.add("আলহামদুলিল্লাহিল লাজি আহইয়া নাফছি বা'দা মা আমাতাহা ওয়া ইলাইহিন নুশুর");
        
 
        List<String> comingSoon = new ArrayList<String>();
        comingSoon.add("রাব্বির হামহুমা কামা রাব্বা ঈয়ানী সাগিরা। (সূরা বণী ইসরাইল, আয়াতঃ ২৩-২৫) ");
        
        List<String> newa = new ArrayList<String>();
        newa.add(" রাব্বানা ফাগফিরলানা যুনুবানা ওয়া কাফফির আন্না সাইয়্যিআতিনা ওয়া তাওয়াফ্‌ফানা মায়াল আবরার। (সূরা আল ইমরান, আয়াতঃ ১৯৩)");
        
        List<String> newb = new ArrayList<String>();
        newb.add(" রাব্বিগ ফির ওয়ারহাম ওয়া আনতা খাইরুর রাহিমীন। ");
        List<String> newc = new ArrayList<String>();
        newc.add("আল্লাহু ইয়া হাইয়্যু ইয়া কাইয়্যুমু বিরাহমাতিকা আসতাগীছু ");
       
        listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
        listDataChild.put(listDataHeader.get(1), nowShowing);
        listDataChild.put(listDataHeader.get(2), comingSoon);
        listDataChild.put(listDataHeader.get(3), newa);
        listDataChild.put(listDataHeader.get(4), newb);
        listDataChild.put(listDataHeader.get(5), newc);
       
    }

	
	

}
