package helloworld.example.com.douyin.recommend.model;

import helloworld.example.com.douyin.net.OnNetLisenter;
import helloworld.example.com.douyin.recommend.RecomBean;

/**
 * Created by 李天祥 on 2018/2/22.
 */

public interface IRecomModel {
    public void getRecommend(OnNetLisenter<RecomBean> onNetLisenter);
}
