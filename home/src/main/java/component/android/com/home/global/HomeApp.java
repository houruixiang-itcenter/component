package component.android.com.home.global;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

import component.android.com.common.BuildConfig;
import component.android.com.common.base.BaseApp;
import component.android.com.component_base.ComponentServiceFactory;
import component.android.com.home.service.HomeFragmentService;

public class HomeApp extends BaseApp {


    @Override
    public void initMoudleApp(Application application) {
        if (BuildConfig.DEBUG){
            //打印日志
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
        ComponentServiceFactory.getInstance(this).setHomeFragmentService(new HomeFragmentService());
    }

    @Override
    public void initMoudleData(Application application) {

    }
}
