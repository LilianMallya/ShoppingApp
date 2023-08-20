package uk.ac.le.co2103.part2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateProductActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextQuantity;
    private TextView textViewUnit;
    private Button buttonMinus;
    private Button buttonPlus;
    private Button buttonSave;

    private Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_product);


        Intent intent = getIntent();
        product = (Product) intent.getSerializableExtra("product");


        editTextName = findViewById(R.id.editTextName);
        editTextQuantity = findViewById(R.id.editTextQuantity);
        textViewUnit = findViewById(R.id.textViewUnit);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonPlus = findViewById(R.id.buttonPlus);
        buttonSave = findViewById(R.id.buttonSave);


        editTextName.setText(product.getName());
        editTextQuantity.setText(String.valueOf(product.getQuantity()));
        textViewUnit.setText(product.getUnit());

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int quantity = product.getQuantity();
                if (quantity > 0) {
                    quantity--;
                    editTextQuantity.setText(String.valueOf(quantity));
                }
            }
        });

        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Increase the quantity by 1
                int quantity = product.getQuantity();
                quantity++;
                editTextQuantity.setText(String.valueOf(quantity));
            }
        });

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = editTextName.getText().toString().trim();
                String quantityString = editTextQuantity.getText().toString().trim();


                if (quantityString.isEmpty()) {
                    Toast.makeText(UpdateProductActivity.this, "Please enter a valid quantity", Toast.LENGTH_SHORT).show();
                    return;
                }

                int quantity = Integer.parseInt(quantityString);


                product.setName(name);
                product.setQuantity(quantity);


                Intent intent = new Intent(UpdateProductActivity.this, ShoppingListActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
