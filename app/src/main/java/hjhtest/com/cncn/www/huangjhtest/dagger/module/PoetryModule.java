package hjhtest.com.cncn.www.huangjhtest.dagger.module;

import dagger.Module;
import dagger.Provides;
import hjhtest.com.cncn.www.huangjhtest.dagger.Poetry;

/**
 * Created by T163 on 2017/3/9.
 */

@Module
public class PoetryModule {
    // @Module的优先级高于@Inject。

    /**
     * 这个方法需要一个String参数，在Daager2注入，这些参数也是注入形式的； 也就是要有其他地方提供的参数poems的生成，不然会造成编译出错；
     * @param poems
     * @return
     */
    @Provides
    public Poetry providesPoetry(String poems){
        return new Poetry(poems);
    }

    @Provides
    public String providePoems(){
        return  "只有意志坚强的人，才能到达彼岸";
    }
}
