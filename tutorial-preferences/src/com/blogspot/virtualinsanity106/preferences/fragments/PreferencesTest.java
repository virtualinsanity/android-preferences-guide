package com.blogspot.virtualinsanity106.preferences.fragments;

import com.blogspot.virtualinsanity106.preferences.R; //NOT android.R 

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.util.Log;

public class PreferencesTest extends PreferenceFragment {
	private static final String TAG = "PreferencesTest";
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//create the fragment content from preferences.xml
		addPreferencesFromResource(R.xml.preferences);
		Log.d(TAG, "Content created");
	}
}
