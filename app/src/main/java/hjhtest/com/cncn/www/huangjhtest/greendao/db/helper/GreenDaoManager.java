package hjhtest.com.cncn.www.huangjhtest.greendao.db.helper;

import android.content.Context;

import hjhtest.com.cncn.www.huangjhtest.greendao.db.DaoMaster;
import hjhtest.com.cncn.www.huangjhtest.greendao.db.DaoSession;

/**
 * Created by  Hjh on 2018/2/5.
 * desc：
 */

public class GreenDaoManager {
    private static DaoMaster mDaoMaster;
    private static DaoSession mDaoSession;
    private static volatile GreenDaoManager mInstance = null;
    private static final String DB_NAME = "test05.db";

    private GreenDaoManager() {
    }

    public static void init(Context context) {
        DaoMaster.DevOpenHelper devOpenHelper = new
                DaoMaster.DevOpenHelper(context, DB_NAME);
        mDaoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        mDaoSession = mDaoMaster.newSession();
    }

    public static GreenDaoManager getInstance() {
        if (mInstance == null) {
            synchronized (GreenDaoManager.class) {
                if (mInstance == null) {
                    mInstance = new GreenDaoManager();
                }
            }
        }
        return mInstance;
    }

    public DaoSession getSession() {
        return mDaoSession;
    }
}