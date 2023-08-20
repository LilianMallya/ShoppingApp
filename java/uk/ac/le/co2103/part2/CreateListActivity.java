package uk.ac.le.co2103.part2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class CreateListActivity extends AppCompatActivity {
    private EditText editTextName;
    private Button buttonCreate;

    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_list);

        editTextName = findViewById(R.id.edit_text_name);
        buttonCreate = findViewById(R.id.button_create);

        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String listName = editTextName.getText().toString();

                ShoppingList shoppingList = new ShoppingList("My Shopping List", "image_url");

                Intent intent = new Intent(CreateListActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

}