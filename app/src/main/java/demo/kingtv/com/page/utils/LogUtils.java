package demo.kingtv.com.page.utils;


import android.util.Log;

import demo.kingtv.com.page.BuildConfig;

/**
 * @author gxj
 * @since 2017/3/15
 */

public class LogUtils {
    private static final boolean debug = BuildConfig.DEBUG;

    public static void v(String tag, String content) {
        if (debug) {
            Log.v(tag, content);
        }
    }

    public static void e(String tag, String content) {
        if (debug) {
            Log.e(tag, content);
        }
    }

    public static void i(String tag, String content) {
        if (debug) {
            Log.i(tag, content);
        }
    }

    public static void d(String tag, String content) {
        if (debug) {
            Log.d(tag, content);
        }
    }
}
