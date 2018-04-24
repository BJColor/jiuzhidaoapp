package com.haier.jiuzhidao.activity.index;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.util.SparseArrayCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.haier.jiuzhidao.R;
import com.haier.jiuzhidao.activity.index.config.IndexConfig;
import com.haier.jiuzhidao.activity.index.widgets.DotIndicatorView;
import com.haier.jiuzhidao.activity.index.widgets.IWithViewPager;
import com.haier.jiuzhidao.base.NewBaseFragment;
import com.haier.jiuzhidao.utils.ComFragmentHelper;

import static com.haier.jiuzhidao.activity.index.config.IndexConfig.PAGE_COUNT;

public class MainActivity extends FragmentActivity implements IWithViewPager {

    private ViewPager mViewPager;
    private DotIndicatorView mIndicator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        IndexConfig.config();
        setContentView(R.layout.activity_mainwite_index_new);

        findview();
        setupViewPager();
        setupFragments();
    }

    private void setupFragments() {
        // 使用HierarchyChangeListener的目的是防止在viewpager的itemview还没有准备好就去inflateFragment
        // 带来的问题ce
        mViewPager.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() {
            @Override
            public void onChildViewAdded(View parent, View child) {
                if (((ViewGroup) parent).getChildCount() < PAGE_COUNT) {
                    return;
                }
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                SparseArrayCompat<Class<? extends NewBaseFragment>> array = IndexConfig.getFragments();
                int size = array.size();
                NewBaseFragment item;
                for (int i = 0; i < size; i++) {
                    item = ComFragmentHelper.newFragment(array.valueAt(i), null);
                    ft.replace(array.keyAt(i), item, item.getClass().getName());
                }
                ft.commitAllowingStateLoss();
            }

            @Override
            public void onChildViewRemoved(View parent, View child) {

            }
        });
    }

    private void setupViewPager() {
        mViewPager.setOffscreenPageLimit(PAGE_COUNT);
        mViewPager.setAdapter(new IndexPagerAdapter());

        mIndicator.create(PAGE_COUNT);
        mIndicator.setupWithViewPager(mViewPager);
        showIndicator(true);
        withViewPager(mViewPager);

//        mViewPager.addOnPageChangeListener(new ViewPagerChangeAdapter() {
//            @Override
//            public void onPageSelected(int position) {
//                if (position == 0) {
////                    MobEventHelper.onEvent(Demo4Activity.this, "UI2_index_personal_center");//统计
//                }
//            }
//        });

        mViewPager.setCurrentItem(IndexConfig.DEFAULT_PAGE_INDEX);//设置当前显示标签页为第一页
    }

    private void findview() {
        mViewPager = (ViewPager) findViewById(R.id.viewpager_my);
        mIndicator = (DotIndicatorView) findViewById(R.id.indicator);
    }


    @Override
    public void showIndicator(boolean show) {
        mIndicator.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @Override
    public void withViewPager(ViewPager viewPager) {
        mIndicator.setupWithViewPager(viewPager);
    }


    /**
     * 首页viewpager adapter
     */
    public class IndexPagerAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            int layoutId = getResources().getIdentifier(IndexConfig.PAGE_LAYOUT_ID + position, "layout", getPackageName());
            if (layoutId == 0) {
                throw new UnsupportedOperationException("layout not found!");
            }
            View itemLayout = LayoutInflater.from(MainActivity.this).inflate(layoutId, container, false);
            container.addView(itemLayout);
            return itemLayout;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
