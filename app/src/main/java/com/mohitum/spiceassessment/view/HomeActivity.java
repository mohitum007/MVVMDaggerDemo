package com.mohitum.spiceassessment.view;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mohitum.spiceassessment.MyApplication;
import com.mohitum.spiceassessment.R;
import com.mohitum.spiceassessment.dagger.ViewModelFactory;
import com.mohitum.spiceassessment.network.ApiResponse;
import com.mohitum.spiceassessment.network.Status;
import com.mohitum.spiceassessment.utils.Utilities;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends AppCompatActivity {

    @Inject
    ViewModelFactory viewModelFactory;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.progress_layout)
    LinearLayout progressLayout;

    @BindView(R.id.error_label)
    TextView errorLabel;

    HomeViewModel viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ButterKnife.bind(this);

        ((MyApplication) getApplication()).getAppComponent().doInjection(this);

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel.class);

        viewModel.jsonApiResponse().observe(this, this::consumeResponse);

        if (Utilities.checkInternetConnection(this)) {
            prepareAndFetch();
        } else {
            Toast.makeText(HomeActivity.this,getResources().getString(R.string.errorString), Toast.LENGTH_SHORT).show();
        }
    }

    private void prepareAndFetch() {
        viewModel.hitFetchJsonApi();
    }

    @OnClick(R.id.show_category_wise)
    public void sortByCategory() {

    }

    @OnClick(R.id.show_rank_wise)
    public void sortByRank() {

    }

    private void consumeResponse(ApiResponse apiResponse) {
        if(apiResponse != null && handleApiState(apiResponse.status)) {
            Toast.makeText(HomeActivity.this, "Successful", Toast.LENGTH_SHORT).show();

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
