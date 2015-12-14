package com.spencerkerber.reddit_application;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.parse.ParseQuery;

/**
 * As of now, all this activity does is create and
 * render a fragment.
 */
public class MainActivity extends FragmentActivity implements PostsFragment.OnPostClick {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addFragment();

    }

    ParseQuery<Todo> query = Todo.getQuery();

    void addFragment(){
        String loadSubreddit = "funny";
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragments_holder
                        //subreddit entered here
                        , PostsFragment.newInstance(loadSubreddit))
                .commit();
    }

    @Override
    public void PostClicked(int postPosition, String url) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        PostView postView = PostView.NewInstance(url);
        fragmentTransaction.replace(R.id.fragments_holder, postView);
        fragmentTransaction.commit();
    }
}
