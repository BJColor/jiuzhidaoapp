package com.haier.jiuzhidao.application;

import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

public class MyApplication extends Application {
    public static final String ST = "ST_DATA";

    @Override
    public void onCreate() {
        super.onCreate();
        config();
    }

    public void config() {
        try {
            ApplicationInfo appInfo = getPackageManager().getApplicationInfo(getPackageName(),PackageManager.GET_META_DATA);
            if (appInfo == null) {
                return;
            }
            String klassName = appInfo.metaData.getString(ST);
            if (klassName.equals(".ceshi")) {
            } else if (klassName.equals(".yushengchan")) {
            }

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
