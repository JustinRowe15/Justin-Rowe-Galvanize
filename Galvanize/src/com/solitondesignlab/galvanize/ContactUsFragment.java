package com.solitondesignlab.galvanize;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

// TODO: Auto-generated Javadoc
/**
 * The Class ContactUsFragment.
 */
public class ContactUsFragment extends Fragment {
	
	/**
	 * Instantiates a new contact us fragment.
	 */
	public ContactUsFragment() {

	}

    /* (non-Javadoc)
     * @see android.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        
        View rootView = inflater.inflate(R.layout.activity_contactus, container, false);
        
        return rootView;
        
    }
    
}
