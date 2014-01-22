package com.solitondesignlab.galvanize;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

// TODO: Auto-generated Javadoc
/**
 * The Class CommunityFragment.
 */
public class CommunityFragment extends Fragment {
	
	/* (non-Javadoc)
	 * @see android.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
	 */
    @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        
        View rootView = inflater.inflate(R.layout.activity_community, container, false);
        
        TextView tv=(TextView)rootView.findViewById(R.id.lukeBeattyTextView);
        TextView tv1=(TextView)rootView.findViewById(R.id.davidCohenTextView);
        TextView tv2=(TextView)rootView.findViewById(R.id.andreDurandTextView);
        TextView tv3=(TextView)rootView.findViewById(R.id.perryEvansTextView);
        TextView tv4=(TextView)rootView.findViewById(R.id.bradFeldTextView);
        TextView tv5=(TextView)rootView.findViewById(R.id.anthonyFrancoTextView);
        TextView tv6=(TextView)rootView.findViewById(R.id.jimFranklinTextView);
        TextView tv7=(TextView)rootView.findViewById(R.id.brentHandlerTextView);
        TextView tv8=(TextView)rootView.findViewById(R.id.shayneHigdonTextView);
        TextView tv9=(TextView)rootView.findViewById(R.id.tomHigleyTextView);
        TextView tv10=(TextView)rootView.findViewById(R.id.markHopkinsTextView);
        TextView tv11=(TextView)rootView.findViewById(R.id.jbHolstonTextView);
        TextView tv12=(TextView)rootView.findViewById(R.id.bartLorangTextView);
        TextView tv13=(TextView)rootView.findViewById(R.id.jonNordmarkTextView);
        TextView tv14=(TextView)rootView.findViewById(R.id.johnRaederTextView);
        TextView tv15=(TextView)rootView.findViewById(R.id.nancyPhillipsTextView);
        TextView tv16=(TextView)rootView.findViewById(R.id.peteHudsonTextView);
        TextView tv17=(TextView)rootView.findViewById(R.id.markAubleTextView);
        TextView tv18=(TextView)rootView.findViewById(R.id.gregBylesTextView);
        TextView tv19=(TextView)rootView.findViewById(R.id.scottChasinTextView);
        TextView tv20=(TextView)rootView.findViewById(R.id.steveHalstadtTextView);
        TextView tv21=(TextView)rootView.findViewById(R.id.josephZellTextView);
        TextView tv22=(TextView)rootView.findViewById(R.id.jasonKellerTextView);
        
        tv.setText(Html.fromHtml(getString(R.string.luke_beatty)));
        tv1.setText(Html.fromHtml(getString(R.string.david_cohen)));
        tv2.setText(Html.fromHtml(getString(R.string.andre_durand)));
        tv3.setText(Html.fromHtml(getString(R.string.perry_evans)));
        tv4.setText(Html.fromHtml(getString(R.string.brad_feld)));
        tv5.setText(Html.fromHtml(getString(R.string.anthony_franco)));
        tv6.setText(Html.fromHtml(getString(R.string.jim_franklin)));
        tv7.setText(Html.fromHtml(getString(R.string.brent_handler)));
        tv8.setText(Html.fromHtml(getString(R.string.shayne_higdon)));
        tv9.setText(Html.fromHtml(getString(R.string.tom_higley)));
        tv10.setText(Html.fromHtml(getString(R.string.mark_hopkins)));
        tv11.setText(Html.fromHtml(getString(R.string.jb_holston)));
        tv12.setText(Html.fromHtml(getString(R.string.bart_lorang)));
        tv13.setText(Html.fromHtml(getString(R.string.jon_nordmark)));
        tv14.setText(Html.fromHtml(getString(R.string.john_raeder)));
        tv15.setText(Html.fromHtml(getString(R.string.nancy_phillips)));
        tv16.setText(Html.fromHtml(getString(R.string.pete_hudson)));
        tv17.setText(Html.fromHtml(getString(R.string.mark_auble)));
        tv18.setText(Html.fromHtml(getString(R.string.greg_byles)));
        tv19.setText(Html.fromHtml(getString(R.string.scott_chasin)));
        tv20.setText(Html.fromHtml(getString(R.string.steve_halstadt)));
        tv21.setText(Html.fromHtml(getString(R.string.joseph_zell)));
        tv22.setText(Html.fromHtml(getString(R.string.jason_keller)));
        
        addYouTubeFrag();
        
        return rootView;
    }
    
    public void addYouTubeFrag() {
    	Fragment youTubeFragment = new YouTubeFragment();
    	FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
    	transaction.add(R.id.fragContainer, youTubeFragment).commit();
    	
        //getChildFragmentManager().beginTransaction().add(R.id.fragContainer, new YouTubeFragment()).commit();
        //getChildFragmentManager().executePendingTransactions();
    }
}
