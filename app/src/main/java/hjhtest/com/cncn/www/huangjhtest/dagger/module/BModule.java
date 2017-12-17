package hjhtest.com.cncn.www.huangjhtest.dagger.module;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import hjhtest.com.cncn.www.huangjhtest.dagger.Poetry;

/**
 * Created by Huangjh on 2017/12/17.
 *
 * 同一个对象不同实例 @Named注解使用，和 AModule功能类似
 */
@Module
public class BModule  {

    @Named("A")
    @Provides
    public Poetry getPoetry(){
        return  new Poetry("陌上花开");
    }

    @Named("B")
    @Provides
    public  Poetry getAnotherPoetry(){
        return  new Poetry("待君归");
    }
}
