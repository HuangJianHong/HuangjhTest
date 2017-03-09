package hjhtest.com.cncn.www.huangjhtest.dagger.component;

import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Component;
import hjhtest.com.cncn.www.huangjhtest.dagger.module.AModule;
import hjhtest.com.cncn.www.huangjhtest.dagger.module.ApplicationModule;

/**
 * Created by T163 on 2017/3/9.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    Gson  getGson();                   //曝露Gson对象接口

    //AComponent plus();
    AComponent plus(AModule module);   //添加声明
}
