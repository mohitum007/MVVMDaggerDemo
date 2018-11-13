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
import com.mohitum.spiceassessment.model.Ranking;
import com.mohitum.spiceassessment.view.ProductsActivity;

import java.util.List;

import static com.mohitum.spiceassessment.utils.Constants.INTENT_DATA;

public class RankingsAdapter extends RecyclerView.Adapter<RankingsAdapter.RankingViewHolder> {

    /**
     * List of adapter data
     */
    private List<Ranking> rankings;

    /**
     * Layout Inflater instance to inflate adapter views
     */
    private LayoutInflater inflater;

    private Activity activity;

    /**
     * Adapter constructor
     *
     * @param activity calling activity context
     * @param rankings rankings list data
     */
    public RankingsAdapter(Activity activity, List<Ranking> rankings) {
        inflater = LayoutInflater.from(activity);
        this.activity = activity;
        this.rankings = rankings;
    }

    @NonNull
    @Override
    public RankingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row_item_base, parent, false);
        return new RankingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RankingViewHolder holder, int position) {
        Ranking ranking = rankings.get(position);
        holder.ranking = ranking;
        String name = ranking.getRanking();
        if (name != null) {
            ((TextView) holder.itemView).setText(name);
        }
    }

    @Override
    public int getItemCount() {
        return rankings.size();
    }

    /**
     * This class will be used as a view holder representing single view for the adapter
     */
    class RankingViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        Ranking ranking;

        /**
         * View holder constructor
         *
         * @param itemView item layout view
         */
        private RankingViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(activity, ProductsActivity.class);
            intent.putExtra(INTENT_DATA, ranking);
            activity.startActivity(intent);
        }
    }
}