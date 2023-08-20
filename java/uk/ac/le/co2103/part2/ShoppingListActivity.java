package uk.ac.le.co2103.part2;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ShoppingListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String shoppingListName = extras.getString("shoppingListName");



            Toast.makeText(this, "Shopping List: " + shoppingListName, Toast.LENGTH_SHORT).show();


        }
    }
}