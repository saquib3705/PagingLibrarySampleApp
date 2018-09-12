package com.saquib.paginglibrarysample.ui;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;

import com.saquib.paginglibrarysample.news_datasource.NewsDataSourceClass;
import com.saquib.paginglibrarysample.news_datasource.NewsDataSourceFactory;
import com.saquib.paginglibrarysample.utils.NewsModelClass;
import com.saquib.paginglibrarysample.utils.Repository;

import io.reactivex.disposables.CompositeDisposable;


/**
 * Created by ${Saquib} on 12-08-2018.
 */
public class PagingLibViewModel extends ViewModel {

    private NewsDataSourceFactory newsDataSourceFactory;
    private LiveData<PagedList<NewsModelClass>> listLiveData;

    private LiveData<String> progressLoadStatus = new MutableLiveData<>();
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public PagingLibViewModel(Repository repository) {
        newsDataSourceFactory = new NewsDataSourceFactory(repository, compositeDisposable);
        initializePaging();
    }


    private void initializePaging() {

        PagedList.Config pagedListConfig =
                new PagedList.Config.Builder()
                        .setEnablePlaceholders(true)
                        .setInitialLoadSizeHint(10)
                        .setPageSize(10).build();

        listLiveData = new LivePagedListBuilder<>(newsDataSourceFactory, pagedListConfig)
                .build();

        progressLoadStatus = Transformations.switchMap(newsDataSourceFactory.getMutableLiveData(), NewsDataSourceClass::getProgressLiveStatus);

    }

    public LiveData<String> getProgressLoadStatus() {
        return progressLoadStatus;
    }

    public LiveData<PagedList<NewsModelClass>> getListLiveData() {
        return listLiveData;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.clear();
    }
}