package hjhtest.com.cncn.www.huangjhtest.dagger.component;

import dagger.Component;
import hjhtest.com.cncn.www.huangjhtest.activity.MainActivity;
import hjhtest.com.cncn.www.huangjhtest.dagger.module.MainModule;
import hjhtest.com.cncn.www.huangjhtest.dagger.module.PoetryModule;

/**
 * Created by T163 on 2017/3/7.
 */
//用@Component表示这个接口是一个连接器，能用@Component注解的只能是interface或者抽象类
//表示Componet会从MainModule类中拿那些用@provides注解的方法来生成需要注入的实例;
@Component(modules = {MainModule.class , PoetryModule.class})
public interface MainComponent {
    /**
     * 需要用到这个连接器的对象，就是这个对象里面有需要注入的属性
     * （被标记为@Inject的属性）
     * 这里inject表示注入的意思，这个方法名可以随意更改，但建议就
     * 用inject即可。
     */
    void inject(MainActivity mainActivity);
}
