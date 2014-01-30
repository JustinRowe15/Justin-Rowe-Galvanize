package com.solitondesignlab.galvanize;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
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
	    tv.setOnClickListener(new View.OnClickListener(){
        	@Override
        	public void onClick(View v) {
        		// TODO Auto-generated method stub
        		String solitonURL = "http://www.solitondesignlab.com";
        		Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(solitonURL));
        		startActivity(i); 
        	}
        });
	    
	    ActionBar actionBar = getActionBar();
	    actionBar.setDisplayHomeAsUpEnabled(true);
	}

}
