package com.solitondesignlab.navigation;

import com.solitondesignlab.galvanize.NavigationActivity;
import com.solitondesignlab.galvanize.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
 
// TODO: Auto-generated Javadoc
/**
 * The Class LaunchScreen.
 */
public class LaunchScreen extends Activity {
 
    /** The launch time. */
    private static int LAUNCH_TIME = 1500;
 
    /* (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
 
        new Handler().postDelayed(new Runnable() {
 
            @Override
            public void run() {
                Intent i = new Intent(LaunchScreen.this, NavigationActivity.class);
                startActivity(i);
                finish();
            }
        }, LAUNCH_TIME);
    }
}
