package com.mohitum.spiceassessment.view;

import android.app.ProgressDialog;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.mohitum.spiceassessment.MyApplication;
import com.mohitum.spiceassessment.R;
import com.mohitum.spiceassessment.dagger.ViewModelFactory;
import com.mohitum.spiceassessment.network.ApiResponse;
import com.mohitum.spiceassessment.utils.Utilities;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {

    @Inject
    ViewModelFactory viewModelFactory;

    HomeViewModel viewModel;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        progressDialog = Utilities.getProgressDialog(this, "Please wait...");

        ButterKnife.bind(this);

        ((MyApplication) getApplication()).getAppComponent().doInjection(this);

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel.class);

        viewModel.jsonApiResponse().observe(this, new Observer<ApiResponse>() {
            @Override
            public void onChanged(@Nullable ApiResponse apiResponse) {
                Log.d(getString(R.string.app_name), apiResponse.toString());
                //TODO: consumeResponse(apiResponse);
            }
        });

        if (Utilities.checkInternetConnection(this)) {
            viewModel.hitFetchJsonApi();
        } else {
            Toast.makeText(HomeActivity.this,getResources().getString(R.string.errorString), Toast.LENGTH_SHORT).show();
        }
    }
}
