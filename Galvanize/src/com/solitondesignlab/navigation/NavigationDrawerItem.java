package com.solitondesignlab.navigation;

// TODO: Auto-generated Javadoc
/**
 * The Class NavigationDrawerItem.
 */
public class NavigationDrawerItem {
	
	/** The title. */
	private String title;
    
    /** The icon. */
    private int icon;
     
    /**
     * Instantiates a new navigation drawer item.
     */
    public NavigationDrawerItem(){
    	
    }
 
    /**
     * Instantiates a new navigation drawer item.
     *
     * @param title the title
     * @param icon the icon
     */
    public NavigationDrawerItem(String title, int icon){
        this.title = title;
        this.icon = icon;
    }
     
    /**
     * Gets the title.
     *
     * @return the title
     */
    public String getTitle(){
        return this.title;
    }
     
    /**
     * Gets the icon.
     *
     * @return the icon
     */
    public int getIcon(){
        return this.icon;
    }
     
    /**
     * Sets the title.
     *
     * @param title the new title
     */
    public void setTitle(String title){
        this.title = title;
    }
     
    /**
     * Sets the icon.
     *
     * @param icon the new icon
     */
    public void setIcon(int icon){
        this.icon = icon;
    }

}
