package helloworld.example.com.douyin.search.model;

import helloworld.example.com.douyin.net.Api;
import helloworld.example.com.douyin.net.OnNetLisenter;
import helloworld.example.com.douyin.net.RetrofitHelper;
import helloworld.example.com.douyin.net.ServiceApi;
import helloworld.example.com.douyin.search.SearchBean;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 李天祥 on 2018/2/22.
 */

public class SearchModel implements ISearchModel{

    @Override
    public void getSearch(final OnNetLisenter<SearchBean> onNetLisenter) {
        ServiceApi serviceApi = RetrofitHelper.getServiceApi(Api.HOST_URL);
        Flowable<SearchBean> searchBeanFlowable = serviceApi.searchBean();
        searchBeanFlowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<SearchBean>() {
                    @Override
                    public void accept(SearchBean searchBean) throws Exception {
                        onNetLisenter.onSuccess(searchBean);
                    }
                });
    }
}
