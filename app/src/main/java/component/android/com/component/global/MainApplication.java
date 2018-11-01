package component.android.com.component.global;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

import component.android.com.common.BuildConfig;
import component.android.com.common.base.BaseApp;
import component.android.com.component_base.base.AppConfig;

public class MainApplication extends BaseApp {

    @Override
    public void onCreate() {
        super.onCreate();

        initRouter();
        initMoudleApp(this);
        initMoudleData(this);
    }

    private void initRouter() {
        if (BuildConfig.DEBUG){
            //打印日志
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
    }
    @Override
    public void initMoudleApp(Application application) {
        for (String moduleApp : AppConfig.moduleApps) {
            try {
                Class clazz = Class.forName(moduleApp);
                BaseApp baseApp = (BaseApp) clazz.newInstance();
                baseApp.initMoudleApp(this);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void initMoudleData(Application application) {
        for (String moduleApp : AppConfig.moduleApps) {
            try {
                Class clazz = Class.forName(moduleApp);
                BaseApp baseApp = (BaseApp) clazz.newInstance();
                baseApp.initMoudleData(this);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
    }
}
