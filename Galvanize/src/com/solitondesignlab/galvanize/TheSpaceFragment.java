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
 * The Class TheSpaceFragment.
 */
public class TheSpaceFragment extends Fragment {
	
	/**
	 * Instantiates a new the space fragment.
	 */
	public TheSpaceFragment() {

	}
	
	/* (non-Javadoc)
	 * @see android.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
	 */
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        
        View rootView = inflater.inflate(R.layout.activity_thespace, container, false);
        
        TextView tv=(TextView)rootView.findViewById(R.id.fullyFurnishedTextView);
        TextView tv1=(TextView)rootView.findViewById(R.id.nourishTextView);
        TextView tv2=(TextView)rootView.findViewById(R.id.unwindTextView);
        TextView tv3=(TextView)rootView.findViewById(R.id.signageTextView);
        TextView tv4=(TextView)rootView.findViewById(R.id.connectTextView);
        TextView tv5=(TextView)rootView.findViewById(R.id.phoneTextView);
        TextView tv6=(TextView)rootView.findViewById(R.id.reservedTextView);
        TextView tv7=(TextView)rootView.findViewById(R.id.cabinetTextView);
        TextView tv8=(TextView)rootView.findViewById(R.id.accessTextView);
        TextView tv9=(TextView)rootView.findViewById(R.id.scalableSpaceTextView);
        TextView tv10=(TextView)rootView.findViewById(R.id.lockableTextView);
        TextView tv11=(TextView)rootView.findViewById(R.id.reservationPreferenceTextView);
        TextView tv12=(TextView)rootView.findViewById(R.id.pricingTextView);
      
        tv.setText(Html.fromHtml(getString(R.string.furnished)));
        tv1.setText(Html.fromHtml(getString(R.string.nourish)));
        tv2.setText(Html.fromHtml(getString(R.string.unwind)));
        tv3.setText(Html.fromHtml(getString(R.string.signage)));
        tv4.setText(Html.fromHtml(getString(R.string.connect)));
        tv5.setText(Html.fromHtml(getString(R.string.phone)));
        tv6.setText(Html.fromHtml(getString(R.string.reserved)));
        tv7.setText(Html.fromHtml(getString(R.string.cabinet)));
        tv8.setText(Html.fromHtml(getString(R.string.access)));
        tv9.setText(Html.fromHtml(getString(R.string.scalable_space)));
        tv10.setText(Html.fromHtml(getString(R.string.lockable_suite)));
        tv11.setText(Html.fromHtml(getString(R.string.reservation_preference)));
        tv12.setText(Html.fromHtml(getString(R.string.pricing)));
        
        return rootView;
        
    }

}
