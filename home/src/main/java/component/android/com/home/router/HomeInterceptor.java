package component.android.com.home.router;

import android.content.Context;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.android.arouter.launcher.ARouter;

import component.android.com.common.utils.LogUtils;
import component.android.com.component_base.ComponentServiceFactory;

@Interceptor(priority = 1,name = "homeInterceptor")
public class HomeInterceptor implements IInterceptor {
    private Context context;

    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        switch (postcard.getPath()){
            case "/myhome/homeActivity":
                if (ComponentServiceFactory.getInstance(context).getLoginService().getLoginStatus()){
                    callback.onContinue(postcard);
                }else {
                    ARouter.getInstance().build("/login/loginActivity").navigation();
                    //callback.onInterrupt(new RuntimeException("请登录"));
                    //callback.onContinue(postcard);
                }
                break;
            default:
                callback.onContinue(postcard);
                break;
            //在每一个组件中添加一个navi的拦截器  逻辑在

        }
    }

    @Override
    public void init(Context context) {
        this.context = context;
    }
}
