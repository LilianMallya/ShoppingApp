package uk.ac.le.co2103.part2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ShoppingListAdapter extends RecyclerView.Adapter<ShoppingListAdapter.ViewHolder> {

    private Context context;
    private List<Product> productList;
    private OnProductClickListener productClickListener;

    public interface OnProductClickListener {
        void onEditProductClick(Product product);
        void onDeleteProductClick(Product product);
    }

    public ShoppingListAdapter(Context context, List<Product> productList, OnProductClickListener listener) {
        this.context = context;
        this.productList = productList;
        this.productClickListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.productNameTextView.setText(product.getName());
        holder.productQuantityTextView.setText(String.valueOf(product.getQuantity()));
        holder.productUnitTextView.setText(product.getUnit());

        holder.itemView.setOnClickListener(v -> {

        });

        holder.buttonEdit.setOnClickListener(v -> {

            Product selectedProduct = productList.get(position);
            productClickListener.onEditProductClick(selectedProduct);
        });

        holder.buttonDelete.setOnClickListener(v -> {

            Product selectedProduct = productList.get(position);
            productClickListener.onDeleteProductClick(selectedProduct);
            productList.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, productList.size());
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView productNameTextView;
        TextView productQuantityTextView;
        TextView productUnitTextView;
        Button buttonEdit;
        Button buttonDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productNameTextView = itemView.findViewById(R.id.textProductName);
            productQuantityTextView = itemView.findViewById(R.id.textProductQuantity);
            productUnitTextView = itemView.findViewById(R.id.textProductUnit);
            buttonEdit = itemView.findViewById(R.id.buttonEdit);
            buttonDelete = itemView.findViewById(R.id.buttonDelete);
        }
    }
}
