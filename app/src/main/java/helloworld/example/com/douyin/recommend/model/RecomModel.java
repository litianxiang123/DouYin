package helloworld.example.com.douyin.recommend.model;

import helloworld.example.com.douyin.net.Api;
import helloworld.example.com.douyin.net.OnNetLisenter;
import helloworld.example.com.douyin.net.RetrofitHelper;
import helloworld.example.com.douyin.net.ServiceApi;
import helloworld.example.com.douyin.recommend.RecomBean;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 李天祥 on 2018/2/22.
 */

public class RecomModel implements IRecomModel{
    @Override
    public void getRecommend(final OnNetLisenter<RecomBean> onNetLisenter) {
        ServiceApi serviceApi = RetrofitHelper.getServiceApi(Api.HOST_URL);
        Flowable<RecomBean> recomBeanFlowable = serviceApi.recomBean();
        recomBeanFlowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<RecomBean>() {
                    @Override
                    public void accept(RecomBean recomBean) throws Exception {
                        onNetLisenter.onSuccess(recomBean);
                    }
                });
    }
}
