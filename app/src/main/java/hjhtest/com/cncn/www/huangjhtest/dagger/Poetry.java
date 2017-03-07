package hjhtest.com.cncn.www.huangjhtest.dagger;

import javax.inject.Inject;

/**
 * Created by T163 on 2017/3/7.
 */

public class Poetry {
    private String mPemo;

    @Inject
    public Poetry(){
        mPemo ="生活就像海洋";
    }

    public String getPemo(){
        return  mPemo;
    }


}
