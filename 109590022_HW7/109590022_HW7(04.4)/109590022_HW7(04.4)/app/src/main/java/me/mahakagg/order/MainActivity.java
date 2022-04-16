package me.mahakagg.order;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

/*
 *Answers to questions
 *
 * Q1 - Which template provides an Activity with an options menu and the v7 appcompat support library Toolbar as the app bar?
 * A1 - Basic Activity template
 *
 * Q2 - Which dependency do you need in order to use a TabLayout?
 * A2 - com.android.support:design
 *
 * Q3 - Where do you define each child Activity and parent Activity to provide Up navigation?
 * A3 - To provide the Up button for a child screen Activity, declare the parent Activity in the child Activity section of the AndroidManifest.xml file.
 */


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void onClickImage(View view){
        Intent intent;
        switch (view.getId()){
            case R.id.imageView_donut :
                intent = new Intent(this, SecondActivity.class);
                startActivity(intent);
                break;
            case R.id.imageView_froyo:
                intent = new Intent(this, ThirdActivity.class);
                startActivity(intent);
                break;
            case R.id.imageView_ics:
                intent = new Intent(this, FourthActivity.class);
                startActivity(intent);
                break;
            default: break;
        }
    }
}
