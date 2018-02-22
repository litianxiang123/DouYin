package helloworld.example.com.douyin.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by 李天祥 on 2018/2/22.
 */

public class Myapp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();

        Fresco.initialize(this);
    }
}
