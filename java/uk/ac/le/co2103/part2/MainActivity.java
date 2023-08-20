package uk.ac.le.co2103.part2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ShoppingListAdapter.OnProductClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView recyclerView;
    private ShoppingListAdapter adapter;
    private List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productList = new ArrayList<>();

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ShoppingListAdapter(this, productList, this);
        recyclerView.setAdapter(adapter);

        // Add sample products to the list
        productList.add(new Product("Mango", 5, "Unit"));
        productList.add(new Product("Banana", 2, "Kg"));
        productList.add(new Product("Water", 3, "Litre"));

        FloatingActionButton fabAddProduct = findViewById(R.id.fab);
        fabAddProduct.setOnClickListener(view -> {
            Log.d(TAG, "Add product FAB clicked.");
            Intent intent = new Intent(MainActivity.this, AddProductActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public void onEditProductClick(Product product) {
        // Handle edit product click
        Intent intent = new Intent(MainActivity.this, UpdateProductActivity.class);
        intent.putExtra("product", (Serializable) product);
        startActivity(intent);
    }

    @Override
    public void onDeleteProductClick(Product product) {
        // Handle delete product click
        productList.remove(product);
        adapter.notifyDataSetChanged();
    }
}
