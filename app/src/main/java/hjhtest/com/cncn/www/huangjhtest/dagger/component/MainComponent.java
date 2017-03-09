package hjhtest.com.cncn.www.huangjhtest.dagger.component;

import dagger.Component;
import hjhtest.com.cncn.www.huangjhtest.activity.MainActivity;
import hjhtest.com.cncn.www.huangjhtest.activity.OtherActivity;
import hjhtest.com.cncn.www.huangjhtest.app.MainApplication;
import hjhtest.com.cncn.www.huangjhtest.dagger.PoetryScope;
import hjhtest.com.cncn.www.huangjhtest.dagger.module.PoetryModule;

/**
 * Created by T163 on 2017/3/7.
 */
//用@Component表示这个接口是一个连接器，能用@Component注解的只能是interface或者抽象类
//表示Componet会从MainModule类中拿那些用@provides注解的方法来生成需要注入的实例;
@PoetryScope
@Component(dependencies = ApplicationComponent.class, modules = { PoetryModule.class})      //有dependencies的，注意modules不要重复依赖；
public abstract  class  MainComponent {
    /**
     * 需要用到这个连接器的对象，就是这个对象里面有需要注入的属性
     * （被标记为@Inject的属性）
     * 这里inject表示注入的意思，这个方法名可以随意更改，但建议就
     * 用inject即可。
     */
    public abstract  void inject(MainActivity mainActivity);

    public abstract  void inject(OtherActivity otherActivity);

    private static MainComponent sComponent;

    public static MainComponent getInstance(){
        if (sComponent == null){
            sComponent = DaggerMainComponent.builder()
                    .applicationComponent(MainApplication.getInstance().getApplicationComponent()).build();
        }
        return sComponent;
    }






}
