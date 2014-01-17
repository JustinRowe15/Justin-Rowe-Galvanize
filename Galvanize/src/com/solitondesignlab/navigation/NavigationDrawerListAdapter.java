package com.solitondesignlab.navigation;
 
import java.util.ArrayList;

import com.solitondesignlab.galvanize.R;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
 
// TODO: Auto-generated Javadoc
/**
 * The Class NavigationDrawerListAdapter.
 */
public class NavigationDrawerListAdapter extends BaseAdapter {
     
    /** The context. */
    private Context context;
    
    /** The nav drawer items. */
    private ArrayList<NavigationDrawerItem> navDrawerItems;
     
    /**
     * Instantiates a new navigation drawer list adapter.
     *
     * @param context the context
     * @param navDrawerItems the nav drawer items
     */
    public NavigationDrawerListAdapter(Context context, ArrayList<NavigationDrawerItem> navDrawerItems){
        this.context = context;
        this.navDrawerItems = navDrawerItems;
    }
 
    /* (non-Javadoc)
     * @see android.widget.Adapter#getCount()
     */
    @Override
    public int getCount() {
        return navDrawerItems.size();
    }
 
    /* (non-Javadoc)
     * @see android.widget.Adapter#getItem(int)
     */
    @Override
    public Object getItem(int position) {       
        return navDrawerItems.get(position);
    }
 
    /* (non-Javadoc)
     * @see android.widget.Adapter#getItemId(int)
     */
    @Override
    public long getItemId(int position) {
        return position;
    }
 
    /* (non-Javadoc)
     * @see android.widget.Adapter#getView(int, android.view.View, android.view.ViewGroup)
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
        	LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.drawer_list_item, null);
        }
          
        ImageView imgIcon = (ImageView) convertView.findViewById(R.id.icon);
        TextView txtTitle = (TextView) convertView.findViewById(R.id.title);
          
        imgIcon.setImageResource(navDrawerItems.get(position).getIcon());        
        txtTitle.setText(navDrawerItems.get(position).getTitle());
         
        return convertView;
    }
 
}