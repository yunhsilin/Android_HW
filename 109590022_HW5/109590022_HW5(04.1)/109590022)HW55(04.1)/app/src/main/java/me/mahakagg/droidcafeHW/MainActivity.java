package me.mahakagg.droidcafeHW;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

/*
* Questions and answers
*
* Q1 - How do you add images to an Android Studio project?
* A1 - Copy the image files into your project's drawable folder.
*
* Q2 - How do you make an ImageView clickable like a simple Button?
* A2 - Add the android:onClick attribute to the ImageView in the layout and use it to call the click handler in the Activity
*
* Q3 - Which rule applies to a click handler called from the attribute in the layout?
* A3 - The click handler method must be public, return void, and define a View as its only parameter
* 
* */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                startActivity(intent);
            }
        });
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

    public void displayToast (String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    public void showDonutOrder(View view){
        displayToast(getString(R.string.donut_order_message));
    }

    public void showIceCreamOrder(View view){
        displayToast(getString(R.string.ice_cream_order_message));
    }

    public void showFroYoOrder(View view){
        displayToast(getString(R.string.froyo_order_message));
    }
}
