package com.spencerkerber.reddit_application;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.parse.Parse;
import com.parse.ParseObject;

/**
 * As of now, all this activity does is create and
 * render a fragment.
 */
public class MainActivity extends FragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addFragment();

        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        Parse.initialize(this, "2eowtY2UOx4pXINyumVVjSJoMd5agD25uLDH75sy", "wNsMAL29n7RWOl1uw0EiQ7DVEFCSI4Y59oPNIeGU");

        ParseObject testObject = new ParseObject("TestObject");
        testObject.put("foo", "bar");
        testObject.saveInBackground();
    }

    void addFragment(){
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragments_holder
                        , PostsFragment.newInstance("askreddit"))
                .commit();
    }
}
