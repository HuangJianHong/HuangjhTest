package hjhtest.com.cncn.www.huangjhtest.dagger.module;

import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by T163 on 2017/3/9.
 */
@Module
public class ApplicationModule {

    @Singleton
    @Provides
    public Gson provideGson(){
        return new Gson();
    }

}
