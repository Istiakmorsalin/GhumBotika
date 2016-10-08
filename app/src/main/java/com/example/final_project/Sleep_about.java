package com.example.final_project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;

public class Sleep_about extends Activity  {
 
	
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
        listDataHeader.add("ঘুম কি?");
        
        listDataHeader.add("ঘুমের সময় কি হয়?");
        listDataHeader.add("ঘুমের বিভিন্ন স্টেজ");
        listDataHeader.add("স্বাভাবিক ঘুমের পরিমান");
        listDataHeader.add("ঘুম জনিত রোগ সমুহ");
        listDataHeader.add("ঘুম কেন পায়  ");
        // Adding child data
        List<String> top250 = new ArrayList<String>();
        top250.add("ঘুম প্রতিটা প্রানীর জন্যেই গুরুত্বপূর্ন।" + 
                   "বিজ্ঞানিরা এখনো ঘুমের প্রক্রিয়াটা পুরোপুরি বের করতে পারেন নাই," + 
                   "কিন্তু আমরা সবাই এই প্রতিদিনের কার্যবিধি সম্পর্কে জানি। ");
       
        List<String> nowShowing = new ArrayList<String>();
        nowShowing.add("আপনি যখন  ঘুমান তখন  আপনার ব্রেইন শক্তি লাভ করে  আপনার শরিরের নষ্ট হওয়া সেল গুলো নিজে নিজে ঠিক হয় আপনার শরীর গুরুত্বপূর্ন হরমন মুক্ত করে");
        
 
        List<String> comingSoon = new ArrayList<String>();
        comingSoon.add("অ্যানাবলিক স্টেজ,আর ই এম,অ্যাবলিক স্টেজ ");
        
        List<String> newa = new ArrayList<String>();
        newa.add(" বয়স অনুপাতে আপনার ভিন্ন ধরনের ঘুম দরকার।বাচ্চাদের – ১৬ ঘন্টা	৩ থেকে ১২ বছর – ১০ ঘন্টা ১৩ থেকে ১৮ বছর – ১০ ঘন্টা ১৯ থেকে ৫৫ বছর – ৮ ঘন্টা৬৫ বছরের উপরে – ৬ ঘন্টা");
        
        List<String> newb = new ArrayList<String>();
        newb.add(" ইনসমনিয়া ঘুমের প্রধান একটা রোগ। এই রোগের রুগীরা একটানা বেশ কয়েকদিন জেগে থাকে। নিদ্রাহীনতা ঘুম জনিত আরেকটি প্রধান সমস্যা ");
        List<String> newc = new ArrayList<String>();
        newc.add("প্রতিদিন শারীরিক পরিশ্রম মানসিক চাপ থেকে মুক্তির  জন্য মানুষের মস্তিস্কের রেস্ট এর দরকার হয়।  তখনই  ঘুম আসে ");
       
        listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
        listDataChild.put(listDataHeader.get(1), nowShowing);
        listDataChild.put(listDataHeader.get(2), comingSoon);
        listDataChild.put(listDataHeader.get(3), newa);
        listDataChild.put(listDataHeader.get(4), newb);
        listDataChild.put(listDataHeader.get(5), newc);
       
    }

	
	

}
