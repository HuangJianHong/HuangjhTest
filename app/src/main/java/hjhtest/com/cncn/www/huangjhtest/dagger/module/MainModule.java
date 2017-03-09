package hjhtest.com.cncn.www.huangjhtest.dagger.module;

import com.google.gson.Gson;

import dagger.Module;
import dagger.Provides;

/**
 * Created by T163 on 2017/3/9.
 */
@Module
public class MainModule {
    /**
     * @provides 注解表示这个方法是用来创建某个实例对象的,这里我们创建放回的Gson对象;
     * @return
     */
    @Provides
    public Gson provideGson(){
        return  new Gson();
    }

}
