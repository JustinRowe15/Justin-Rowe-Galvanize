package com.solitondesignlab.galvanize;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.google.android.youtube.player.YouTubePlayer.OnInitializedListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;

public class YouTubeFragment extends YouTubePlayerSupportFragment implements YouTubePlayer.OnInitializedListener {
	
	static private final String DEVELOPER_KEY = "AIzaSyCKB12QsO6RPtmd5GvK5KxFnqXSwJE9gFM";
    static private final String VIDEO = "uttzftvxAoI";
    String log = "";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		View rootView = inflater.inflate(R.layout.fragment_youtube, container, false);
		
		YouTubePlayerView youTubeView = (YouTubePlayerView)rootView.findViewById(R.id.youtube_view);
		youTubeView.initialize(DEVELOPER_KEY, (OnInitializedListener) this);

		return rootView;
	}
	
	public void onInitializationFailure(Provider provider, YouTubeInitializationResult error) {
		Toast.makeText(YouTubeFragment.this.getActivity(), "Oh no! "+error.toString(),Toast.LENGTH_LONG).show();
		}
	
	@Override
	public void onInitializationSuccess(Provider provider, YouTubePlayer player, boolean wasRestored) {
		player.loadVideo(VIDEO);
		}
}
