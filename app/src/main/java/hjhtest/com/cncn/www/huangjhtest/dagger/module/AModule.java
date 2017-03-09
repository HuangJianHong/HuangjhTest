package hjhtest.com.cncn.www.huangjhtest.dagger.module;

import dagger.Module;
import dagger.Provides;
import hjhtest.com.cncn.www.huangjhtest.dagger.AScope;
import hjhtest.com.cncn.www.huangjhtest.dagger.Poetry;
import hjhtest.com.cncn.www.huangjhtest.dagger.qualifier.PoetryQualifier;

/**
 * Created by T163 on 2017/3/9.
 */
@Module
public class AModule {

    @PoetryQualifier("A")
    @AScope
    @Provides
    public Poetry getPoetry(){
        return  new Poetry("万物美好");
    }

    //添加不同的Poetry实例;
    @PoetryQualifier("B")
    @AScope
    @Provides
    public Poetry getOtherPoetry(){
        return  new Poetry("我在中间");
    }


}
