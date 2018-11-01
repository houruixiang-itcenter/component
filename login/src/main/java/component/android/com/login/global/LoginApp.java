package component.android.com.login.global;

import android.app.Application;
import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;

import component.android.com.common.BuildConfig;
import component.android.com.common.base.BaseApp;
import component.android.com.component_base.ComponentServiceFactory;
import component.android.com.login.service.LoginService;

public class LoginApp extends BaseApp {

    @Override
    public void initMoudleApp(Application application) {
        Log.i("LoginApp","initMoudleApp");
        if (BuildConfig.DEBUG){
            //打印日志
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
        ComponentServiceFactory.getInstance(this).setLoginService(new LoginService());
    }

    @Override
    public void initMoudleData(Application application) {

    }
}
