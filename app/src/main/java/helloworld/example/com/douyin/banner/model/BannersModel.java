package helloworld.example.com.douyin.banner.model;

import helloworld.example.com.douyin.banner.BannersBean;
import helloworld.example.com.douyin.net.Api;
import helloworld.example.com.douyin.net.OnNetLisenter;
import helloworld.example.com.douyin.net.RetrofitHelper;
import helloworld.example.com.douyin.net.ServiceApi;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 李天祥 on 2018/2/22.
 */

public class BannersModel implements IBannersModel{
    @Override
    public void getBanners(final OnNetLisenter<BannersBean> onNetLisenter) {
        ServiceApi serviceApi = RetrofitHelper.getServiceApi(Api.HOST_URL);
        Flowable<BannersBean> bannersBeanFlowable = serviceApi.bannersBean();
        bannersBeanFlowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<BannersBean>() {
                    @Override
                    public void accept(BannersBean bannersBean) throws Exception {
                        onNetLisenter.onSuccess(bannersBean);
                    }
                });


    }
}
