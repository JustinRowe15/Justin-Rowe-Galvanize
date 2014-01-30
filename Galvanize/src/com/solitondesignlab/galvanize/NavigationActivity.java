package com.solitondesignlab.galvanize;

import java.util.ArrayList;

import com.solitondesignlab.navigation.NavigationDrawerItem;
import com.solitondesignlab.navigation.NavigationDrawerListAdapter;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

// TODO: Auto-generated Javadoc
/**
 * The Class NavigationActivity.
 */
public class NavigationActivity extends FragmentActivity {
	
    /** The m drawer layout. */
    private DrawerLayout mDrawerLayout;
    
    /** The m drawer list. */
    private ListView mDrawerList;
    
    /** The m drawer toggle. */
    private ActionBarDrawerToggle mDrawerToggle;
 
    // Navigation Drawer Title
    /** The m drawer title. */
    private CharSequence mDrawerTitle;
 
    // Store Application Title
    /** The m title. */
    private CharSequence mTitle;
 
    // Menu Titles and Icons
    /** The nav menu titles. */
    private String[] navMenuTitles;
    
    /** The nav menu icons. */
    private TypedArray navMenuIcons;
 
    // Navigation Drawer ArrayList with Adapter
    /** The nav drawer items. */
    private ArrayList<NavigationDrawerItem> navDrawerItems;
    
    /** The adapter. */
    private NavigationDrawerListAdapter adapter;
 
    /* (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
 
        mTitle = mDrawerTitle = getTitle();
        navMenuTitles = getResources().getStringArray(R.array.navigation_drawer_items);
        navMenuIcons = getResources().obtainTypedArray(R.array.navigation_drawer_icons);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.navigation_drawer);
        navDrawerItems = new ArrayList<NavigationDrawerItem>();
 
        // Home
        navDrawerItems.add(new NavigationDrawerItem(navMenuTitles[0], navMenuIcons.getResourceId(0, -1)));
        // Capital
        navDrawerItems.add(new NavigationDrawerItem(navMenuTitles[1], navMenuIcons.getResourceId(1, -1)));
        // Community
        navDrawerItems.add(new NavigationDrawerItem(navMenuTitles[2], navMenuIcons.getResourceId(2, -1)));
        // Curriculum
        navDrawerItems.add(new NavigationDrawerItem(navMenuTitles[3], navMenuIcons.getResourceId(3, -1)));
        // The Space
        navDrawerItems.add(new NavigationDrawerItem(navMenuTitles[4], navMenuIcons.getResourceId(4, -1)));
        // Meet The Team
        navDrawerItems.add(new NavigationDrawerItem(navMenuTitles[5], navMenuIcons.getResourceId(5, -1)));
        // Contact Us
        navDrawerItems.add(new NavigationDrawerItem(navMenuTitles[6], navMenuIcons.getResourceId(6, -1)));
        // Locate Us
        navDrawerItems.add(new NavigationDrawerItem(navMenuTitles[7], navMenuIcons.getResourceId(7, -1)));
         
        // Recycle array
        navMenuIcons.recycle();
        
        mDrawerList.setOnItemClickListener(new SlideMenuClickListener());
 
        // Navigation drawer list adapter
        adapter = new NavigationDrawerListAdapter(getApplicationContext(),navDrawerItems);
        mDrawerList.setAdapter(adapter);
 
        // Enable action bar icon and Toggle Button
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
 
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.drawable.ic_drawer, R.string.app_name, R.string.app_name) {
            public void onDrawerClosed(View view) {
                getActionBar().setTitle(mTitle);
                invalidateOptionsMenu();
            }
 
            public void onDrawerOpened(View drawerView) {
                getActionBar().setTitle(mDrawerTitle);
                invalidateOptionsMenu();
            }
        };
        
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        
        if (savedInstanceState == null) {
            displayView(0);
        }
    }
    
    /**
     * The listener interface for receiving slideMenuClick events.
     * The class that is interested in processing a slideMenuClick
     * event implements this interface, and the object created
     * with that class is registered with a component using the
     * component's <code>addSlideMenuClickListener<code> method. When
     * the slideMenuClick event occurs, that object's appropriate
     * method is invoked.
     *
     * @see SlideMenuClickEvent
     */
    private class SlideMenuClickListener implements ListView.OnItemClickListener {
    	
	    /* (non-Javadoc)
	     * @see android.widget.AdapterView.OnItemClickListener#onItemClick(android.widget.AdapterView, android.view.View, int, long)
	     */
	    @Override
    	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    		// display view for selected nav drawer item
    		displayView(position);
    		}
    }
    
    /**
     * Display view.
     *
     * @param position the position
     */
    private void displayView(int position) {
        // Update the main content by replacing fragments
        Fragment fragment = null;
        switch (position) {
        case 0:
            fragment = new GalvanizeFragment();
            break;
        case 1:
            fragment = new CapitalFragment();
            break;
        case 2:
            fragment = new CommunityFragment();
            break;
        case 3:
            fragment = new CurriculumFragment();
            break;
        case 4:
            fragment = new TheSpaceFragment();
            break;
        case 5:
            fragment = new MeetTheTeamFragment();
            break;
        case 6:
            fragment = new ContactUsFragment();
            break;
        case 7:
            fragment = new LocateUsFragment();
            break;
 
        default:
            break;
        }
 
        if (fragment != null) {
        	android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
 
            // Update Selected Item with Title
            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            setTitle(navMenuTitles[position]);
            mDrawerLayout.closeDrawer(mDrawerList);
        } else {
            // Error Message For Fragment Creation
            Log.e("MainActivity", "Error in creating fragment");
        }
    }
 
    /* (non-Javadoc)
     * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.galvanize, menu);
        return true;
    }
 
    /* (non-Javadoc)
     * @see android.app.Activity#onOptionsItemSelected(android.view.MenuItem)
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle Click Actions
        switch (item.getItemId()) {
        case R.id.galvanize_online:
        	String galvanizeURL = "http://www.galvanize.it";
    		Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(galvanizeURL));
    		startActivity(i);
            return true;
        case R.id.action_settings:
        	Intent intent = new Intent(NavigationActivity.this, AboutTheDeveloper.class);
        	startActivityForResult(intent, 0);
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }
 
    /**
     * *
     * Called when invalidateOptionsMenu() is triggered.
     *
     * @param menu the menu
     * @return true, if successful
     */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
        menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }
 
    /* (non-Javadoc)
     * @see android.app.Activity#setTitle(java.lang.CharSequence)
     */
    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getActionBar().setTitle(mTitle);
    }
 
    /**
     * When using the ActionBarDrawerToggle, you must call it during
     * onPostCreate() and onConfigurationChanged()...
     *
     * @param savedInstanceState the saved instance state
     */
 
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }
 
    /* (non-Javadoc)
     * @see android.app.Activity#onConfigurationChanged(android.content.res.Configuration)
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }
}
