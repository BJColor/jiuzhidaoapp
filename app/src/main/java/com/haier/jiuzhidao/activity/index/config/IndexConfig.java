package com.haier.jiuzhidao.activity.index.config;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.support.v4.util.SparseArrayCompat;
import android.text.TextUtils;

import com.haier.jiuzhidao.application.MyApplication;
import com.haier.jiuzhidao.base.NewBaseFragment;


public class IndexConfig {

    private static final String INDEX_META_DATA = "INDEX_CONFIG";
    /** viewpager页大小*/
    public static int PAGE_COUNT;
    /** viewpager每页的itemview id*/
    public static String PAGE_LAYOUT_ID;

    /** 默认显示第几页*/
    public static int DEFAULT_PAGE_INDEX;


    /**
     * fragment配置
     */
    private static SparseArrayCompat<Class<? extends NewBaseFragment>> sIndexFragments = new SparseArrayCompat<>();

    public static void config() {
        Context ctx=MyApplication.get();
        ApplicationInfo info = null;

        try {
            info = ctx.getPackageManager().getApplicationInfo(ctx.getPackageName(), PackageManager.GET_META_DATA);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        if (info == null) {
            throw new UnsupportedOperationException();
        }
        String klassName = info.metaData.getString(INDEX_META_DATA);
        if (TextUtils.isEmpty(klassName)) {
            throw new UnsupportedOperationException("please config " + INDEX_META_DATA + " value");
        }

        if (klassName.startsWith(".")) {
            klassName = MyApplication.get().getPackageName() + klassName;
        }

        try {
            Class<?> klass = Class.forName(klassName);
            klass.getDeclaredMethod("setup").invoke(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Class<? extends NewBaseFragment> getFragment(int id) {
        if (sIndexFragments.indexOfKey(id) < 0) {
            throw new UnsupportedOperationException("cannot find fragment by " + id);
        }
        return sIndexFragments.get(id);
    }

    public static SparseArrayCompat<Class<? extends NewBaseFragment>> getFragments() {
        return sIndexFragments;
    }
}
