package helloworld.example.com.douyin.search.presenter;

import helloworld.example.com.douyin.net.OnNetLisenter;
import helloworld.example.com.douyin.search.SearchBean;
import helloworld.example.com.douyin.search.model.ISearchModel;
import helloworld.example.com.douyin.search.model.SearchModel;
import helloworld.example.com.douyin.view.ISearchActivity;

/**
 * Created by 李天祥 on 2018/2/22.
 */

public class SearchPresenter {

    private ISearchActivity iSearchActivity;
    private ISearchModel iSearchModel;

    public SearchPresenter(ISearchActivity iSearchActivity) {
        this.iSearchActivity = iSearchActivity;
        iSearchModel = new SearchModel();
    }

    public void getSearch(){
        iSearchModel.getSearch(new OnNetLisenter<SearchBean>() {
            @Override
            public void onSuccess(SearchBean searchBean) {
                iSearchActivity.getData(searchBean);
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
}
