package com.tcss450.moneyteam.mvc_practice;

import java.net.URI;

/**
 * Created by Josh Rueschenberg on 4/13/2015.
 */
public class Instructor {
    public String mName;
    public String mTitle;
    public String mEmail;
    public String mPhone;
    public String mOffice;
    public String mBio;
//    public URI mImage;

    public Instructor(final String theName, final String theTitle, final String theEmail,
                      final String thePhone, final String theOffice, final String theBio) {
        mName = theName;
        mTitle = theTitle;
        mEmail = theEmail;
        mPhone = thePhone;
        mOffice = theOffice;
        mBio = theBio;

    }


}
