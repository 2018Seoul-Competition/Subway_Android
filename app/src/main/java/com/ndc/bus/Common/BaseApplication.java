package com.ndc.bus.Common;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import com.ndc.bus.Di.AppModule;
import com.ndc.bus.Di.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class BaseApplication extends Application implements HasActivityInjector{

    @Inject
    DispatchingAndroidInjector<Activity> activityInjector;

    public static boolean DEBUG;
    private final String key = "EhxzLlLWZRRobmy7a5zscgcLA8u9%2B1EKLE1m439UhFUuw7nGChFGGYjH5q8JNnOmI3ma7NYtPPH9xo75Sipt%2FA%3D%3D";

    public static String APP_NAME = "BUS_ANDROID";

    public static String CHANNEL_ID = "";
    public static String CHANNEL_NAME = "CHANNEL_FOR_BUS_ANDROID";
    public static int ARRIVAL_NOTI_ID = 0;

    public static String BEFORE_LONG = "BEFORE_LONG";
    public static String BEFORE_LATI = "BEFORE_LATI";
    public static String DEST_LONG = "DEST_LONG";
    public static String DEST_LATI = "DEST_LATI";

    public static String VEH_NM = "VEH_NM";
    public static String DEST_STATION_NAME = "DEST_STATION_NAME";

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build().inject(this);
        this.DEBUG = isDebuggable(this);
    }

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return activityInjector;
    }

    /**
     * Returns whether currently debug mode is on or not.
     *
     * @param context
     * @return
     */
    private boolean isDebuggable(Context context) {
        boolean debuggable = true;

        PackageManager pm = context.getPackageManager();
        try {
            ApplicationInfo appinfo = pm.getApplicationInfo(context.getPackageName(), 0);
            debuggable = (0 != (appinfo.flags & ApplicationInfo.FLAG_DEBUGGABLE));
        } catch (PackageManager.NameNotFoundException e) {
            /* debuggable variable will remain false */
        }

        return debuggable;
    }

    public String getKey() {
        return key;
    }
}
