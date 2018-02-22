package helloworld.example.com.douyin.net;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 李天祥 on 2018/2/22.
 */

public class RetrofitHelper {
    private static OkHttpClient okHttpClient;
    private static ServiceApi serviceApi;

    static {
        getOkHttpClient();
    }

    public static OkHttpClient getOkHttpClient() {
        if (okHttpClient == null){
            synchronized (RetrofitHelper.class){
                if (okHttpClient == null){
                    okHttpClient = new OkHttpClient();
                }
            }
        }
        return okHttpClient;
    }

    public static <T> T createApi(Class<T> tClass,String url){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
        return retrofit.create(tClass);
    }

    public static ServiceApi getServiceApi(String s) {
        if (serviceApi == null){
            synchronized (ServiceApi.class){
                if (serviceApi == null){
                    serviceApi = createApi(ServiceApi.class,s);
                }
            }
        }
        return serviceApi;
    }
}
