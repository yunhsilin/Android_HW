package com.example.myapplication220315;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;

    private TextView mKK;
    private int mCC;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.textView);
        if (savedInstanceState != null){
            String i = savedInstanceState.getString("mCou");
            mShowCount.setText(i);
            mCount = Integer.parseInt(i);
        }
    }

    /*
     * Shows a Toast when the TOAST button is clicked.
     *
     * @param view The view that triggered this onClick handler.
     *             Since a toast always shows on the top,
     *             the passed in view is not used.
     */

    /*
     * Increments the number in the TextView when the COUNT button is clicked.
     *
     * @param view The view that triggered this onClick handler.
     *             Since the count always appears in the TextView,
     *             the passed in view is not used.
     */
    public void countUp(View view) {
        mCount++;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("mCou", mShowCount.getText().toString());
    }
}