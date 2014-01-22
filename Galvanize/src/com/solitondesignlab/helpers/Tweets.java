package com.solitondesignlab.helpers;

import com.google.gson.annotations.SerializedName;

public class Tweets {

	@SerializedName("created_at")
    private String DateCreated;
	
	 @SerializedName("text")
     private String Text;
	 
	 public String getDateCreated() {
         return DateCreated;
	 }
	 
	 public String getText() {
         return Text;
	 }
	 
	 public void setDateCreated(String dateCreated) {
         DateCreated = dateCreated;
	 }
	 
	 public void setText(String text) {
         Text = text;
 	}
	 
	 @Override
     public String toString(){
		 return getText();
     }
	
}
