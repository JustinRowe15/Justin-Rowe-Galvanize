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
 * The Class MeetTheTeamFragment.
 */
public class MeetTheTeamFragment extends Fragment {
	
	/**
	 * Instantiates a new meet the team fragment.
	 */
	public MeetTheTeamFragment() {

	}

    /* (non-Javadoc)
     * @see android.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        
        View rootView = inflater.inflate(R.layout.activity_theteam, container, false);
        
        TextView tv=(TextView)rootView.findViewById(R.id.jimTwitterTextView);
        TextView tv1=(TextView)rootView.findViewById(R.id.lawrenceTwitterTextView);
        TextView tv2=(TextView)rootView.findViewById(R.id.chrisTwitterTextView);
        TextView tv3=(TextView)rootView.findViewById(R.id.merylTwitterTextView);
        
        tv.setText(Html.fromHtml(getString(R.string.yodeets)));
        tv1.setText(Html.fromHtml(getString(R.string.ldmandes)));
        tv2.setText(Html.fromHtml(getString(R.string.chrisonan)));
        tv3.setText(Html.fromHtml(getString(R.string.wheresmer)));
        
        return rootView;
        
    }
    
}
