package uk.ac.le.co2103.part2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;

public class AddProductActivity extends AppCompatActivity {

    private static final String TAG = AddProductActivity.class.getSimpleName();
    private EditText editTextName;
    private EditText editTextQuantity;
    private Spinner spinnerUnit;
    private Button buttonAdd;

    private ShoppingList shoppingList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);


        Intent intent = getIntent();
        shoppingList = (ShoppingList) intent.getSerializableExtra("shoppingList");


        editTextName = findViewById(R.id.editTextName);
        editTextQuantity = findViewById(R.id.editTextQuantity);
        spinnerUnit = findViewById(R.id.spinnerUnit);
        buttonAdd = findViewById(R.id.buttonAdd);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.units_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerUnit.setAdapter(adapter);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString().trim();
                String quantityString = editTextQuantity.getText().toString().trim();
                String unit = spinnerUnit.getSelectedItem().toString();


                if (isProductExists(name)) {
                    Toast.makeText(AddProductActivity.this, "Product already exists", Toast.LENGTH_SHORT).show();
                } else {

                    int quantity = Integer.parseInt(quantityString);
                    shoppingList.addProduct(name, quantity, unit);
                    Toast.makeText(AddProductActivity.this, "Product added", Toast.LENGTH_SHORT).show();


                    Intent intent = new Intent(AddProductActivity.this, ShoppingListActivity.class);
                    intent.putExtra("shoppingList", (Serializable) shoppingList);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private boolean isProductExists(String productName) {
        List<Product> productList = shoppingList.getProductList();
        for (Product product : productList) {
            if (product.getName().equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }
}
