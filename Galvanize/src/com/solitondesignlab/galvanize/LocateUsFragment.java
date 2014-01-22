package com.solitondesignlab.galvanize;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

// TODO: Auto-generated Javadoc
/**
 * The Class LocateUsFragment.
 */
public class LocateUsFragment extends Fragment {
	
	/**
	 * Instantiates a new locate us fragment.
	 */
	public LocateUsFragment() {

	}

    /* (non-Javadoc)
     * @see android.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        
        View rootView = inflater.inflate(R.layout.activity_locateus, container, false);
        
        return rootView;
        
    }
    
}
