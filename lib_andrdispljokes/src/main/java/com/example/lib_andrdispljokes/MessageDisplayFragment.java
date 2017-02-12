package com.example.lib_andrdispljokes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.Joker;


/**
 * Created by FBrigati on 03/02/2017.
 */

public class MessageDisplayFragment extends Fragment {

    static final String DETAIL_URI = "URI";

    public MessageDisplayFragment() {
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.v("Fragment in AndrdLib", "Im here!");

        String joke = "Nothing!";

        //String joke_from_act = getArguments().getString("");

//        Log.v("Fragment in AndrdLib", "Argument value: " + joke_from_act);

        Intent intent = getActivity().getIntent();

        joke = intent.getStringExtra("jokeIntent");

        Log.v("Intent Display FRG", "Joke from other activity:" + joke);

        if (savedInstanceState != null){
            joke = savedInstanceState.getString("currentJoke");
            Log.v("Fragment in AndrdLib", "Joke: " + joke);
        }

        View rootView = inflater.inflate(R.layout.fragment_message_display, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.jokes_text);
        //Joker myJoke = new Joker();
        textView.setText(joke);
        return rootView;

    }
}
