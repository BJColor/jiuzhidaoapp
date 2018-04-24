package com.haier.jiuzhidao.activity.index.factorys;

import android.support.v4.util.SparseArrayCompat;

import com.haier.jiuzhidao.R;
import com.haier.jiuzhidao.activity.index.config.IndexConfig;
import com.haier.jiuzhidao.activity.index.nation_fragment.Fragment_1_1;
import com.haier.jiuzhidao.activity.index.nation_fragment.Fragment_1_2;
import com.haier.jiuzhidao.activity.index.nation_fragment.Fragment_2_1;
import com.haier.jiuzhidao.activity.index.nation_fragment.Fragment_2_2;
import com.haier.jiuzhidao.base.NewBaseFragment;

public class CommunityFactory {

    public static void setup() {
        IndexConfig.PAGE_COUNT = 2;
        IndexConfig.PAGE_LAYOUT_ID = "mainactivity_nation_item_";
        IndexConfig.DEFAULT_PAGE_INDEX = 0;
        registerFragments(IndexConfig.getFragments());
    }

    private static void registerFragments(SparseArrayCompat<Class<? extends NewBaseFragment>> sIndexFragments) {
        sIndexFragments.put(R.id.mainactivity_nation_item_1_1, Fragment_1_1.class);//
        sIndexFragments.put(R.id.mainactivity_nation_item_1_2, Fragment_1_2.class);//
        sIndexFragments.put(R.id.mainactivity_nation_item_2_1, Fragment_2_1.class);//
        sIndexFragments.put(R.id.mainactivity_nation_item_2_2, Fragment_2_2.class);//
    }
}
