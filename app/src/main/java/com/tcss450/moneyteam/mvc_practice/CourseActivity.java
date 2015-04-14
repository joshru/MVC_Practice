package com.tcss450.moneyteam.mvc_practice;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class CourseActivity extends ActionBarActivity {

    EditText mCID;
    EditText mShortDesc;
    EditText mLongDesc;
    EditText mPreReqs;
    Button mCreateCourseButt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        mCID = (EditText)findViewById(R.id.CID_text);
        mShortDesc = (EditText)findViewById(R.id.short_desc_text);
        mLongDesc = (EditText)findViewById(R.id.long_desc_text);
        mPreReqs = (EditText)findViewById(R.id.prereq_text);
        mCreateCourseButt = (Button)findViewById(R.id.create_course_button);


        mCreateCourseButt.setOnClickListener(new SubmitHandler());
        /*mCreateCourseButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Course course = new Course(mCID.getText().toString(), mShortDesc.getText().toString(),
                        mLongDesc.getText().toString(), mPreReqs.getText().toString());

                Toast toasty = Toast.makeText(getApplicationContext(), "Course created, bruh", Toast.LENGTH_SHORT);
                toasty.show();

            }
        });*/

    }

    @Override
    protected void onPause() {
        super.onPause();
        saveData();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {

        SharedPreferences sharedPrefs = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor eddy = sharedPrefs.edit();

        mCID.setText(sharedPrefs.getString(getString(R.string.saved_course_ID),
                getString(R.string.default_value)));
        mShortDesc.setText(sharedPrefs.getString(getString(R.string.saved_short_desc),
                getString(R.string.default_value)));
        mLongDesc.setText(sharedPrefs.getString(getString(R.string.saved_long_desc),
                getString(R.string.default_value)));
        mPreReqs.setText(sharedPrefs.getString(getString(R.string.saved_prereqs),
                getString(R.string.default_value)));
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

       /* SharedPreferences sharedPrefs = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor eddy = sharedPrefs.edit();
        eddy.putString(getString(R.string.saved_course_ID), mCID.getText().toString());
        eddy.putString(getString(R.string.saved_short_desc), mShortDesc.getText().toString());
        eddy.putString(getString(R.string.saved_long_desc), mLongDesc.getText().toString());
        eddy.putString(getString(R.string.saved_prereqs), mPreReqs.getText().toString());

        eddy.commit();*/
        saveData();




        super.onSaveInstanceState(outState);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_course, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private void saveData() {
        SharedPreferences sharedPrefs = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor eddy = sharedPrefs.edit();
        eddy.putString(getString(R.string.saved_course_ID), mCID.getText().toString());
        eddy.putString(getString(R.string.saved_short_desc), mShortDesc.getText().toString());
        eddy.putString(getString(R.string.saved_long_desc), mLongDesc.getText().toString());
        eddy.putString(getString(R.string.saved_prereqs), mPreReqs.getText().toString());

        eddy.commit();
    }

    private class SubmitHandler implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Course course = new Course(mCID.getText().toString(), mShortDesc.getText().toString(),
                    mLongDesc.getText().toString(), mPreReqs.getText().toString());

            Toast toasty = Toast.makeText(getApplicationContext(), "Course created, bruh", Toast.LENGTH_SHORT);
            toasty.show();

        }

    }
}
