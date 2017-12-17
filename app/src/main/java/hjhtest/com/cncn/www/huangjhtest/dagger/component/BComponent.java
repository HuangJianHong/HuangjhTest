package hjhtest.com.cncn.www.huangjhtest.dagger.component;

import dagger.Component;
import hjhtest.com.cncn.www.huangjhtest.activity.BActivity;
import hjhtest.com.cncn.www.huangjhtest.dagger.module.BModule;

/**
 * Created by Huangjh on 2017/12/17.
 */
@Component(modules = {BModule.class})
public interface BComponent {
    void inject(BActivity bActivity);


//    public  static BComponent getInstance(){
//        return DaggerBComponent.builder().applicationComponent()
//    }

}
