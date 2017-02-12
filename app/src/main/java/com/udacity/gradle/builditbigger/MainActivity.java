package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.lib_andrdispljokes.MessageDisplayActivity;


public class MainActivity extends AppCompatActivity {

    public static final String PREF_NAME = "jokeStorage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, SettingActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        new JokeSyncTask().execute(new Pair<Context, String>(this, prefs.getString(
                getString(R.string.pref_IP_key), getString(R.string.pref_IP))));

        //get joke from sharedPreferences
        SharedPreferences joke = getSharedPreferences(PREF_NAME, 0);
        String joke_str = joke.getString("currentJoke", null);

        Log.v("tellJoke", "joke: " + joke_str);
        //Start message display activity to display joke...
        Intent intent = new Intent(this, MessageDisplayActivity.class);
        intent.putExtra("jokeIntent", joke_str);
        startActivity(intent);
    }


}
