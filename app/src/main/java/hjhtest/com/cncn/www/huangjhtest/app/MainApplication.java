package hjhtest.com.cncn.www.huangjhtest.app;

import android.app.Application;

import hjhtest.com.cncn.www.huangjhtest.dagger.component.AComponent;
import hjhtest.com.cncn.www.huangjhtest.dagger.component.ApplicationComponent;
import hjhtest.com.cncn.www.huangjhtest.dagger.component.DaggerApplicationComponent;
import hjhtest.com.cncn.www.huangjhtest.dagger.module.AModule;

/**
 * User: xingzhi.wap
 * Date:16/5/17
 */
public class MainApplication extends Application {
    public static String appVersion;
    public static String appId;

    private ApplicationComponent mApplicationComponent;
    private static MainApplication  sApplication;
    private static AComponent mAComponent;

    public static MainApplication getInstance(){
        return  sApplication;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;

        mApplicationComponent = DaggerApplicationComponent.builder().build();
    }

    public ApplicationComponent getApplicationComponent(){
        return mApplicationComponent;
    }

    public AComponent getAcomponent(){
        if (mAComponent == null){
            mAComponent = mApplicationComponent.plus(new AModule());
        }
        return  mAComponent;
    }

}
