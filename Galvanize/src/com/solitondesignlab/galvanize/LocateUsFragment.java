package com.solitondesignlab.galvanize;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

// TODO: Auto-generated Javadoc
/**
 * The Class LocateUsFragment.
 */
public class LocateUsFragment extends Fragment {

	static final LatLng GALVANIZE = new LatLng(39.733536, -104.992611);
	private SupportMapFragment fragment;
	private GoogleMap map;
	TextView phoneNumber;

    /* (non-Javadoc)
     * @see android.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        
        View rootView = inflater.inflate(R.layout.activity_locateus, container, false);
        phoneNumber =(TextView)rootView.findViewById(R.id.galvanizePhoneNumberTextView);
        phoneNumber.setText(Html.fromHtml(getString(R.string.galvanize_number)));
        phoneNumber.setOnClickListener(new View.OnClickListener(){
        	@Override
        	public void onClick(View v) {
        		// TODO Auto-generated method stub
        		String number = "303-823-4170";
        		String uri = "tel:" + number.trim() ;
        		Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(uri));
        		startActivity(intent); 
        	}
        });
        
        return rootView;
    }
    
    @Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
    	FragmentManager fm = getChildFragmentManager();
    	
    	fragment = (SupportMapFragment) fm.findFragmentById(R.id.mapsContainer);
    	if (fragment == null) {
    		fragment = SupportMapFragment.newInstance();
    		fm.beginTransaction().replace(R.id.mapsContainer, fragment).commit();
    	}
    }
    
    @Override
	public void onResume() {
		super.onResume();
		if (map == null) {
			map = fragment.getMap();
			map.addMarker(new MarkerOptions().position(GALVANIZE).title("Galvanize").snippet("1062 Delaware St. Denver, CO 80204"));
			map.moveCamera(CameraUpdateFactory.newLatLngZoom(GALVANIZE, 2.0f));
		    map.animateCamera(CameraUpdateFactory.zoomTo(17.0f), 2000, null);
		}
	}
    
}
