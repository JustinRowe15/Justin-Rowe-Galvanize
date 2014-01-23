package com.solitondesignlab.galvanize;

import android.os.Bundle;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.OnInitializedListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

public class YouTubeFragment extends YouTubePlayerSupportFragment {
	
	public static String DEVELOPER_KEY = "AIzaSyCKB12QsO6RPtmd5GvK5KxFnqXSwJE9gFM";
    public YouTubePlayer activePlayer;

	public static YouTubeFragment newInstance(String url) {
		
		YouTubeFragment playerYouTubeFrag = new YouTubeFragment();
		Bundle bundle = new Bundle();
		bundle.putString("url", url);
		playerYouTubeFrag.setArguments(bundle);
		playerYouTubeFrag.init();
		
		return playerYouTubeFrag;
		
	}
	
	private void init() {
		
		initialize(DEVELOPER_KEY, new OnInitializedListener() {
			
			public void onInitializationFailure(Provider arg0, YouTubeInitializationResult arg1) {
				
			}
			
			public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
				activePlayer = player;
				activePlayer.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
				if (!wasRestored) {
					activePlayer.cueVideo(getArguments().getString("url"), 0);
				}
	        }
	    });
	}
	
	public void onYouTubeVideoPaused() {
		activePlayer.pause();
	}
}
