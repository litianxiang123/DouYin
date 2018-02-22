package helloworld.example.com.douyin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import helloworld.example.com.douyin.app.MyImageLoader;
import helloworld.example.com.douyin.banner.BannersBean;
import helloworld.example.com.douyin.banner.presenter.BannersPresenter;
import helloworld.example.com.douyin.recommend.RecomBean;
import helloworld.example.com.douyin.recommend.adapter.RecomAdapter;
import helloworld.example.com.douyin.recommend.presenter.RecomPresenter;
import helloworld.example.com.douyin.search.SearchBean;
import helloworld.example.com.douyin.search.adapter.SearchAdapter;
import helloworld.example.com.douyin.search.presenter.SearchPresenter;
import helloworld.example.com.douyin.view.IBannersActivity;
import helloworld.example.com.douyin.view.IRecomActivity;
import helloworld.example.com.douyin.view.ISearchActivity;

public class SecondActivity extends AppCompatActivity implements ISearchActivity, IBannersActivity, IRecomActivity {

    private RecyclerView mRsRV;
    private SearchPresenter searchPresenter;
    private BannersPresenter bannersPresenter;
    private RecomPresenter recomPresenter;
    private Banner mBanner;
    private RecyclerView mGzRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        searchPresenter = new SearchPresenter(this);
        searchPresenter.getSearch();
        bannersPresenter = new BannersPresenter(this);
        bannersPresenter.getBanner();
        recomPresenter = new RecomPresenter(this);
        recomPresenter.getRecommend();
        initView();
    }

    private void initView() {
        mRsRV = (RecyclerView) findViewById(R.id.rsRV);
        mBanner = (Banner) findViewById(R.id.banner);
        mGzRv = (RecyclerView) findViewById(R.id.gzRv);
    }

    @Override
    public void getData(SearchBean searchBean) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        gridLayoutManager.setOrientation(gridLayoutManager.HORIZONTAL);
        mRsRV.setLayoutManager(gridLayoutManager);
        SearchAdapter adviceAdapter = new SearchAdapter(searchBean.getData(), this);
        mRsRV.setAdapter(adviceAdapter);
    }

    @Override
    public void getBanners(BannersBean bannersBean) {
        mBanner.setImageLoader(new MyImageLoader());
        List<BannersBean.BannerBean> banner = bannersBean.getBanner();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < banner.size(); i++) {
            String s = banner.get(i).getBanner_url().getUrl_list().get(0);
            list.add(s);
        }
        mBanner.setImages(list);
        mBanner.start();
    }


    @Override
    public void getRecommend(RecomBean recomBean) {
        mGzRv.setLayoutManager(new LinearLayoutManager(this));
        RecomAdapter recomAdapter = new RecomAdapter(recomBean.getCategory_list(), this);
        mGzRv.setAdapter(recomAdapter);


    }
}
