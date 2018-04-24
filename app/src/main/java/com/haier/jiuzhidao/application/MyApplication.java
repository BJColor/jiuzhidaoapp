package com.haier.jiuzhidao.application;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

public class MyApplication extends Application {
    private static MyApplication sInstance = null;
    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        mContext = getApplicationContext();
//        config();
    }

    public static MyApplication get() {
        if (sInstance == null) {
            sInstance = new MyApplication();
        }
        return sInstance;
    }


//    public void config() {
//        try {
//            ApplicationInfo appInfo = getPackageManager().getApplicationInfo(getPackageName(),PackageManager.GET_META_DATA);
//            if (appInfo == null) {
//                return;
//            }
//            String klassName = appInfo.metaData.getString(ST);
//            if (klassName.equals(".ceshi")) {
//            } else if (klassName.equals(".yushengchan")) {
//            }
//
//        } catch (PackageManager.NameNotFoundException e) {
//            e.printStackTrace();
//        }
//    }

}
