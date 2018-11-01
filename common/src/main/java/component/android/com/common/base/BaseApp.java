package component.android.com.common.base;

import android.app.Application;

public abstract class BaseApp extends Application {

    public abstract void initMoudleApp(Application application);

    public abstract void initMoudleData(Application application);

}
