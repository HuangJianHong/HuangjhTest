package hjhtest.com.cncn.www.huangjhtest.dagger.module;

import dagger.Module;
import dagger.Provides;
import hjhtest.com.cncn.www.huangjhtest.dagger.AScope;
import hjhtest.com.cncn.www.huangjhtest.dagger.Poetry;

/**
 * Created by T163 on 2017/3/9.
 */
@Module
public class AModule {

    @AScope
    @Provides
    public Poetry getPoetry(){
        return  new Poetry("万物美好");
    }


}
