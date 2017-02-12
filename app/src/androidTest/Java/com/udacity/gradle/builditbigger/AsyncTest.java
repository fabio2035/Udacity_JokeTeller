package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.util.Pair;

import org.junit.runner.RunWith;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created by FBrigati on 12/02/2017.
 */

@RunWith(AndroidJUnit4.class)
public class AsyncTest {

    @Test
    public void asyncRetrieveJokeTest() throws Exception{
        JokeSyncTask jokeTester = new JokeSyncTask();
        //checks if retrieval of joke returns null...

        String jokesString = jokeTester.
                execute(new Pair<Context, String>(null, "192.168.43.231")).
                get(30, TimeUnit.SECONDS);

        //String jokesString = jokeTester.execute().get(30, TimeUnit.SECONDS);

        assertNotNull("Message is null!", jokesString);
    }

}
