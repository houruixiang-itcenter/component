package component.android.com.login.util;

public class AccountUtils {

    private static volatile AccountUtils accountUtils;

    public static AccountUtils getInstance(){
        if (accountUtils == null){
            synchronized (AccountUtils.class){
                if (accountUtils == null){
                    accountUtils = new AccountUtils();
                }
            }
        }
        return accountUtils;
    }

    private boolean accountStatus;


    public boolean isAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(boolean accountStatus) {
        this.accountStatus = accountStatus;
    }
}
