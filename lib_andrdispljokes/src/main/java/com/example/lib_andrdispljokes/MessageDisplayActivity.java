package com.example.lib_andrdispljokes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by FBrigati on 03/02/2017.
 */

public class MessageDisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_display);

        Intent intent = getIntent();

        String joke = intent.getStringExtra("jokeIntent");

        Log.v("Intent Display", "Joke from other activity:" + joke);

        if (savedInstanceState == null){
          /*  Bundle arguments = new Bundle();
            arguments.putString(MessageDisplayFragment.DETAIL_URI, joke);
            //arguments.putParcelable(MessageDisplayFragment.DETAIL_URI, getIntent().getData());
            Log.v("Creating Fragment", "Creating fragment..");
            MessageDisplayFragment fragment = new MessageDisplayFragment();
            fragment.setArguments(arguments);

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, fragment)
                    .commit();  */
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_image, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
