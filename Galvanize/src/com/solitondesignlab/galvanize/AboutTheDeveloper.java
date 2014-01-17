package com.solitondesignlab.galvanize;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

// TODO: Auto-generated Javadoc
/**
 * The Class AboutTheDeveloper.
 */
public class AboutTheDeveloper extends Activity {
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about_the_developer);
	    
	    TextView tv=(TextView)findViewById(R.id.aboutTheDeveloperTextView);
	    tv.setText(Html.fromHtml(getString(R.string.about_the_developer)));
	    
	    ActionBar actionBar = getActionBar();
	    actionBar.setDisplayHomeAsUpEnabled(true);
	}

}
