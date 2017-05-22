package com.dingmouren.wallpager.api;

import com.dingmouren.wallpager.model.bean.PhotoInfo;
import com.dingmouren.wallpager.model.bean.UnsplashResult;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by dingmouren on 2017/5/2.
 */

public interface Api {
    //101 最新的作品https://api.unsplash.com/photos?client_id=eb54e3b9dc12b9e0862b028b646085355d20b3442fbdfca4633ca0f7b01ef9a6&page=1&per_page=15&order_by=latest
    @GET("photos")
    Observable<List<UnsplashResult>> getRecentPhotos(@Query("client_id") String clientId,@Query("page") int page, @Query("per_page") int per_page,  @Query("order_by") String order_by);

    //102 精选https://api.unsplash.com/photos/curated?client_id=eb54e3b9dc12b9e0862b028b646085355d20b3442fbdfca4633ca0f7b01ef9a6&page=1&per_page=15&order_by=latest
    @GET("photos/curated")
    Observable<List<UnsplashResult>> getCuratedPhotos(@Query("client_id") String clientId,@Query("page") int page, @Query("per_page") int per_page,  @Query("order_by") String order_by);

    //103 建筑https://api.unsplash.com/categories/2/photos?client_id=eb54e3b9dc12b9e0862b028b646085355d20b3442fbdfca4633ca0f7b01ef9a6&page=1&per_page=15
    @GET("categories/2/photos")
    Observable<List<UnsplashResult>> getBuildingsPhotos(@Query("client_id") String clientId,@Query("page") int page, @Query("per_page") int per_page);

    //104 饮食https://api.unsplash.com/categories/3/photos?client_id=eb54e3b9dc12b9e0862b028b646085355d20b3442fbdfca4633ca0f7b01ef9a6&page=1&per_page=15
    @GET("categories/3/photos")
    Observable<List<UnsplashResult>> getFoodsPhotos(@Query("client_id") String clientId,@Query("page") int page, @Query("per_page") int per_page);

    //105 自然https://api.unsplash.com/categories/4/photos?client_id=eb54e3b9dc12b9e0862b028b646085355d20b3442fbdfca4633ca0f7b01ef9a6&page=1&per_page=15
    @GET("categories/4/photos")
    Observable<List<UnsplashResult>> getNaturePhotos(@Query("client_id") String clientId,@Query("page") int page, @Query("per_page") int per_page);

    //106 物品https://api.unsplash.com/categories/8/photos?client_id=eb54e3b9dc12b9e0862b028b646085355d20b3442fbdfca4633ca0f7b01ef9a6&page=1&per_page=15
    @GET("categories/8/photos")
    Observable<List<UnsplashResult>> getGoodsPhotos(@Query("client_id") String clientId,@Query("page") int page, @Query("per_page") int per_page);

    //107 人物https://api.unsplash.com/categories/6/photos?client_id=eb54e3b9dc12b9e0862b028b646085355d20b3442fbdfca4633ca0f7b01ef9a6&page=1&per_page=15
    @GET("categories/6/photos")
    Observable<List<UnsplashResult>> getPersonPhotos(@Query("client_id") String clientId,@Query("page") int page, @Query("per_page") int per_page);

    //108 科技https://api.unsplash.com/categories/7/photos?client_id=eb54e3b9dc12b9e0862b028b646085355d20b3442fbdfca4633ca0f7b01ef9a6&page=1&per_page=15
    @GET("categories/7/photos")
    Observable<List<UnsplashResult>> getTechnologyPhotos(@Query("client_id") String clientId,@Query("page") int page, @Query("per_page") int per_page);

    //照片的信息 https://api.unsplash.com/photos/oCbrjDECdK0?client_id=eb54e3b9dc12b9e0862b028b646085355d20b3442fbdfca4633ca0f7b01ef9a6
    @GET("photos/{id}")
    Observable<PhotoInfo> getPhotoInfo(@Path("id") String id,@Query("client_id") String clientId);


}
