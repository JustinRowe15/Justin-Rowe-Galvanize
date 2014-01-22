package com.solitondesignlab.galvanize;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.solitondesignlab.helpers.TwitterArray;
import com.solitondesignlab.helpers.TwitterAuthentication;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

// TODO: Auto-generated Javadoc
/**
 * The Class GalvanizeFragment.
 */
public class GalvanizeFragment extends Fragment {
	
	final static String SCREEN_NAME = "galvanize";
	Context context;
	View rootView;
	Boolean isInternetPresent = false;
	ImageButton twitterButton;
	ImageButton facebookButton;
	ImageButton googlePlusButton;
	ImageButton linkedInButton;

	public GalvanizeFragment() {
	}

    /* (non-Javadoc)
     * @see android.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        
        rootView = inflater.inflate(R.layout.activity_galvanize, container, false);
        TextView tv=(TextView)rootView.findViewById(R.id.homeFirstBlockTextView);
        tv.setText(Html.fromHtml(getString(R.string.homeFirstBlock)));
        
        twitterButton = (ImageButton)rootView.findViewById(R.id.twitterIconImageView);
        facebookButton = (ImageButton)rootView.findViewById(R.id.facebookIconImageView);
        googlePlusButton = (ImageButton)rootView.findViewById(R.id.googlePlusIconImageView);
        linkedInButton = (ImageButton)rootView.findViewById(R.id.linkedInIconImageView);
        
        twitterButton.setOnClickListener(new View.OnClickListener(){
        	@Override
        	public void onClick(View v) {
        		// TODO Auto-generated method stub
        		String twitterURL = "https://twitter.com/galvanize";
        		Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(twitterURL));
        		startActivity(i); 
        	}
        });
        
        facebookButton.setOnClickListener(new View.OnClickListener(){
        	@Override
        	public void onClick(View v) {
        		// TODO Auto-generated method stub
        		String twitterURL = "https://www.facebook.com/teamgalvanize";
        		Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(twitterURL));
        		startActivity(i); 
        	}
        });
        
        googlePlusButton.setOnClickListener(new View.OnClickListener(){
        	@Override
        	public void onClick(View v) {
        		// TODO Auto-generated method stub
        		String twitterURL = "https://plus.google.com/u/0/105873666433174181108";
        		Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(twitterURL));
        		startActivity(i); 
        	}
        });
        
        linkedInButton.setOnClickListener(new View.OnClickListener(){
        	@Override
        	public void onClick(View v) {
        		// TODO Auto-generated method stub
        		String twitterURL = "http://www.linkedin.com/vsearch/p?company=Galvanize";
        		Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(twitterURL));
        		startActivity(i); 
        	}
        });
        
        Log.i("GETTING CONNECTION INFO", "CONNECTING");
        ConnectivityManager connMgr = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
        	Log.i("GETTING CONNECTION", "CONNECTED");
        	DownloadTweets dl = new DownloadTweets();
        	dl.execute(SCREEN_NAME);
        } else {
        	Log.i("GETTING CONNECTION", "NOT CONNECTED");
        }
        
        return rootView;
    }
    
    public class DownloadTweets extends AsyncTask<String, Void, String>{
    	final static String CONSUMER_KEY = "LDykuHkHQeGyda6xFudOjA";
    	final static String CONSUMER_SECRET = "gVUVzkaefZ42gLsTBI5KCwWuH2lonjjZE0lAER8xv0";
    	final static String TWITTER_TOKEN_URL = "https://api.twitter.com/oauth2/token";
    	final static String TWITTER_STREAM_URL = "https://api.twitter.com/1.1/statuses/user_timeline.json?screen_name=";

		@Override
		protected String doInBackground(String... screenNames) {
			Log.i("DOWNLOAD TWEETS", "DO IN BACKGROUND");
			String response = null;
			if (screenNames.length > 0) {
			response = getTwitterStream(screenNames[0]);
			}
			return response;
		}
		
		protected void onPostExecute(String response){
			Log.i("URL RESPONSE", response);
			try{
                JSONArray json = new JSONArray(response);
                int j = json.length();
                for (int i=0;i<j; i++){
                	JSONObject object = json.getJSONObject(i);
                	if (i == 0 ){
                		((TextView) rootView.findViewById(R.id.firstTweetTextView)).setText(object.getString("text"));
                	} else if (i == 1) {
                		((TextView) rootView.findViewById(R.id.secondTweetTextView)).setText(object.getString("text"));
                	} else if (i == 2) {
                		((TextView) rootView.findViewById(R.id.thirdTweetTextView)).setText(object.getString("text"));
                	}
                }
			} catch (JSONException e){
                Log.e("JSON", "JSON OBJECT EXCEPTION");
			}
		}
		
		public String getTwitterStream(String screenName){
	    	String response = null;
	    	try{
	    		String apiKey = URLEncoder.encode(CONSUMER_KEY, "UTF-8");
	    		String apiSecret = URLEncoder.encode(CONSUMER_SECRET, "UTF-8");
	    		String apiString = apiKey + ":" + apiSecret;
	    		Log.i("URL RESPONSE", apiString);
	    		String base64Encoded = Base64.encodeToString(apiString.getBytes(), Base64.NO_WRAP);
	    		HttpPost httpPost = new HttpPost(TWITTER_TOKEN_URL);
                httpPost.setHeader("Authorization", "Basic " + base64Encoded);
                httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
                httpPost.setEntity(new StringEntity("grant_type=client_credentials"));
                String rawAuthorization = getResponseBody(httpPost);
                Log.i("AUTHORIZATION RESPONSE", rawAuthorization);
                TwitterAuthentication auth = jsonToAuthenticated(rawAuthorization);
                if (auth != null && auth.token_type.equals("bearer")) {
                    HttpGet httpGet = new HttpGet(TWITTER_STREAM_URL + screenName + "&include_rts=false&count=4");
                    httpGet.setHeader("Authorization", "Bearer " + auth.access_token);
                    httpGet.setHeader("Content-Type", "application/json");
                    response = getResponseBody(httpGet);
            }
	    	} catch (UnsupportedEncodingException ex) {
            } catch (IllegalStateException ex1) {
            }
            return response;
	    }
		
		public String getResponseBody(HttpRequestBase request) {
            StringBuilder sb = new StringBuilder();
            try {
            	DefaultHttpClient httpClient = new DefaultHttpClient(new BasicHttpParams());
                HttpResponse response = httpClient.execute(request);
                int statusCode = response.getStatusLine().getStatusCode();
                String reason = response.getStatusLine().getReasonPhrase();
                Log.i("GET RESPONSE BODY", reason);
                if (statusCode == 200) {
                	HttpEntity entity = response.getEntity();
                	InputStream inputStream = entity.getContent();
                	BufferedReader bReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 8);
                	String line = null;
                	while ((line = bReader.readLine()) != null) {
                		sb.append(line);
                    }
                } else {
                	sb.append(reason);
                }
            } catch (UnsupportedEncodingException ex) {
            } catch (ClientProtocolException ex1) {
            } catch (IOException ex2) {
            }
            return sb.toString();
		}
		
		public TwitterAuthentication jsonToAuthenticated(String rawAuthorization) {
			TwitterAuthentication auth = null;
            if (rawAuthorization != null && rawAuthorization.length() > 0) {
            	try {
            		Gson gson = new Gson();
            		auth = gson.fromJson(rawAuthorization, TwitterAuthentication.class);
            	} catch (IllegalStateException ex) {
                }
            }
            return auth;
		}
		
		public TwitterArray jsonToTwitter(String result) {
            TwitterArray tweetsArray = null;
            if (result != null && result.length() > 0) {
            	try {
            		Gson gson = new Gson();
                    tweetsArray = gson.fromJson(result, TwitterArray.class);
                }catch (IllegalStateException ex) {
                }
            }
            return tweetsArray;
		}
    }
}

