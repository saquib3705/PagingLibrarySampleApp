package com.saquib.paginglibrarysample.utils;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.saquib.paginglibrarysample.ui.PagingLibViewModel;

import javax.inject.Inject;

/**
 * Created by ${Saquib} on 12-08-2018.
 */

public class ViewModelFactory implements ViewModelProvider.Factory {

    private Repository repository;

    @Inject
    public ViewModelFactory(Repository repository) {
        this.repository = repository;
    }


    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(PagingLibViewModel.class)) {
            return (T) new PagingLibViewModel(repository);
        }
        throw new IllegalArgumentException("Unknown class name");
    }
}
