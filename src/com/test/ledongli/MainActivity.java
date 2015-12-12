package com.test.ledongli;

import com.test.ledongli.myview.FirstScreen;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {
	
	FirstScreen first_screen=null;
	RelativeLayout main_layout=null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		main_layout=(RelativeLayout) findViewById(R.id.main_layout);		
	}

	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		addAniView();
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		//由于onLayout中会产生重影，所以在不可见的时候将所有视图清除
		main_layout.removeAllViews();
	}
	
	public void addAniView() {
		first_screen=new FirstScreen(MainActivity.this);		
		main_layout.addView(first_screen);
	}
	
}
