package helloworld.example.com.douyin.recommend.presenter;

import helloworld.example.com.douyin.net.OnNetLisenter;
import helloworld.example.com.douyin.recommend.RecomBean;
import helloworld.example.com.douyin.recommend.model.IRecomModel;
import helloworld.example.com.douyin.recommend.model.RecomModel;
import helloworld.example.com.douyin.view.IRecomActivity;

/**
 * Created by 李天祥 on 2018/2/22.
 */

public class RecomPresenter {
    private IRecomActivity iRecomActivity;
    private IRecomModel iRecomModel;

    public RecomPresenter(IRecomActivity iRecomActivity) {
        this.iRecomActivity = iRecomActivity;
        iRecomModel = new RecomModel();
    }

    public void getRecommend(){
        iRecomModel.getRecommend(new OnNetLisenter<RecomBean>() {
            @Override
            public void onSuccess(RecomBean recomBean) {
                iRecomActivity.getRecommend(recomBean);
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
}
