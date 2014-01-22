package com.solitondesignlab.galvanize;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

// TODO: Auto-generated Javadoc
/**
 * The Class CapitalFragment.
 */
public class CapitalFragment extends Fragment {
	
	TextView activeJunky;
	TextView keenIO;
	TextView dabble;
	TextView pangeaOrganics;

    /* (non-Javadoc)
     * @see android.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        
        View rootView = inflater.inflate(R.layout.activity_capital, container, false);
        
        activeJunky =(TextView)rootView.findViewById(R.id.activeJunkyTitleTextView);
        keenIO =(TextView)rootView.findViewById(R.id.keenIOTitleTextView);
        dabble =(TextView)rootView.findViewById(R.id.dabbleTitleTextView);
        pangeaOrganics =(TextView)rootView.findViewById(R.id.pangeaOrganicsTitleTextView);
        
        activeJunky.setOnClickListener(new View.OnClickListener(){
        	@Override
        	public void onClick(View v) {
        		// TODO Auto-generated method stub
        		String activeJunkyURL = "http://www.activejunky.com";
        		Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(activeJunkyURL));
        		startActivity(i); 
        	}
        });
        
        keenIO.setOnClickListener(new View.OnClickListener(){
        	@Override
        	public void onClick(View v) {
        		// TODO Auto-generated method stub
        		String keenURL = "https://keen.io";
        		Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(keenURL));
        		startActivity(i); 
        	}
        });
        
        dabble.setOnClickListener(new View.OnClickListener(){
        	@Override
        	public void onClick(View v) {
        		// TODO Auto-generated method stub
        		String dabbleURL = "https://dabble.co";
        		Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(dabbleURL));
        		startActivity(i); 
        	}
        });
        
        pangeaOrganics.setOnClickListener(new View.OnClickListener(){
        	@Override
        	public void onClick(View v) {
        		// TODO Auto-generated method stub
        		String pangeaURL = "http://www.pangeaorganics.com/default.aspx";
        		Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(pangeaURL));
        		startActivity(i); 
        	}
        });
        
        return rootView;
        
    }
    
}
