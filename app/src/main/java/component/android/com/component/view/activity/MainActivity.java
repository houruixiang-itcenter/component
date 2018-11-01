package component.android.com.component.view.activity;

import android.annotation.SuppressLint;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;

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
                if (loginService.getLoginStatus()){
                    //跳转home page
                    Toast.makeText(MainActivity.this,"跳转home--success",Toast.LENGTH_SHORT).show();
                }else {
                    //跳转登录页面
                    ARouter.getInstance().build("/login/loginActivity").navigation();
                }
            }
        });
    }

    private void initBaseView() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        ComponentServiceFactory.getInstance(this)
                .getHomeFragmentService().newFragment(this,R.id.content,supportFragmentManager,null,null);

    }
}
