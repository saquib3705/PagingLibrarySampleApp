package com.saquib.paginglibrarysample.utils;

import com.google.gson.JsonElement;

import io.reactivex.Observable;

/**
 * Created by ${Saquib} on 12-08-2018.
 */

public class Repository {

    private ApiCallInterface apiCallInterface;

    public Repository(ApiCallInterface apiCallInterface) {
        this.apiCallInterface = apiCallInterface;
    }

    /*
     * method to call news api
     * */
    public Observable<JsonElement> executeNewsApi(int index) {
        return apiCallInterface.fetchListNews(Constant.sources[index], String.valueOf(Constant.API_KEY));
    }

}
