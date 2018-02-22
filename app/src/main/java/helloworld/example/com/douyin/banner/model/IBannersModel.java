package helloworld.example.com.douyin.banner.model;

import helloworld.example.com.douyin.banner.BannersBean;
import helloworld.example.com.douyin.net.OnNetLisenter;

/**
 * Created by 李天祥 on 2018/2/22.
 */

public interface IBannersModel {
    public void getBanners(OnNetLisenter<BannersBean> onNetLisenter);
}
