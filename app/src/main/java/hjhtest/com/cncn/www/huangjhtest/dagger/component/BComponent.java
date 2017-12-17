package hjhtest.com.cncn.www.huangjhtest.dagger.component;

import dagger.Component;
import hjhtest.com.cncn.www.huangjhtest.activity.BActivity;
import hjhtest.com.cncn.www.huangjhtest.app.MainApplication;
import hjhtest.com.cncn.www.huangjhtest.dagger.PoetryScope;
import hjhtest.com.cncn.www.huangjhtest.dagger.module.BModule;

/**
 * Created by Huangjh on 2017/12/17.
 */
@PoetryScope
@Component(dependencies =ApplicationComponent.class,  modules = {BModule.class})
public abstract  class  BComponent {
    public abstract void  inject(BActivity bActivity);

    private static BComponent bCompoent;

    public  static BComponent getInstance(){
        if (bCompoent == null){
            bCompoent =  DaggerBComponent.builder()
                    .applicationComponent(MainApplication.getInstance().getApplicationComponent()).build();
        }
        return  bCompoent;

    }

}
