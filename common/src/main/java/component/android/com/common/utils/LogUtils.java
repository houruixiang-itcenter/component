package component.android.com.common.utils;

import android.util.Log;

public class LogUtils {

    public static void LogI(String tag,String msg){
        Log.i(tag,msg);
    }

    public static void LogW(String tag,String msg){
        Log.w(tag,msg);
    }

    public static void LogD(String tag,String msg){
        Log.d(tag,msg);
    }

    public static void LogE(String tag,String msg){
        Log.e(tag,msg);
    }


}
