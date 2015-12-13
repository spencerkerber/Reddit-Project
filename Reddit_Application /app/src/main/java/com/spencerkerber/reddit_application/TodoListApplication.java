package com.spencerkerber.reddit_application;

/**
 * Created by spencerkerber on 12/12/15.
 */
import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseObject;
import com.parse.ParseUser;

public class TodoListApplication extends Application {

    public static final String TODO_GROUP_NAME = "ALL_TODOS";

    @Override
    public void onCreate() {
        super.onCreate();

        // add Todo subclass
        ParseObject.registerSubclass(Todo.class);

        // enable the Local Datastore
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "2eowtY2UOx4pXINyumVVjSJoMd5agD25uLDH75sy", "wNsMAL29n7RWOl1uw0EiQ7DVEFCSI4Y59oPNIeGU");
        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();
        ParseACL.setDefaultACL(defaultACL, true);
    }



}
