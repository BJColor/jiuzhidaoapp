package com.haier.jiuzhidao.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.haier.jiuzhidao.utils.IMEUtil;

public abstract class NewBaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(getLayoutId(), container, false);
        if (autoHideIME()) {
            rootView = IMEUtil.wrap(rootView);
        }
        setup(rootView, savedInstanceState);

        return rootView;
    }

    protected abstract int getLayoutId();

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    protected boolean autoHideIME() {
        return false;
    }

    protected   void setup(View rootView, @Nullable Bundle savedInstanceState){

    }

}
