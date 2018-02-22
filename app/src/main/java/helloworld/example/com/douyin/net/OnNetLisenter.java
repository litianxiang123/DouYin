package helloworld.example.com.douyin.net;

/**
 * Created by 李天祥 on 2018/2/22.
 */

public interface OnNetLisenter<T> {

    public void onSuccess(T t);

    public void onFailure(Exception e);
}
