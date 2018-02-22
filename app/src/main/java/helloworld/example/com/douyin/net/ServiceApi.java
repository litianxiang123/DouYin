package helloworld.example.com.douyin.net;

import helloworld.example.com.douyin.banner.BannersBean;
import helloworld.example.com.douyin.search.SearchBean;
import io.reactivex.Flowable;
import retrofit2.http.GET;

/**
 * Created by 李天祥 on 2018/2/22.
 */

public interface ServiceApi {

    //热搜内容  https://api.amemv.com/aweme/v1/hot/search/
   @GET("aweme/v1/hot/search/")
    Flowable<SearchBean> searchBean();

    //轮播图  http://api.amemv.com/aweme/v1/find/?aid=1128
    @GET("aweme/v1/find/?aid=1128")
    Flowable<BannersBean> bannersBean();

}
