package com.haier.jiuzhidao;

        import android.app.Activity;
        import android.os.Bundle;
        import android.support.annotation.Nullable;

        import com.haier.jiuzhidao.banben.ConstantUtil;
        import com.haier.jiuzhidao.banben.VersionConfig;
        import com.haier.jiuzhidao.banben.VersionInfo;


public class MainActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String baseUrl = VersionConfig.BASE_URL;
        String serviceHost = VersionConfig.SERVICE_HOST;
        String payUrl = VersionConfig.PAY_URL;

        if (ConstantUtil.VERSION_INFO == VersionInfo.NATION) {

        }
    }
}

