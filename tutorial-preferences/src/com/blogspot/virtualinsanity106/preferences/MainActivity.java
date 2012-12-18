package com.blogspot.virtualinsanity106.preferences;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;

public class MainActivity extends Activity {
	private static final String TAG = "MainActivity";
	private TextView txtDisplayEditText;
	private TextView txtDisplayCheck;
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		loadPreferences(); //when the SetPreferencesActivity ends, reload preferences when properties activity close
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);//set the content from main.xml
		txtDisplayEditText = (TextView) findViewById(R.id.textview_edittext);
		txtDisplayCheck = (TextView) findViewById(R.id.textview_checkbox);
		loadPreferences();//load the edited preferences
	}
	
	public void onEditClick(View v){
		//open the properties activity
		Log.d(TAG, "Start edit");
    	Intent intent = new Intent();
        intent.setClass(MainActivity.this, SetPreferencesActivity.class);
        startActivityForResult(intent, 0); 
	}
	private void loadPreferences(){
		SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this); //load the preferences
		txtDisplayEditText.setText(sharedPreferences.getString("edittext_preference", getString(R.string.edittext_default_text))); //by default show the edittext_default_text string
		boolean isCheckboxSelected = sharedPreferences.getBoolean("checkbox_preference", false);//by default the checkbox isn't selected
		if(isCheckboxSelected)//if the checkbox is selected, show the "checkbox_true" string, otherwise show the "checkbox_false" string
			txtDisplayCheck.setText(getString(R.string.checkbox_true));
		else
			txtDisplayCheck.setText(getString(R.string.checkbox_false));
	}
}
