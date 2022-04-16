package me.mahakagg.recyclerview_t;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class RecipeMethodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_method);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String item_name = null;
        if (extras != null) {
           item_name = extras.getString(RecipeListAdapter.EXTRA_NAME);
        }
        TextView heading = findViewById(R.id.food_name);
        ImageView imageView = findViewById(R.id.food_image);
        heading.setText(item_name);
        if (item_name != null) {
            switch (item_name){
                //applepie B-52 cake
                case "Apple Pie":
                    imageView.setImageResource(R.drawable.pic1);
                    break;
                case "B-52":
                    imageView.setImageResource(R.drawable.pic2);
                    break;
                case "Cake":
                    imageView.setImageResource(R.drawable.pic5);
                    break;
                case "Delicious":
                    imageView.setImageResource(R.drawable.pic3);
                    break;
                case "pEpE":
                    imageView.setImageResource(R.drawable.pic4);
                    break;

                default: break;
           }
        }
    }

}
