package helloworld.example.com.douyin.search.model;

import helloworld.example.com.douyin.net.OnNetLisenter;
import helloworld.example.com.douyin.search.SearchBean;

/**
 * Created by 李天祥 on 2018/2/22.
 */

public interface ISearchModel {

    public void getSearch(OnNetLisenter<SearchBean> onNetLisenter);
}
