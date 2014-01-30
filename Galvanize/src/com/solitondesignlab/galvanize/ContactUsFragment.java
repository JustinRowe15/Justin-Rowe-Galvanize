package com.solitondesignlab.galvanize;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

// TODO: Auto-generated Javadoc
/**
 * The Class ContactUsFragment.
 */
public class ContactUsFragment extends Fragment {
	
	Button sendButton;
	EditText nameField;
	EditText emailField;
	EditText detailsField;
	EditText aboutField;
	Pattern pattern;
	Matcher matcher;

    /* (non-Javadoc)
     * @see android.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        
        View rootView = inflater.inflate(R.layout.activity_contactus, container, false);
        
        nameField = (EditText)rootView.findViewById(R.id.nameTextField); 
        emailField = (EditText)rootView.findViewById(R.id.emailTextField); 
        detailsField = (EditText)rootView.findViewById(R.id.detailsLargeTextBox); 
        aboutField = (EditText)rootView.findViewById(R.id.hearAboutLargeTextBox); 
        sendButton = (Button)rootView.findViewById(R.id.sendMessageButton);
        
        sendButton.setOnClickListener(new View.OnClickListener(){
        	@Override
        	public void onClick(View v) {
        		// TODO Auto-generated method stub
        		String subject = "Galvanize Information Request";
        		String name = nameField.getText().toString();
        		String email = emailField.getText().toString();
                String details = detailsField.getText().toString();
                String about = aboutField.getText().toString();
                String message = "Name: " + name + "\n" + "Email Address: " + email + "\n" 
                + "Details about your company and why you are a good fit for our space: " + details 
                		+ "\n" + "How did you first hear about Galvanize: " + about;

                Intent mEmail = new Intent(Intent.ACTION_SENDTO);
                mEmail.setType("text/plain");
                mEmail.putExtra(Intent.EXTRA_SUBJECT, subject);
                mEmail.putExtra(Intent.EXTRA_TEXT, message);
                mEmail.setData(Uri.parse("mailto:info@galvanize.it"));
                mEmail.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                
        		isEmailValid(email);
                if (isEmailValid(email) == false){
                	Toast.makeText(getActivity(),"Please re-enter email address.",Toast.LENGTH_SHORT).show();
                } else if (name.length() == 0) {
                	Toast.makeText(getActivity(),"Please enter your name.",Toast.LENGTH_SHORT).show();
                } else if (email.length() == 0) {
                	Toast.makeText(getActivity(),"Please enter your email address.",Toast.LENGTH_SHORT).show();
                } else if (details.length() == 0) {
                	Toast.makeText(getActivity(),"Please enter how you heard about us.",Toast.LENGTH_SHORT).show();
                } else {
                	startActivity(mEmail);
                }
        	}
        });
        
        return rootView; 
    }
    
    public boolean isEmailValid(String email) {
    	String regExpn = "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                 +"((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                   +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                   +"([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                   +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                   +"([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";
    	CharSequence inputString = email;
    	pattern = Pattern.compile(regExpn,Pattern.CASE_INSENSITIVE);
    	matcher = pattern.matcher(inputString);

    	if(matcher.matches())
    		return true;
    	else
    		return false;
    }
}
