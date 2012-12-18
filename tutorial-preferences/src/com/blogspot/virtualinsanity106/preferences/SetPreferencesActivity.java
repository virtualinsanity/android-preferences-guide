package com.blogspot.virtualinsanity106.preferences;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class SetPreferencesActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setpreferences);
	}
	public void onBackClick(View v){
		setResult(RESULT_OK);
		finish();
	}
}
