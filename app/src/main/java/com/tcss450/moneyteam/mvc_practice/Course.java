package com.tcss450.moneyteam.mvc_practice;

import java.util.ArrayList;

/**
 * Created by Josh Rueschenberg on 4/13/2015.
 */
public class Course {
    public String mCID;
    public String mSDes;
    public String mLDes;
    public String mPrereqs;


    public Course(final String theCID, final String theSDes, final String theLDes,
                  final String thePrereqs) {
        mCID = theCID;
        mSDes = theSDes;
        mLDes = theLDes;
        mPrereqs = thePrereqs;
    }
}
