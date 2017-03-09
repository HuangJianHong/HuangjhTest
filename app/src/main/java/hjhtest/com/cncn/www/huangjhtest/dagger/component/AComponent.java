package hjhtest.com.cncn.www.huangjhtest.dagger.component;

import dagger.Subcomponent;
import hjhtest.com.cncn.www.huangjhtest.activity.AActivity;
import hjhtest.com.cncn.www.huangjhtest.dagger.AScope;
import hjhtest.com.cncn.www.huangjhtest.dagger.module.AModule;

/**
 * Created by T163 on 2017/3/9.
 */
@AScope
@Subcomponent(modules = AModule.class)
public interface AComponent {
    void inject(AActivity activity);
}
