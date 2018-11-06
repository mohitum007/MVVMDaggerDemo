package com.mohitum.spiceassessment.adapters;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mohitum.spiceassessment.R;
import com.mohitum.spiceassessment.model.Category;
import com.mohitum.spiceassessment.view.ProductsActivity;

import java.util.List;

import static com.mohitum.spiceassessment.utils.Constants.INTENT_DATA;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoryViewHolder> {

    /**
     * List of adapter data
     */
    private List<Category> categories;

    /**
     * Layout Inflater instance to inflate adapter views
     */
    private LayoutInflater inflater;

    private Activity activity;

    /**
     * Adapter constructor
     *
     * @param activity calling activity context
     * @param categories categories list data
     */
    public CategoriesAdapter(Activity activity, List<Category> categories) {
        inflater = LayoutInflater.from(activity);
        this.activity = activity;
        this.categories = categories;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row_item_base, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category category = categories.get(position);
        holder.category = category;
        String name = category.getName();
        if(name != null) {
            ((TextView)holder.itemView).setText(name);
        }
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    /**
     * This class will be used as a view holder representing single view for the adapter
     *
     */
    class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        Category category;
        /**
         * View holder constructor
         *
         * @param itemView item layout view
         */
        private CategoryViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(activity, ProductsActivity.class);
            intent.putExtra(INTENT_DATA, category);
            activity.startActivity(intent);
        }
    }
}