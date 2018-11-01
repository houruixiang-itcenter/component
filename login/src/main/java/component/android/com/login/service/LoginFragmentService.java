package component.android.com.login.service;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import component.android.com.component_base.base.IFragmentService;
import component.android.com.login.view.fragment.LginHomeFragment;

public class LoginFragmentService implements IFragmentService {


    @Override
    public Fragment getFragment(String tag) {
        return new LginHomeFragment();
    }

    @Override
    public void newFragment(Activity activity, int resId, FragmentManager fragmentManager, Bundle bundle, String tag) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(resId,new LginHomeFragment(),tag);
        transaction.commit();
    }
}
