package helloworld.example.com.douyin.banner.presenter;

import helloworld.example.com.douyin.banner.BannersBean;
import helloworld.example.com.douyin.banner.model.BannersModel;
import helloworld.example.com.douyin.banner.model.IBannersModel;
import helloworld.example.com.douyin.net.OnNetLisenter;
import helloworld.example.com.douyin.view.IBannersActivity;

/**
 * Created by 李天祥 on 2018/2/22.
 */

public class BannersPresenter {
    private IBannersActivity iBannersActivity;
    private IBannersModel iBannersModel;

    public BannersPresenter(IBannersActivity iBannersActivity) {
        this.iBannersActivity = iBannersActivity;
        iBannersModel = new BannersModel();
    }

    public void getBanner(){
        iBannersModel.getBanners(new OnNetLisenter<BannersBean>() {
            @Override
            public void onSuccess(BannersBean bannersBean) {
                iBannersActivity.getBanners(bannersBean);
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
}
