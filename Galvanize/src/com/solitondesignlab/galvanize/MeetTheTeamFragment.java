package com.solitondesignlab.galvanize;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

// TODO: Auto-generated Javadoc
/**
 * The Class MeetTheTeamFragment.
 */
public class MeetTheTeamFragment extends Fragment {
	
	TextView jimTwitter;
	TextView lawrenceTwitter;
	TextView chrisTwitter;
	TextView merylTwitter;

    /* (non-Javadoc)
     * @see android.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        
        View rootView = inflater.inflate(R.layout.activity_theteam, container, false);
        
        jimTwitter =(TextView)rootView.findViewById(R.id.jimTwitterTextView);
        lawrenceTwitter =(TextView)rootView.findViewById(R.id.lawrenceTwitterTextView);
        chrisTwitter =(TextView)rootView.findViewById(R.id.chrisTwitterTextView);
        merylTwitter =(TextView)rootView.findViewById(R.id.merylTwitterTextView);
        
        jimTwitter.setText(Html.fromHtml(getString(R.string.yodeets)));
        jimTwitter.setOnClickListener(new View.OnClickListener(){
        	@Override
        	public void onClick(View v) {
        		// TODO Auto-generated method stub
        		String twitterURL = "https://twitter.com/yodeets";
        		Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(twitterURL));
        		startActivity(i); 
        	}
        });
        
        lawrenceTwitter.setText(Html.fromHtml(getString(R.string.ldmandes)));
        lawrenceTwitter.setOnClickListener(new View.OnClickListener(){
        	@Override
        	public void onClick(View v) {
        		// TODO Auto-generated method stub
        		String twitterURL = "https://twitter.com/ldmandes";
        		Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(twitterURL));
        		startActivity(i); 
        	}
        });
        
        chrisTwitter.setText(Html.fromHtml(getString(R.string.chrisonan)));
        chrisTwitter.setOnClickListener(new View.OnClickListener(){
        	@Override
        	public void onClick(View v) {
        		// TODO Auto-generated method stub
        		String twitterURL = "https://twitter.com/chrisonan";
        		Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(twitterURL));
        		startActivity(i); 
        	}
        });
        
        merylTwitter.setText(Html.fromHtml(getString(R.string.wheresmer)));
        merylTwitter.setOnClickListener(new View.OnClickListener(){
        	@Override
        	public void onClick(View v) {
        		// TODO Auto-generated method stub
        		String twitterURL = "https://twitter.com/wheresmer";
        		Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(twitterURL));
        		startActivity(i); 
        	}
        });
        
        return rootView;
        
    }
    
}
