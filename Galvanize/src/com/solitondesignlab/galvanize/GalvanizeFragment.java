package com.solitondesignlab.galvanize;

import android.os.Bundle;
import android.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

// TODO: Auto-generated Javadoc
/**
 * The Class GalvanizeFragment.
 */
public class GalvanizeFragment extends Fragment {
	
	/**
	 * Instantiates a new galvanize fragment.
	 */
	public GalvanizeFragment() {

	}

    /* (non-Javadoc)
     * @see android.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        
        View rootView = inflater.inflate(R.layout.activity_galvanize, container, false);
        
        TextView tv=(TextView)rootView.findViewById(R.id.homeFirstBlockTextView);
        tv.setText(Html.fromHtml(getString(R.string.homeFirstBlock)));
        
        return rootView;
        
    }
    
}
