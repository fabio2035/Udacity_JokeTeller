package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v4.util.Pair;
import android.util.Log;

import com.example.fbrigati.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;
import java.net.URL;

/**
 * Created by FBrigati on 09/02/2017.
 */

class JokeSyncTask extends AsyncTask<Pair<Context, String>, Void, String> {

    private static MyApi myApiService;
    private Context context;

     @Override
    protected String doInBackground(Pair<Context, String>... params) {
        //if(myApiService == null) {  // Only do this once
            Log.v("checking IP: ", "http://" + params[0].second.trim() + ":8080/_ah/api/");

            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://" + params[0].second.trim() + ":8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver
            myApiService = builder.build();
        //}

         if (params != null){
             if(params.length > 0){
          context = params[0].first;}}

        try {
            return myApiService.retrieveJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result){
        if (context != null){
        Log.v("AsyncTask_postexec", "result: " + result);
        //Pass joke to sharedpreferences...
        SharedPreferences joke = context.getSharedPreferences(MainActivity.PREF_NAME, 0);
        SharedPreferences.Editor editor = joke.edit();
        editor.putString("currentJoke", result);
        editor.commit();}
    }
}
