package component.android.com.login.router;

import android.content.Context;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;

import component.android.com.common.utils.LogUtils;

@Interceptor(priority = 2,name = "loginInterceptor")
public class LoginInterceptor implements IInterceptor {
    private Context context;

    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        switch (postcard.getPath()){
            case "/login/loginActivity":
                LogUtils.LogI("loginInterceptor","请点击登录按钮");
                callback.onContinue(postcard);
                break;
            default:
                callback.onContinue(postcard);
            //在每一个组件中添加一个navi的拦截器  逻辑在

        }
    }

    @Override
    public void init(Context context) {
        this.context = context;
    }
}
