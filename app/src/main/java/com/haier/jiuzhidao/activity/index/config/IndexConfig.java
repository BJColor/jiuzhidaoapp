//package com.haier.jiuzhidao.activity.index.config;
//
//import android.content.Context;
//import android.content.pm.ApplicationInfo;
//import android.content.pm.PackageManager;
//import android.support.v4.util.SparseArrayCompat;
//import android.text.TextUtils;
//
//
//
//public class IndexConfig {
//
//    private static final String INDEX_META_DATA = "INDEX_CONFIG";
//
//    /**
//     * fragment配置
//     */
//    private static SparseArrayCompat<Class<? extends NewBaseFragment>> sIndexFragments = new SparseArrayCompat<>();
//
//    public static void config() {
//        Context ctx = App.get();
//        ApplicationInfo info = null;
//
//        try {
//            info = ctx.getPackageManager().getApplicationInfo(ctx.getPackageName(), PackageManager.GET_META_DATA);
//        } catch (PackageManager.NameNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        if (info == null) {
//            throw new UnsupportedOperationException();
//        }
//        String klassName = info.metaData.getString(INDEX_META_DATA);
//        if (TextUtils.isEmpty(klassName)) {
//            throw new UnsupportedOperationException("please config " + INDEX_META_DATA + " value");
//        }
//
//        if (klassName.startsWith(".")) {
//            klassName = App.get().getPackageName() + klassName;
//        }
//
//        MyLogUtil.d("geek", klassName);
//
//        try {
//            Class<?> klass = Class.forName(klassName);
//            klass.getDeclaredMethod("setup").invoke(null);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static Class<? extends NewBaseFragment> getFragment(int id) {
//        if (sIndexFragments.indexOfKey(id) < 0) {
//            throw new UnsupportedOperationException("cannot find fragment by " + id);
//        }
//        return sIndexFragments.get(id);
//    }
//
//    public static SparseArrayCompat<Class<? extends NewBaseFragment>> getFragments() {
//        return sIndexFragments;
//    }
//}
