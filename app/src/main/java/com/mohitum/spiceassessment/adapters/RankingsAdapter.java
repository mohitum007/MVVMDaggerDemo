package com.mohitum.spiceassessment.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mohitum.spiceassessment.R;
import com.mohitum.spiceassessment.model.Category;

import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoryViewHolder> {

    /**
     * List of adapter data
     */
    private List<Category> categories;

    /**
     * Layout Inflater instance to inflate adapter views
     */
    private LayoutInflater inflater;

    /**
     * Adapter constructor
     *
     * @param context calling context
     * @param categories categories list data
     */
    CategoriesAdapter(Context context, List<Category> categories) {
        inflater = LayoutInflater.from(context);
        this.categories = categories;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row_item_category, parent, false);
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
    class CategoryViewHolder extends RecyclerView.ViewHolder {

        Category category;
        /**
         * Feed View holder constructor
         *
         * @param itemView item layout view
         */
        private CategoryViewHolder(View itemView) {
            super(itemView);
        }
    }
}