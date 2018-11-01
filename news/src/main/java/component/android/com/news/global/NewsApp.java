package component.android.com.news.global;

import android.app.Application;
import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;

import component.android.com.common.BuildConfig;
import component.android.com.common.base.BaseApp;
import component.android.com.component_base.ComponentServiceFactory;
import component.android.com.news.service.NewsFragmentService;

public class NewsApp extends BaseApp {
    @Override
    public void initMoudleApp(Application application) {
        Log.i("NewsApp","initMoudleApp");
        if (BuildConfig.DEBUG){
            //打印日志
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
        ComponentServiceFactory.getInstance(this)
                .setNewsFragmentService(new NewsFragmentService());
    }

    @Override
    public void initMoudleData(Application application) {

    }
}
