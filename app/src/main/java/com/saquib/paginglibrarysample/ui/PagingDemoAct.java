package com.saquib.paginglibrarysample.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.saquib.paginglibrarysample.MyApplication;
import com.saquib.paginglibrarysample.R;
import com.saquib.paginglibrarysample.databinding.PagingDemoLayoutBinding;
import com.saquib.paginglibrarysample.utils.Constant;
import com.saquib.paginglibrarysample.utils.ViewModelFactory;

import java.util.Objects;

import javax.inject.Inject;

/**
 * Created by ${Saquib} on 12-08-2018.
 */
public class PagingDemoAct extends AppCompatActivity {

    @Inject
    ViewModelFactory viewModelFactory;

    PagingLibViewModel viewModel;

    PagingDemoLayoutBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.paging_demo_layout);
        ((MyApplication) getApplication()).getAppComponent().doInjection(this);
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(PagingLibViewModel.class);
        init();
    }

    private void init() {

        binding.list.setLayoutManager(new LinearLayoutManager(this));
        MyPageListAdapter adapter = new MyPageListAdapter();
        binding.list.setAdapter(adapter);

        if (!Constant.checkInternetConnection(this)) {
            Snackbar.make(findViewById(android.R.id.content), Constant.CHECK_NETWORK_ERROR, Snackbar.LENGTH_SHORT)
                    .show();
        }

        viewModel.getListLiveData().observe(this, adapter::submitList);

        viewModel.getProgressLoadStatus().observe(this, status -> {
            if (Objects.requireNonNull(status).equalsIgnoreCase(Constant.LOADING)) {
                binding.progress.setVisibility(View.VISIBLE);
            } else if (status.equalsIgnoreCase(Constant.LOADED)) {
                binding.progress.setVisibility(View.GONE);
            }
        });

    }
}
