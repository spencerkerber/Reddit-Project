package com.spencerkerber.reddit_application;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.UUID;

/**
 * Created by spencerkerber on 12/12/15.
 */
@ParseClassName("User")
public class User extends ParseObject{

    public ParseUser getAuthor(){
        return getParseUser("author");
    }

    public void setAuthor(ParseUser currentUser) {
        put("author", currentUser);
    }

    public String getSub() {
        return getString("sub");
    }

    public void setSub(String sub) {
        put("sub", sub);
    }

    public void setUuidString() {
        UUID uuid = UUID.randomUUID();
        put("uuid", uuid.toString());
    }

    public String getUuidString() {
        return getString("uuid");
    }

    public static ParseQuery<User> getQuery() {
        return ParseQuery.getQuery(User.class);
    }
}
