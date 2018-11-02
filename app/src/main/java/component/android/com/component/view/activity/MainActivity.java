package component.android.com.component.view.activity;

import android.annotation.SuppressLint;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;

import component.android.com.common.utils.LogUtils;
import component.android.com.component.R;
import component.android.com.component_base.ComponentServiceFactory;
import component.android.com.component_base.base.ILoginService;

public class MainActivity extends AppCompatActivity {

    private ILoginService loginService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginService = ComponentServiceFactory.getInstance(MainActivity.this).getLoginService();

        initBaseView();
        initClick();
    }

    private void initClick() {
        findViewById(R.id.btn_nav_home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build("/home/homeActivity").navigation(MainActivity.this, new NavCallback() {
                    @Override
                    public void onArrival(Postcard postcard) {
                        LogUtils.LogI("loginInterceptor","done");
                    }

                    @Override
                    public void onFound(Postcard postcard) {
                        //super.onFound(postcard);
                        LogUtils.LogI("loginInterceptor","found");
                    }

                    @Override
                    public void onLost(Postcard postcard) {
                        //super.onLost(postcard);
                        LogUtils.LogI("loginInterceptor","lost");
                    }

                    @Override
                    public void onInterrupt(Postcard postcard) {
                        //super.onInterrupt(postcard);
                        LogUtils.LogI("loginInterceptor","interrupt");
                    }
                });
            }
        });
    }

    private void initBaseView() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        ComponentServiceFactory.getInstance(this)
                .getHomeFragmentService().newFragment(this,R.id.content,supportFragmentManager,null,null);

    }
}
