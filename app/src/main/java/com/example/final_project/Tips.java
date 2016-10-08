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

public class Tips extends Activity {
	ExpandableListAdapter listAdapter;
	ExpandableListView expListView;
	List<String> listDataHeader;
	HashMap<String, List<String>> listDataChild;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tips);
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		// get the listview
		expListView = (ExpandableListView) findViewById(R.id.lvExp);

		// preparing list data
		prepareListData();

		listAdapter = new ExpandableListAdapter(this, listDataHeader,
				listDataChild);

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

		// Listview Group expanded listener
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
				/*Toast.makeText(getApplicationContext(),
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
		listDataHeader.add("টিপস  ১");
		listDataHeader.add("টিপস ২");
		listDataHeader.add("টিপস ৩");
		listDataHeader.add("টিপস ৪");
		listDataHeader.add("টিপস ৫");
		listDataHeader.add("টিপস ৬");
		listDataHeader.add("টিপস ৭");
		listDataHeader.add("টিপস ৮");
		listDataHeader.add("টিপস ৯");
		listDataHeader.add("টিপস ১০");
		listDataHeader.add("টিপস  ১১");
		listDataHeader.add("টিপস   ১২");
		listDataHeader.add("টিপস  ১৩ ");
		listDataHeader.add("টিপস ১৪");

		// Adding child data
		List<String> top250 = new ArrayList<String>();
		top250.add("বাইরে থেকে ফিরে গোসল সেরে নিন। সারা দিনের কান্তি এক নিমিষে চলে যাবে।");

		List<String> nowShowing = new ArrayList<String>();
		nowShowing.add("এক গ্লাস গরম দুধ খান।");

		List<String> comingSoon = new ArrayList<String>();
		comingSoon.add("ঘুমোতে যাওয়ার বেশ কিছুক্ষণ আগে টিভি, কম্পিউটার বন্ধ করুন।");

		List<String> four = new ArrayList<String>();
		four.add("পরের দিনের কাজের পরিকল্পনা আগেই করে ফেলুন, টেনশনে ঘুম নষ্ট হবে না।");

		List<String> five = new ArrayList<String>();
		five.add("বিছানায় যাওয়ার অনেক আগেই রাতের খাবার খেয়ে নিন।");
		List<String> six = new ArrayList<String>();
		six.add("চেষ্টা করুন দুশ্চিন্তা না করার ।");
		List<String> seven = new ArrayList<String>();
		seven.add("শোবার ঘরটি অযথা একগাদা জিনিস দিয়ে ভরে রাখবেন না।");
		List<String> eight = new ArrayList<String>();
		eight.add("রাত ১০টা / ১১টার মধ্যেই ঘুমোতে যান। এ সময় বিছানায় গেলে ভালো ঘুম হওয়ার সম্ভাবনা বেশি থাকে।");
		List<String> nine = new ArrayList<String>();
		nine.add("পারলে সন্ধ্যার পরই চা-কফি খাওয়া বন্ধ করে দিন।");
		List<String> ten = new ArrayList<String>();
		ten.add("সফট্ মিউজিক শুনুন।");
		List<String> eleven = new ArrayList<String>();
		eleven.add("টেনশন হালকা করার মত বই  পড়ুন ");
		List<String> twelve = new ArrayList<String>();
		twelve.add("সুখময় স্মৃতি মনে করার চেষ্টা করুন ।");
		List<String> thirteen = new ArrayList<String>();
		thirteen.add("প্রিয়জনের কথা চিন্তা করুন ");
		List<String> fourteen = new ArrayList<String>();
		fourteen.add("ঘুমের ওষুধ খান ");

		listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
		listDataChild.put(listDataHeader.get(1), nowShowing);
		listDataChild.put(listDataHeader.get(2), comingSoon);
		listDataChild.put(listDataHeader.get(3), four);
		listDataChild.put(listDataHeader.get(4), five);
		listDataChild.put(listDataHeader.get(5), six);
		listDataChild.put(listDataHeader.get(6), seven);
		listDataChild.put(listDataHeader.get(7), eight);
		listDataChild.put(listDataHeader.get(8), nine);
		listDataChild.put(listDataHeader.get(9), ten);
		listDataChild.put(listDataHeader.get(10), eleven);
		listDataChild.put(listDataHeader.get(11), twelve);
		listDataChild.put(listDataHeader.get(12), thirteen);
		listDataChild.put(listDataHeader.get(13), fourteen);
	}

}
