package helloworld.example.com.douyin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.youth.banner.Banner;

import helloworld.example.com.douyin.search.SearchBean;
import helloworld.example.com.douyin.search.presenter.SearchPresenter;
import helloworld.example.com.douyin.view.ISearchActivity;

public class SecondActivity extends AppCompatActivity implements ISearchActivity {

    private RecyclerView mRsRV;
    private SearchPresenter searchPresenter;
    private Banner mBanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        searchPresenter = new SearchPresenter(this);
        searchPresenter.getSearch();
        initView();
    }

    private void initView() {
        mRsRV = (RecyclerView) findViewById(R.id.rsRV);
        mBanner = (Banner) findViewById(R.id.banner);
    }

    @Override
    public void getData(SearchBean searchBean) {
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
//        gridLayoutManager.setOrientation(gridLayoutManager.HORIZONTAL);
//        mRsRV.setLayoutManager(gridLayoutManager);
//        SearchAdapter adviceAdapter = new SearchAdapter(searchBean.getData(), this);
//        mRsRV.setAdapter(adviceAdapter);
    }
}
