package com.mohitum.spiceassessment.view;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.mohitum.spiceassessment.MyApplication;
import com.mohitum.spiceassessment.R;
import com.mohitum.spiceassessment.adapters.CategoriesAdapter;
import com.mohitum.spiceassessment.adapters.RankingsAdapter;
import com.mohitum.spiceassessment.dagger.Repository;
import com.mohitum.spiceassessment.dagger.ViewModelFactory;
import com.mohitum.spiceassessment.network.ApiResponse;
import com.mohitum.spiceassessment.network.Status;
import com.mohitum.spiceassessment.utils.Utilities;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;

public class HomeActivity extends AppCompatActivity {

    @Inject
    ViewModelFactory viewModelFactory;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.progress_layout)
    LinearLayout progressLayout;

    @BindView(R.id.error_label)
    TextView errorLabel;

    @BindView(R.id.show_rank_wise_switch)
    Switch showRankWiseSwitch;

    HomeViewModel viewModel;

    private ApiResponse jsonResponse;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ButterKnife.bind(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ((MyApplication) getApplication()).getAppComponent().doInjection(this);

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel.class);

        viewModel.jsonApiResponse().observe(this, this::consumeResponse);

        if (Utilities.checkInternetConnection(this)) {
            prepareAndFetch();
        } else {
            Toast.makeText(HomeActivity.this, getResources().getString(R.string.errorString), Toast.LENGTH_SHORT).show();
        }
    }

    private void prepareAndFetch() {
        viewModel.hitFetchJsonApi();
    }

    @OnCheckedChanged(R.id.show_rank_wise_switch)
    public void showRankWise() {
        if (showRankWiseSwitch.isChecked()) {
            RankingsAdapter rankingsAdapter = new RankingsAdapter(this, jsonResponse.data.getRankings());
            recyclerView.setAdapter(rankingsAdapter);
        } else {
            CategoriesAdapter categoriesAdapter = new CategoriesAdapter(this, jsonResponse.data.getCategories());
            recyclerView.setAdapter(categoriesAdapter);
        }
    }

    private void consumeResponse(ApiResponse apiResponse) {
        if (apiResponse != null && handleApiState(apiResponse.status)) {
            this.jsonResponse = apiResponse;
            showRankWiseSwitch.setEnabled(true);
            Repository.PRODUCTS = viewModel.getfinalProductList(apiResponse.data.getCategories(), apiResponse.data.getRankings());
            CategoriesAdapter categoriesAdapter = new CategoriesAdapter(this, apiResponse.data.getCategories());
            recyclerView.setAdapter(categoriesAdapter);
        }
    }

    private boolean handleApiState(Status status) {
        switch (status) {
            case LOADING:
                progressLayout.setVisibility(View.VISIBLE);
                errorLabel.setVisibility(View.INVISIBLE);
                recyclerView.setVisibility(View.INVISIBLE);
                return false;

            case SUCCESS:
                progressLayout.setVisibility(View.INVISIBLE);
                errorLabel.setVisibility(View.INVISIBLE);
                recyclerView.setVisibility(View.VISIBLE);
                return true;

            case ERROR:
            default:
                progressLayout.setVisibility(View.INVISIBLE);
                errorLabel.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.INVISIBLE);
                return false;
        }
    }
}
