package com.dingmouren.test.net;

import com.dingmouren.test.model.UnsplashResult;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by dingmouren on 2017/5/2.
 */

public interface Api {
    @GET("photos/")
    Observable<List<UnsplashResult>> getPhotos(@Query("client_id") String clientId, @Query("page") int page, @Query("per_page") int per_page, @Query("order_by") String ouderBy);
}
