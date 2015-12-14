package com.spencerkerber.reddit_application;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * Created by CK on 12/14/2015.
 */
public class PostView extends Fragment {

    private WebView webViewPost;
    private String url;

    public PostView(){}

    public static PostView NewInstance(String url){
        PostView postView = new PostView();
        postView.setUrl(url);
        return postView;
    }

    private void setUrl(String url) {
        this.url = url;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.postview_fragment, container, false);
        webViewPost = (WebView)view.findViewById(R.id.postview);
        WebSettings webSettings = webViewPost.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webViewPost.loadUrl(url);
        return view;
    }

    public interface PostLoadListener {
        public void onPostLoad();
    }

}
