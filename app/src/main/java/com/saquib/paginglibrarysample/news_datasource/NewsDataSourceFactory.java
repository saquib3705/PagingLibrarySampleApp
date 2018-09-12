package com.saquib.paginglibrarysample.news_datasource;

import android.arch.lifecycle.MutableLiveData;
import android.arch.paging.DataSource;

import com.saquib.paginglibrarysample.utils.NewsModelClass;
import com.saquib.paginglibrarysample.utils.Repository;

import io.reactivex.disposables.CompositeDisposable;


/**
 * Created by ${Saquib} on 12-08-2018.
 */
public class NewsDataSourceFactory extends DataSource.Factory<Integer, NewsModelClass> {

    private MutableLiveData<NewsDataSourceClass> liveData;
    private Repository repository;
    private CompositeDisposable compositeDisposable;

    public NewsDataSourceFactory(Repository repository, CompositeDisposable compositeDisposable) {
        this.repository = repository;
        this.compositeDisposable = compositeDisposable;
        liveData = new MutableLiveData<>();
    }

    public MutableLiveData<NewsDataSourceClass> getMutableLiveData() {
        return liveData;
    }

    @Override
    public DataSource<Integer, NewsModelClass> create() {
        NewsDataSourceClass dataSourceClass = new NewsDataSourceClass(repository, compositeDisposable);
        liveData.postValue(dataSourceClass);
        return dataSourceClass;
    }
}
