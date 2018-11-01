package component.android.com.login.service;

import component.android.com.component_base.base.ILoginService;
import component.android.com.login.util.AccountUtils;

public class LoginService implements ILoginService {
    @Override
    public boolean getLoginStatus() {
        return AccountUtils.getInstance().isAccountStatus();
    }

    @Override
    public int getLoginUserId() {
        return 0;
    }
}
