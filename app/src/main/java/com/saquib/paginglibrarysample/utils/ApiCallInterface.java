package com.saquib.paginglibrarysample.utils;

import com.google.gson.JsonElement;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ${Saquib} on 12-08-2018.
 */
public interface ApiCallInterface {

    @GET(Urls.FetchNewsList)
    Observable<JsonElement> fetchListNews(
            @Query("source") String source,
            @Query("apiKey") String apiKey);

}
