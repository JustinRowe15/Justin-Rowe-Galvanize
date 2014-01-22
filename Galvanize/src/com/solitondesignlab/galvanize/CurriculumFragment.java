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
 * The Class CurriculumFragment.
 */
public class CurriculumFragment extends Fragment {
	
	TextView gSchool;
	
	/* (non-Javadoc)
	 * @see android.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
	 */
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        
        View rootView = inflater.inflate(R.layout.activity_curriculum, container, false);
	        
	    gSchool =(TextView)rootView.findViewById(R.id.curriculumFirstBlockTextView);
	    
	    gSchool.setText(Html.fromHtml(getString(R.string.curriculumFirstBlock)));
	    gSchool.setOnClickListener(new View.OnClickListener(){
        	@Override
        	public void onClick(View v) {
        		// TODO Auto-generated method stub
        		String gSchoolURL = "https://www.gschool.it";
        		Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(gSchoolURL));
        		startActivity(i); 
        	}
        });
	    
	    return rootView;
	        
	    }
	    
}
