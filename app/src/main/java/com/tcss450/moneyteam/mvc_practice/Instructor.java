package com.tcss450.moneyteam.mvc_practice;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by Josh Rueschenberg on 4/13/2015.
 */
public class Instructor implements Serializable {
    private static final long serialVersionUID = 0L;
    private static final String objectFile = "instructor";
    private String mName;
    private String mTitle;
    private String mEmail;
    private String mPhone;
    private String mOffice;
    private String mBio;
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
     public static void writeToFile(Context ctx, Instructor instructor) {
        FileOutputStream fOutputStream;
        ObjectOutputStream objectOutputStream;
        try {

            fOutputStream = ctx.openFileOutput(objectFile, Context.MODE_PRIVATE);
            objectOutputStream = new ObjectOutputStream(fOutputStream);
            objectOutputStream.writeObject(instructor);
            objectOutputStream.close();
            fOutputStream.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        //out.writeObject(this);
        //out.flush();
    }
    public static Instructor readObject(Context ctx) throws IOException, ClassNotFoundException {
        // = (Instructor)in.readObject();
        //return  returnInstructor;
        FileInputStream FIS;
        ObjectInputStream OIS;
        Instructor instructor = null;
        try {

            FIS = ctx.openFileInput(objectFile);
            OIS = new ObjectInputStream(FIS);
            instructor = (Instructor) OIS.readObject();
            OIS.close();
            FIS.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return instructor;
    }



}
